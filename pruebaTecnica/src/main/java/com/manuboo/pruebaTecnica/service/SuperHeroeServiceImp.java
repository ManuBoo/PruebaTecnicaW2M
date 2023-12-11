package com.manuboo.pruebaTecnica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuboo.pruebaTecnica.entity.SuperHeroe;
import com.manuboo.pruebaTecnica.repository.SuperHeroesRepository;

@Service
public class SuperHeroeServiceImp implements SuperHeroesServiceInterface{

	@Autowired
	private SuperHeroesRepository superHeroesDao;


	@Override
	public List<SuperHeroe> allHeroes() {
		return superHeroesDao.findAll();
	}


	@Override
	public SuperHeroe modificarHeroe(SuperHeroe superHeroe) {
		
		Optional<SuperHeroe> optionalHeroe = superHeroesDao.findById(superHeroe.getId());
		
		if(optionalHeroe.isPresent()) {
			SuperHeroe heroe = optionalHeroe.get();
			heroe.setNombre(superHeroe.getNombre());
			
			heroe = superHeroesDao.save(superHeroe);
			return heroe;
		}
		
		return null;
	}


	@Override
	public SuperHeroe findbyId(Integer id) {
		Optional<SuperHeroe> optionalHeroe = superHeroesDao.findById(id);
		
		if(optionalHeroe.isPresent()) {
			SuperHeroe heroe = optionalHeroe.get();
			return heroe;
		}
		
		return null;
	}


	@Override
	public void borrar(Integer id) {
		
		Optional<SuperHeroe> optionalHeroe = superHeroesDao.findById(id);
		
		if(optionalHeroe.isPresent()) {
			superHeroesDao.delete(optionalHeroe.get());
		}
	}


	@Override
	public List<SuperHeroe> buscar(String nombre) {
		
		List<SuperHeroe> heroes = superHeroesDao.buscarPorNombre(nombre);
		return heroes;
	}
}
