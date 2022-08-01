package byfayzullayev.itcourses.repository;

import byfayzullayev.itcourses.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
