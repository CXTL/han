package com.dupake.admin.controller;

import com.dupake.admin.stream.Source;
import com.dupake.admin.stream.StreamSender;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Api(tags = "StreamController")
@RestController
@RequestMapping(value = "admin")
public class StreamController {

    @Autowired
    private StreamSender streamSender;

    @GetMapping("sendSucceed")
    public String sendSucceed() {
        return streamSender.sendSucceed();
    }

    @GetMapping("sendSucceed/v2")
    public String sendHeader() {
        return streamSender.sendHeader();
    }

    @GetMapping("/failed")
    public String sendFailed() {
        return streamSender.sendFailed();
    }
}
