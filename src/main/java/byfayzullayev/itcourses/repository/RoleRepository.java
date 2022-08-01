package byfayzullayev.itcourses.repository;

import byfayzullayev.itcourses.entity.RoleEntity;
import byfayzullayev.itcourses.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findByRoleEnum(RoleEnum roleEnum);

}
