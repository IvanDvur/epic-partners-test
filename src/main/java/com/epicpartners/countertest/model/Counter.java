package com.epicpartners.countertest.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Counter {

    @Id
    private String id;

    private Integer value;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
