package com.example.dllist.service;

import com.example.dllist.dto.GameMinDTO;
import com.example.dllist.entities.GameEntity;
import com.example.dllist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<GameEntity> games = gameRepository.findAll();
        return games.stream().map(GameMinDTO::new).toList();
    }
}
