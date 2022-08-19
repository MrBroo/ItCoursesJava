package byfayzullayev.itcourses.repository;

import byfayzullayev.itcourses.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByName(String name);

}
