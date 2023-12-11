package com.manuboo.pruebaTecnica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manuboo.pruebaTecnica.entity.SuperHeroe;
import com.manuboo.pruebaTecnica.service.SuperHeroesServiceInterface;

@RestController
@RequestMapping("/super-heroes")
public class SuperHeroeController {

	@Autowired
    private SuperHeroesServiceInterface superHeroeService;

    @GetMapping
    public List<SuperHeroe> allHeroes() {
        return superHeroeService.allHeroes();
    }
    
    @GetMapping("/buscar")
	public List<SuperHeroe> buscarHeroe(@RequestParam(name = "texto") String texto){
		return superHeroeService.buscar(texto);
	}
    
    @GetMapping("/heroe")
	public SuperHeroe findHeroe(@RequestParam(name="id") Integer id) {
		return  superHeroeService.findbyId(id);
	}
    
    @PutMapping
    public SuperHeroe modificarHeroe(@RequestBody SuperHeroe superHeroe){
    	return  superHeroeService.modificarHeroe(superHeroe);
    }

	@DeleteMapping
	public void borrar(@RequestParam(name="id") Integer id) {
		superHeroeService.borrar(id);
	}
}
