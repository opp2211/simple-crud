package ru.maltsev.simplecrud.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TestItemResponse {
    private long id;
    private String name;
}
