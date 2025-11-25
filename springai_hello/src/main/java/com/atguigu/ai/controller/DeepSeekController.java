package com.atguigu.ai.controller;

import groovy.transform.AutoClone;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class DeepSeekController {

    @Autowired
    private OpenAiChatModel chatModel;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "message", defaultValue = "hello")
                            String message) {
        String result = chatModel.call(message);
        System.out.println(result);
        return  result;
    }

    @GetMapping("/hello2")
    public Flux<String> hello2(@RequestParam(value = "message", defaultValue = "hello")
                        String message) {
        Flux<String> result = chatModel.stream(message);
        return  result;
    }

}
