package com.eManager.em.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eManager.em.model.Test_table;

@Repository
public interface TestRepository extends JpaRepository<Test_table, Integer> {

}
