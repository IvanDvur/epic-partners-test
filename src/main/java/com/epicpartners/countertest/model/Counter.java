package com.epicpartners.countertest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "counters")
public class Counter {



    @Id
    private String id;

    private Integer value;

    public Counter() {

    }
}
