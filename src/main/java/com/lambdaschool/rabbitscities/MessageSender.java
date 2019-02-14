package com.lambdaschool.rabbitscities;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;


@Slf4j
@Service
public class MessageSender
{
    private final RabbitTemplate rt;
    private final CitiesRepository cityrepos;

    public MessageSender(RabbitTemplate rt, CitiesRepository cityrepos)
    {
        this.rt = rt;
        this.cityrepos = cityrepos;
    }

    @Scheduled(fixedDelay = 3000L)
    public void sendMesage()
    {
        ArrayList<City> cities = new ArrayList<City>();

        for (City c: cities)
        {
            int rand = new Random().nextInt(10);
            boolean randBool = new Random().nextBoolean();
            final Message message = new Message(c.toString(), rand, randBool);

            if (rand <= 5)
            {
                log.info("Sending message HIGH");
                rt.convertAndSend(RabbitscitiesApplication.QUEUE_NAME_HIGH, message);
            }
            else
            {
                log.info("Sending message LOW");
                rt.convertAndSend(RabbitscitiesApplication.QUEUE_NAME_LOW, message);
            }
        }
    }
}
