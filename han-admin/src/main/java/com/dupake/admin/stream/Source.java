package com.dupake.admin.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * Created on 2020/9/22 11:30 上午
 *
 * @author barry
 * Description: 取得 destination: minestream
 */
public interface Source {

    String OUTPUT = "test-stream";

    @Output(OUTPUT)
    MessageChannel message();


}
