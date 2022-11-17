package com.ashutosh.wuhan.spring_covid_wuhanvirus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringCovidWuhanVirusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCovidWuhanVirusApplication.class, args);
    }

}
