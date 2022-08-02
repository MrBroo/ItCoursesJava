package byfayzullayev.itcourses.repository;

import byfayzullayev.itcourses.entity.CardEntity;
import byfayzullayev.itcourses.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<CardEntity, Long> {
    Optional<CardEntity> findByName(String name);

}
