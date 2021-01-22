package com.dupake.demo.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Created on 2020/9/22 11:32 上午
 *
 * @author barry
 * Description:
 */
@Slf4j
@Component
public class StreamReceiver {

    @StreamListener(value = Sink.MY_INPUT_1, condition = "headers['version']=='1.0'")
    public void receiveSucceed_v1(@Payload String message) {
        String msg = "StreamReceiver v1: " + message;
        log.error(msg);
    }

    @StreamListener(value = Sink.MY_INPUT_1, condition = "headers['version']=='2.0'")
    public void receiveSucceed_v2(String message) {
        System.out.println("StreamReceiver v2: "+message);
        log.error("StreamReceiver v2: {}", message);
    }

}