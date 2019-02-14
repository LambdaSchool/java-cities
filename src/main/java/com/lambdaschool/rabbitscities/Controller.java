package com.lambdaschool.rabbitscities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@Slf4j
@RestController
public class Controller
{
    private final CitiesRepository cityrepos;
    private final RabbitTemplate rt;

    public Controller(CitiesRepository cityrepos, RabbitTemplate rt)
    {
        this.cityrepos = cityrepos;
        this.rt = rt;
    }

    @GetMapping("/cities")
    public void findCities()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.addAll(cityrepos.findAll());

        for (City c: cities)
        {
            int rand = new Random().nextInt(10);
            boolean randBool = new Random().nextBoolean();
            final Message message = new Message(c.toString(), rand, randBool);

            log.info(" Sending Message ..... ");
            if (rand <= 5)
            {
                rt.convertAndSend(RabbitscitiesApplication.QUEUE_NAME_HIGH, message);
            }
            else
            {
                rt.convertAndSend(RabbitscitiesApplication.QUEUE_NAME_LOW, message);
            }
        }
    }
}
