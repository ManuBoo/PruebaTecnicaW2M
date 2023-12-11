package com.manuboo.pruebaTecnica.service;

import java.util.List;

import com.manuboo.pruebaTecnica.entity.SuperHeroe;

public interface HeroesServiceInterface {

	public List<SuperHeroe> allHeroes();
	
	public SuperHeroe add (SuperHeroe superHeroe);
}
