package com.kob.backend.service.impl.user.account;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.UserMapper;
import com.kob.backend.pojo.User;
import com.kob.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> register(String username, String password, String confirmPassword) {
        Map<String, String> map = new HashMap<String, String>();
        if (username==null){
            map.put("error_message","用户名不能为空");
            return map;
        }
        if (password==null||confirmPassword==null){
            map.put("error_message","密码不能为空");
            return map;
        }
        username = username.trim();
        if (username.length()== 0){
            map.put("error_message","用户名不能为空");
            return map;
        }
        if(password.length()==0||confirmPassword.length()==0){
            map.put("error_message","密码不能为空");
            return map;
        }

        if(username.length()>100){
            map.put("error_message","用户名长度不能大于100");
            return map;
        }
        if(password.length()>100||confirmPassword.length()>100){
            map.put("error_message","密码长度不能大于100");
            return map;
        }

        if(!password.equals(confirmPassword)){
            map.put("error_message","两次密码输入不一样");
            return map;
        }

        QueryWrapper<User>queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("username",username);
        List<User> users = userMapper.selectList(queryWrapper);
        if (!users.isEmpty()){
            map.put("error_message","用户名已存在");
            return map;
        }

        String encodedPassword = passwordEncoder.encode(password);
        String photo = "https://cdn.acwing.com/media/user/profile/photo/449308_lg_38568d841c.jpg";
        User user = new User(null,username,encodedPassword,photo,1500);
        userMapper.insert(user);

        map.put("error_message","success");
        return map;
    }
}
