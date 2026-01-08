package ru.maltsev.simplecrud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.maltsev.simplecrud.dto.TestItemRequest;
import ru.maltsev.simplecrud.dto.TestItemResponse;
import ru.maltsev.simplecrud.entity.TestItem;
import ru.maltsev.simplecrud.service.TestItemService;

import java.util.List;

@RestController
@RequestMapping("api/testItem")
@RequiredArgsConstructor
public class TestItemController {

    private final TestItemService testItemService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public TestItemResponse addNew(@RequestBody TestItemRequest testItemRequest) {
        return testItemService.addNew(testItemRequest);
    }

    @GetMapping
    public List<TestItemResponse> getAll() {
        return testItemService.findAll();
    }

    @GetMapping("/{id}")
    public TestItemResponse getById(@PathVariable long id) {
        return testItemService.findById(id);
    }

    @PutMapping("/{id}")
    public TestItemResponse update(@PathVariable long id, @RequestBody TestItemRequest testItemRequest) {
        return testItemService.update(id,testItemRequest);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        testItemService.deleteById(id);
    }

}
