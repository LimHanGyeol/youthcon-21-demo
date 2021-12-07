package com.youthcon21.firstservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    @GetMapping("/first")
    public String callSecond() {
        log.info("---> GET Second Service");
        return "second";
    }
}
