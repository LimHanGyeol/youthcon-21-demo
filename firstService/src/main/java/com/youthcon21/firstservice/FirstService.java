package com.youthcon21.firstservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class FirstService {

    private static final Logger log = LoggerFactory.getLogger(FirstService.class);
    private static final String SECOND_SERVICE_PATH = "http://localhost:8081/second-service";

    private final RestTemplate restTemplate;

    public FirstService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String sendSecond() {
        log.info("send: first service");

        String requestUrl = getRandomSecondServiceUrl();
        String response = restTemplate.getForObject(requestUrl, String.class);

        log.info("receive: response - {}", response);
        return "finished first service";
    }

    private String getRandomSecondServiceUrl() {
        int result = ThreadLocalRandom.current().nextInt(1, 10) + 1;
        log.info("result: {}", result);
        if (result <= 5) {
            return SECOND_SERVICE_PATH + "/failure";
        }
        return SECOND_SERVICE_PATH + "/receive";
    }
}
