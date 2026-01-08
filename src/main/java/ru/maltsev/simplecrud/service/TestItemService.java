package ru.maltsev.simplecrud.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maltsev.simplecrud.dto.TestItemRequest;
import ru.maltsev.simplecrud.dto.TestItemResponse;
import ru.maltsev.simplecrud.entity.TestItem;
import ru.maltsev.simplecrud.mapper.TestItemMapper;
import ru.maltsev.simplecrud.repository.TestItemRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestItemService {

    private final TestItemRepository testItemRepository;
    private final TestItemMapper mapper;

    @Transactional
    public TestItemResponse addNew(TestItemRequest reqt) {
        TestItem testItem = mapper.toEntity(reqt);
        testItem = testItemRepository.save(testItem);
        return mapper.toResponse(testItem);
    }

    @Transactional(readOnly = true)
    public List<TestItemResponse> findAll() {
        List<TestItem> testItems = testItemRepository.findAll();
        return testItems
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TestItemResponse findById(long id) {
        TestItem testItem = testItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TestItem not found with id: " + id));

        return mapper.toResponse(testItem);
    }

    @Transactional
    public TestItemResponse update(long id, TestItemRequest reqt) {
        testItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TestItem not found with id: " + id));
        TestItem testItem = mapper.toEntity(id, reqt);
        testItem = testItemRepository.save(testItem);
        return mapper.toResponse(testItem);
    }

    @Transactional
    public void deleteById(long id) {
        TestItem testItem = testItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TestItem not found with id: " + id));
        testItemRepository.delete(testItem);
    }
}
