package com.dreamsoft.customer.web;

import com.dreamsoft.customer.config.GlobalConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@AllArgsConstructor
@RequestMapping("/customers/config")
@RefreshScope
public class ConfigTestCOntroller {

    @Autowired
    private GlobalConfig globalConfig;


    @GetMapping("/global")
    public GlobalConfig getGlobalConfig(){
        return globalConfig;
    }
}
