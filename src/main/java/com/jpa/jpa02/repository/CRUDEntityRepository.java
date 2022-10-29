package com.jpa.jpa02.repository;

import com.jpa.jpa02.entity.CRUDEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CRUDEntityRepository extends JpaRepository<CRUDEntity, String> {
    @Query(value ="select name, age from user where name = :name", nativeQuery = true)
    List<CRUDEntity> searchParamRepo(@Param("name") String name);
}
