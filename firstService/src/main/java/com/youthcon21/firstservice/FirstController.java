package com.youthcon21.firstservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    private final FirstService firstService;

    public FirstController(FirstService firstService) {
        this.firstService = firstService;
    }

    @GetMapping("/send")
    public String callSecond() {
        log.info("---> GET /second-service/receive");

        String result = firstService.sendSecond();

        log.info("---> END First Service, result: {}", result);
        return result;
    }
}
