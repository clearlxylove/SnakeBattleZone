package com.kob.backend.service.impl.user.bot;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.BotMapper;
import com.kob.backend.pojo.Bot;
import com.kob.backend.pojo.User;
import com.kob.backend.service.impl.utils.UserDetailsImpl;
import com.kob.backend.service.user.bot.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AddServiceImpl implements AddService {

    @Autowired
    private BotMapper botMapper;

    @Override
    public Map<String, String> add(Map<String, String> data) {
        //获取当前登录用户的身份验证令牌。
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        //将身份验证令牌中的主体（通常是用户信息）转换为 UserDetailsImpl 对象。
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        //从 UserDetailsImpl 对象中获取用户对象
        User user = loginUser.getUser();

        String title = data.get("title");
        String descripion =data.get("descripion");
        String content = data.get("content");

        Map<String, String> map = new HashMap<>();

        if(title == null || title.length() == 0){
            map.put("error_message","标题不能为空");
            return map;
        }

        if(title.length() > 100){
            map.put("error_message","标题长度不能大于100");
            return map;
        }

        if(descripion == null || descripion.length() == 0){
            descripion = "这个用户很懒什么也留下";
        }

        if(descripion.length() > 300){
            map.put("error_message","Bot的描述长度不能大于300");
            return map;
        }

        if(content == null || content.length() == 0){
            map.put("error_message","代码不能为空");
            return map;
        }

        if(content.length() > 10000){
            map.put("error_message","代码长度不能超过10000");
            return map;
        }

        QueryWrapper<Bot>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user.getId());
        if(botMapper.selectCount(queryWrapper) > 10) {
            map.put("error_message","每个用户最多只能创建10个Bot!");
            return map;
        }

        Date now =new Date();
        Bot bot = new Bot(null, user.getId(), title,descripion,content,now,now);

        botMapper.insert(bot);
        map.put("error_message","success");

        return map;
    }
}
