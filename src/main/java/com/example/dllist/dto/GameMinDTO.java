package com.example.dllist.dto;

import com.example.dllist.entities.GameEntity;
import com.example.dllist.projections.GameMinProjection;
import jakarta.persistence.*;

public class GameMinDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(name = "game_year")
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() {
    }

    public GameMinDTO(GameEntity gamesEntity) {
        id = gamesEntity.getId();
        title = gamesEntity.getTitle();
        year = gamesEntity.getYear();
        imgUrl = gamesEntity.getImgUrl();
        shortDescription = gamesEntity.getShortDescription();
    }
    public GameMinDTO(GameMinProjection gameMinProjection) {
        id = gameMinProjection.getId();
        title = gameMinProjection.getTitle();
        year = gameMinProjection.getGameYear();
        imgUrl = gameMinProjection.getImgUrl();
        shortDescription = gameMinProjection.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getGameYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
