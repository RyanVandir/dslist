package com.example.dllist.service;

import com.example.dllist.dto.GameListDTO;
import com.example.dllist.entities.GameListEntity;
import com.example.dllist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    public GameListDTO findById(@PathVariable Long id) {
        GameListEntity result = gameListRepository.findById(id).get();
        return new GameListDTO(result);
    }

    public List<GameListDTO> findAll() {
        List<GameListEntity> games = gameListRepository.findAll();
        return games.stream().map(GameListDTO::new).toList();
    }
}
