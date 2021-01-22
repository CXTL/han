package com.dupake.demo.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created on 2020/9/22 5:26 下午
 *
 * @author barry
 * Description:
 */
public interface Sink {
    String MY_INPUT_1 = "test-stream";

    @Input(MY_INPUT_1)
    SubscribableChannel sub1();
}
