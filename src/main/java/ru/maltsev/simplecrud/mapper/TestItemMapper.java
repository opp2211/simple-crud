package ru.maltsev.simplecrud.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.maltsev.simplecrud.dto.TestItemRequest;
import ru.maltsev.simplecrud.dto.TestItemResponse;
import ru.maltsev.simplecrud.entity.TestItem;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TestItemMapper {

    @Mapping(target = "id", ignore = true)
    TestItem toEntity(TestItemRequest testItemRequest);
    TestItem toEntity(long id, TestItemRequest testItemRequest);

    TestItemResponse toResponse(TestItem testItem);
}
