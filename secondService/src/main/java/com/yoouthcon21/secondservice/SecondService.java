package com.yoouthcon21.secondservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SecondService {

    private static final Logger log = LoggerFactory.getLogger(SecondService.class);
    private static final String THIRD_SERVICE_PATH = "http://localhost:8082/thrid-service";


    private final RestTemplate restTemplate;

    public SecondService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String sendThird() {
        log.info("send: third service");

        String requestUrl = THIRD_SERVICE_PATH + "/receive";
        String response = restTemplate.getForObject(requestUrl, String.class);

        log.info("receive: response = {}", response);
        return "finished second service";
    }
}
