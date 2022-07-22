package com.bilgeadam.springbootthymeleaf.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bilgeadam.springbootthymeleaf.model.DersOgrenci;

@Repository
public interface DersOgrenciRepo extends JpaRepository<DersOgrenci, Long> {

}
