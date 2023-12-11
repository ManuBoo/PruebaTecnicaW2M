package com.manuboo.pruebaTecnica.service;

import java.util.List;

import com.manuboo.pruebaTecnica.entity.SuperHeroe;

public interface SuperHeroesServiceInterface {

	public List<SuperHeroe> allHeroes();
	
	public SuperHeroe modificarHeroe (SuperHeroe superHeroe);
	
	public SuperHeroe findbyId(Integer id);
	
	public void borrar(Integer id);
	
	public List<SuperHeroe> buscar(String nombre);
}
