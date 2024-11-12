package com.example.dllist.service;

import com.example.dllist.dto.GameDTO;
import com.example.dllist.dto.GameMinDTO;
import com.example.dllist.entities.GameEntity;
import com.example.dllist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public GameDTO findById(@PathVariable Long id) {
        GameEntity result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    public List<GameMinDTO> findAll() {
        List<GameEntity> games = gameRepository.findAll();
        return games.stream().map(GameMinDTO::new).toList();
    }
}
