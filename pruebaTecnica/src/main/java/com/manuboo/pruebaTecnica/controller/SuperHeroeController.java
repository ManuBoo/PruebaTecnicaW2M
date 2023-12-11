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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/super-heroes")
public class SuperHeroeController {

	@Autowired
    private SuperHeroesServiceInterface superHeroeService;

	@Operation(summary = "Devuelve todos los héroes", description = "Devuelve todos los héroes.")
    @GetMapping
    public List<SuperHeroe> allHeroes() {
        return superHeroeService.allHeroes();
    }

	@Operation(summary = "Busca los héroes que contenga el texto introducido", description = "Busca los héroes que contenga el texto introducido.")
    @GetMapping("/buscar")
	public List<SuperHeroe> buscarHeroe(@RequestParam(name = "texto") String texto){
		return superHeroeService.buscar(texto);
	}
    
	@Operation(summary = "Devuelve un héroe por ID", description = "Devuelve un héroe por ID.")
    @GetMapping("/heroe")
	public SuperHeroe findHeroe(@RequestParam(name="id") Integer id) {
		return  superHeroeService.findbyId(id);
	}
    
	@Operation(summary = "Actualiza el nombre de un héroe buscando dicho héroe por ID", description = "Actualiza el nombre de un héroe buscando dicho héroe por ID.")
    @PutMapping
    public SuperHeroe modificarHeroe(@RequestBody SuperHeroe superHeroe){
    	return  superHeroeService.modificarHeroe(superHeroe);
    }

	@Operation(summary = "Borra un héroe", description = "Borra un héroe.")
	@DeleteMapping
	public void borrar(@RequestParam(name="id") Integer id) {
		superHeroeService.borrar(id);
	}
}
