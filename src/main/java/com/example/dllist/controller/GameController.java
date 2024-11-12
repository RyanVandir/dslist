package com.example.dllist.controller;

import com.example.dllist.dto.GameDTO;
import com.example.dllist.dto.GameMinDTO;
import com.example.dllist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    public GameDTO findById(@PathVariable Long id) {
        GameDTO result =  gameService.findById(id);
        return result;
    }
}