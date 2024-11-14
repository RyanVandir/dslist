package com.example.dllist.service;

import com.example.dllist.dto.GameListDTO;
import com.example.dllist.entities.GameListEntity;
import com.example.dllist.projections.GameMinProjection;
import com.example.dllist.repositories.GameListRepository;
import com.example.dllist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    public GameListDTO findById(@PathVariable Long id) {
        GameListEntity result = gameListRepository.findById(id).get();
        return new GameListDTO(result);
    }
    
    public List<GameListDTO> findAll() {
        List<GameListEntity> games = gameListRepository.findAll();
        return games.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIdenx) {

        List<GameMinProjection> list = gameRepository.searchByList(listId); // busca a lista com os jogos

        GameMinProjection obj = list.remove(sourceIndex); // remove o obj da lista
        list.add(destinationIdenx, obj); // adiciona o obj a lista no local destinado

        int min = sourceIndex < destinationIdenx ? sourceIndex : destinationIdenx; // menor
        int max = sourceIndex < destinationIdenx ? destinationIdenx : sourceIndex; // maior

        for (int i = min; i <= max ; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
                                                // Id da lista,     id do jogo,   nova posição/destino
        }
    }
}
