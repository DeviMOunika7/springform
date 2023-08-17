package com.example.form.repo;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.form.model.formmodel;

public interface formrepo extends JpaRepository<formmodel, String>{

    //Iterator<formmodel> iterator();

    Optional<formmodel> findByName(String name);
    
    void deleteByName(String name);

    Optional<formmodel> findByEmail(String email);

    
    
}
