package com.example.demo.controller;

import com.example.demo.config.KafkaConfigurations;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("app")
public class AppController {
    private KafkaConfigurations kafkaConfigurations;
    int count;

    @PostMapping("/{identity}")
    public ResponseEntity<String> circuitBreakPattern(@PathVariable int identity) {
        while (count < 9) {
            try {
                if (count < 3) {
                    kafkaConfigurations.sendMessage("PATTERN_TESTING_KAFKA", identity);
                    return ResponseEntity.ok().body("OK PROCESS, STATUS IS CLOSED.");
                } else if (count >= 6) {
                    kafkaConfigurations.sendMessage("PATTERN_TESTING_KAFKA", identity);
                    return ResponseEntity.ok("OK PROCESS, STATUS IS CLOSED.");
                } else {
                    count++;
                    return ResponseEntity.internalServerError().body("RETRIES " + count + "x, STATUS IS OPEN");
                }
            } catch (Exception e) {
                count ++;
                return count < 3? ResponseEntity.badRequest().body("ERROR, TRY AGAIN. STATUS IS CLOSED") : ResponseEntity.badRequest().body("TRYING AGAIN, STATUS IS HALF-OPEN.");
            }
        }
        count = 0;
        return ResponseEntity.internalServerError().body("INTERNAL ERROR, TRY AGAIN. RETURN STATUS BY CLOSED...");
    }
}

