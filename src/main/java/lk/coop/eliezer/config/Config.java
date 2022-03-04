package lk.coop.eliezer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;

@Configuration
@EnableScheduling
public class Config {

    @Scheduled(cron = "0 0/7 * * * *")
    public void scheduleExpireInactiveReason() {

        System.out.println("Schedule print " + LocalTime.now());
    }

}
