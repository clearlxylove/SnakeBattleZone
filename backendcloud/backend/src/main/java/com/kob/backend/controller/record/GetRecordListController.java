package com.kob.backend.controller.record;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kob.backend.service.impl.record.GetRecordListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetRecordListController {
    @Autowired
    private GetRecordListServiceImpl getRecordListService;

    @GetMapping("/api/record/getlist/")
    JSONObject getList(@RequestParam Map<String,String>data){
        Integer page = Integer.parseInt(data.get("page"));
        return getRecordListService.getList(page);
    }
}
