package com.bilgeadam.springbootthymeleaf.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bilgeadam.springbootthymeleaf.model.Ders;

public interface DersRepo extends JpaRepository<Ders, Long> {

}
