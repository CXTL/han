package com.dupake.admin.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created on 2020/9/22 11:33 上午
 *
 * @author barry
 * Description:
 */
@Service
public class StreamSender {

    @Autowired
    private Source source;

    public String sendSucceed() {
        Date date = new Date();
        source.message().send(MessageBuilder.withPayload("Hello World..." + date)
                .setHeader("routingKey", "login.user.succeed")
                .setHeader("version", "1.0")

                .build());
        return "OK " + date;
    }

    public String sendHeader() {
        Date date = new Date();
        source.message().send(MessageBuilder.withPayload("Hello World..." + date)
                .setHeader("routingKey", "login.user.succeed")
                .setHeader("version", "2.0")
                .setHeader("x-delay", 5000)
                .build());
        return "OK " + date;
    }

    public String sendFailed() {
        Date date = new Date();
        source.message().send(MessageBuilder.withPayload("Hello World..." + date)
                .setHeader("routingKey", "login.user.failed")
                .build());
        return "OK " + date;
    }
}
