package com.epicpartners.countertest.repositories;

import com.epicpartners.countertest.model.Counter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterRepository extends JpaRepository<Counter,String> {

}
