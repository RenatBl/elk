package ru.itis.elk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@Slf4j
public class LogController {

    @GetMapping("/logs/generate")
    public ResponseEntity<String> generateLogs(@RequestParam("count") Long count) {
        generate(count);
        return ResponseEntity
                .ok("Successful!");
    }

    private void generate(Long count) {
        for (int i = 0; i < count; i++) {
            LogLevel level = LogLevel.values()[new Random().nextInt(LogLevel.values().length)];
            switch (level) {
                case TRACE:
                    log.trace("{} log, i = {}, count = {}", level.getName(), i, count);
                    break;
                case DEBUG:
                    log.debug("{} log, i = {}, count = {}", level.getName(), i, count);
                    break;
                case INFO:
                    log.info("{} log, i = {}, count = {}", level.getName(), i, count);
                    break;
                case WARN:
                    log.warn("{} log, i = {}, count = {}", level.getName(), i, count);
                    break;
                case ERROR:
                    log.error("{} log, i = {}, count = {}", level.getName(), i, count);
                    break;
                default:
                    log.info("Default case");
            }
        }
    }
}
