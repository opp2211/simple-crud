package ru.maltsev.simplecrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping
    public Map<String, String> healthCheck() {
        Map<String, String> result = new HashMap<>();
        result.put("status", "OK");
        result.put("service", "simple-crud");
        result.put("timestamp", Instant.now().toString());
        return result;
    }
}
