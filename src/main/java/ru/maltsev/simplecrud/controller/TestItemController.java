package ru.maltsev.simplecrud.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.maltsev.simplecrud.dto.TestItemRequest;
import ru.maltsev.simplecrud.dto.TestItemResponse;
import ru.maltsev.simplecrud.service.TestItemService;

import java.util.List;

@RestController
@RequestMapping("api/testItem")
@Tag(name = "TestItem API",
        description = "API для управления данными TestItem")
@RequiredArgsConstructor
public class TestItemController {

    private final TestItemService testItemService;

    @Operation(summary = "Добавить новый testItem")
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public TestItemResponse addNew(@RequestBody TestItemRequest testItemRequest) {
        return testItemService.addNew(testItemRequest);
    }

    @Operation(summary = "Получить все объекты testItem")
    @GetMapping
    public List<TestItemResponse> getAll() {
        return testItemService.findAll();
    }

    @Operation(summary = "Получить testItem по Id")
    @GetMapping("/{id}")
    public TestItemResponse getById(@PathVariable long id) {
        return testItemService.findById(id);
    }

    @Operation(summary = "Изменить testItem по Id")
    @PutMapping("/{id}")
    public TestItemResponse update(@PathVariable long id, @RequestBody TestItemRequest testItemRequest) {
        return testItemService.update(id, testItemRequest);
    }

    @Operation(summary = "Удалить testItem по Id")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        testItemService.deleteById(id);
    }

}
