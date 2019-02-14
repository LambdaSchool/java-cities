package com.lambdaschool.rabbitscities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class MessageListener
{
    @RabbitListener(queues = RabbitscitiesApplication.QUEUE_NAME_HIGH)
    public void receiveMessage(Message m)
    {
        log.info(" Received Message: {}", m.toString());
    }
}
