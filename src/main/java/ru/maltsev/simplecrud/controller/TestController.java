package ru.maltsev.simplecrud.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "TestController", description = "Тестовый контроллер")
@RestController
public class TestController {

    @Operation(summary = "Получить ответ от тестового контроллера",
            description = "Всегда возвращает \"test123\"")
    @GetMapping("/test")
    public String test() {
        return "test123";
    }
}
