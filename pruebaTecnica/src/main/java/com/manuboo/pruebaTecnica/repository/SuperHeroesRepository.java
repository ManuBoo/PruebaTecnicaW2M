package com.manuboo.pruebaTecnica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manuboo.pruebaTecnica.entity.SuperHeroe;

public interface SuperHeroesRepository extends JpaRepository<SuperHeroe, Integer>{
	
	 @Query("SELECT s FROM SuperHeroe s WHERE LOWER(s.nombre) LIKE LOWER(CONCAT('%', :texto, '%'))")
	 List<SuperHeroe> buscarPorNombre(@Param("texto") String texto);

}
