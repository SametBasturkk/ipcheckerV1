package com.ipChecker.ipCheckerV1;

import ipsorgu.firstVersion.ipDbReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class webService {

    public void run() {
        SpringApplication.run(webService.class);
    }

    @RestController
    public class IPCheckController {

        @GetMapping("/ipcheck")
        public String ipCheck(@RequestParam(value = "ip", defaultValue = "") String ip) throws IOException {
            Date date = new Date();
            ipCheck ipCheck = new ipCheck(ip);
            String userIP = ipCheck.getClientIP();
            List<List<String>> ipDb = new ipDbReader().getIpDb();
            ipInformationCheck ipInformationCheck = new ipInformationCheck(userIP , ipDb);
            String userInformation = ipInformationCheck.check();

            System.out.println(userIP + " " + userInformation + " " + date);


            return userIP + " " + userInformation + " " + date;
        }
    }
}