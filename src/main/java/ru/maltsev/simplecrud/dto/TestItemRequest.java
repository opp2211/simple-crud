package ru.maltsev.simplecrud.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TestItemRequest {
    private String name;
}
