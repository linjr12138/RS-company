package com.linjr.controller;

import com.linjr.service.RabbitProducerService;
import com.linjr.utils.DataResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "RabbitMq消息队列管理",description = "RabbitMq消息队列管理接口")
public class RabbitMqController {

    @Autowired
    private RabbitProducerService rabbitProducerService;

    @GetMapping("/sendDemoQueue")
    public DataResult sendDemoQueue(){
        DataResult result = DataResult.success();
        rabbitProducerService.sendDemoQueue();;
        return result;
    }

    @GetMapping("/sendFanout")
    public DataResult sendFanout(){
        DataResult result = DataResult.success();
        rabbitProducerService.sendFanout();
        return result;
    }

    @GetMapping("/sendTopicTopicAB")
    public DataResult sendTopicTopicAB(){
        DataResult result = DataResult.success();
        rabbitProducerService.sendTopicTopicAB();
        return result;
    }

    @GetMapping("/sendTopicTopicB")
    public DataResult sendTopicTopicB(){
        DataResult result = DataResult.success();
        rabbitProducerService.sendTopicTopicB();
        return result;
    }

    @GetMapping("/sendTopicTopicBC")
    public DataResult sendTopicTopicBC(){
        DataResult result = DataResult.success();
        rabbitProducerService.sendTopicTopicBC();
        return result;
    }

}
