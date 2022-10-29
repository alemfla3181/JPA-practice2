package com.jpa.jpa02.controller;

import com.jpa.jpa02.entity.CrudEntity;
import com.jpa.jpa02.repository.CrudEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class CrudController {

    private final CrudEntityRepository crudEntityRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("search")
    public String searchAllUser(){
        return crudEntityRepository.findAll().toString();
    }

    @GetMapping("insert")
    public String insertUser(@RequestParam(value="name") String name, @RequestParam(value="age") int age){
        if(crudEntityRepository.findById(name).isPresent()){
            return "동일한 이름이 이미 있습니다.";
        } else{
            CrudEntity entity = CrudEntity.builder().name(name).age(age).build();
            crudEntityRepository.save(entity);
            return "이름 : " + name + " 나이 : " + age + "으로 추가 되었습니다.";
        }
    }

    @GetMapping("update")
    public String updateUser(@RequestParam(value="name") String name, @RequestParam(value="age") int age){
        if(crudEntityRepository.findById(name).isEmpty()){
            return "입력한 " + name + "이 존재하지 않습니다.";
        }else {
            crudEntityRepository.save(CrudEntity.builder().name(name).age(age).build());
            return name + "의 나이를 " + age + "로 수정하였습니다.";
        }
    }

    @GetMapping("delete")
    public String deleteUser(@RequestParam(value="name") String name, @RequestParam(value="age") int age){
        if(crudEntityRepository.findById(name).isEmpty()){
            return "입력한 " + name + "이 존재하지 않습니다.";
        }else{
            crudEntityRepository.delete(CrudEntity.builder().name(name).build());
            return name + "의 유저를 삭제 하였습니다";
        }
    }

    @GetMapping("deleteAll")
    public String deleteAllUser(){
        crudEntityRepository.deleteAll();
        return "모든 유저 삭제 완료";
    }
}
