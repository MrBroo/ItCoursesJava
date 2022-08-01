package byfayzullayev.itcourses.repository;

import byfayzullayev.itcourses.Entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardEntity, Long> {

}
