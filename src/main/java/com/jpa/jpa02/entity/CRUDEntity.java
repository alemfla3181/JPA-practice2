package com.jpa.jpa02.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="user")
public class CRUDEntity {

    @Id
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int age;
}
