package edu.devcci.justpractice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String id;
    private String name;

    @Builder
    public UserDto(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
