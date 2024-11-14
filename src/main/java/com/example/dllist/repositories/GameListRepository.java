package com.example.dllist.repositories;

import com.example.dllist.entities.GameEntity;
import com.example.dllist.entities.GameListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GameListRepository extends JpaRepository<GameListEntity, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition); // dado o id_list e id_game atualiza a posição no banco de dados
}
