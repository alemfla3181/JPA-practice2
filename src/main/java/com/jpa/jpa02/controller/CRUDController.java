package com.jpa.jpa02.controller;

import com.jpa.jpa02.repository.CRUDEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class CRUDController {

    private final CRUDEntityRepository crudEntityRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("search")
    public String searchAllUser(){
        return crudEntityRepository.findAll().toString();
    }
}
