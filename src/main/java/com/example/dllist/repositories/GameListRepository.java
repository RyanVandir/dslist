package com.example.dllist.repositories;

import com.example.dllist.entities.GameEntity;
import com.example.dllist.entities.GameListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameListEntity, Long> {
}
