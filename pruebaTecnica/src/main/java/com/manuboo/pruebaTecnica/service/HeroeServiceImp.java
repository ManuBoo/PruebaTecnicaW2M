package com.manuboo.pruebaTecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuboo.pruebaTecnica.entity.SuperHeroe;
import com.manuboo.pruebaTecnica.repository.HeroesRepository;

@Service
public class HeroeServiceImp implements HeroesServiceInterface{

	@Autowired
	private HeroesRepository heroesDao;


	@Override
	public List<SuperHeroe> allHeroes() {
		return heroesDao.findAll();
	}


	@Override
	public SuperHeroe add(SuperHeroe superHeroe) {
		
		SuperHeroe heroe = heroesDao.save(superHeroe);
		return heroe;
	}
}
