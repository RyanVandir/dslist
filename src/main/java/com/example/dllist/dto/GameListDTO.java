package com.example.dllist.dto;

import com.example.dllist.entities.GameListEntity;

public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO() {
    }

    public GameListDTO(GameListEntity gameListEntity) {
        id = gameListEntity.getId();
        name = gameListEntity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
