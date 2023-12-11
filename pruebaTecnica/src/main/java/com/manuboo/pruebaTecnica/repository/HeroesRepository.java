package com.manuboo.pruebaTecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manuboo.pruebaTecnica.entity.SuperHeroe;

public interface HeroesRepository extends JpaRepository<SuperHeroe, Integer>{

}
