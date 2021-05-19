package com.linjr.service;

public interface RabbitProducerService {

    void sendDemoQueue();

    void sendFanout();

    void sendTopicTopicAB();

    void sendTopicTopicB();

    void sendTopicTopicBC();
}
