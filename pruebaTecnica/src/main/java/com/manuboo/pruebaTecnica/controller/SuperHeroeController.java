package com.manuboo.pruebaTecnica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manuboo.pruebaTecnica.TiempoEjecucion;
import com.manuboo.pruebaTecnica.entity.SuperHeroe;
import com.manuboo.pruebaTecnica.service.SuperHeroesServiceInterface;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/super-heroes")
public class SuperHeroeController {

	@Autowired
    private SuperHeroesServiceInterface superHeroeService;

	@TiempoEjecucion
	@Operation(summary = "Devuelve todos los héroes", description = "Devuelve todos los héroes.")
    @GetMapping
    public ResponseEntity<List<SuperHeroe>> allHeroes() {
		
		List<SuperHeroe> superHeroes = superHeroeService.allHeroes();
		
		return new ResponseEntity<>(superHeroes, HttpStatus.OK);
    }
	
	@TiempoEjecucion
	@Operation(summary = "Busca los héroes que contenga el texto introducido", description = "Busca los héroes que contenga el texto introducido.")
    @GetMapping("/buscar")
	public ResponseEntity<List<SuperHeroe>> buscarHeroe(@RequestParam(name = "texto") String texto){
		
		List<SuperHeroe> superHeroes = superHeroeService.buscar(texto);
		
		return new ResponseEntity<>(superHeroes, HttpStatus.OK);
	}
    
	@TiempoEjecucion
	@Operation(summary = "Devuelve un héroe por ID", description = "Devuelve un héroe por ID.")
    @GetMapping("/heroe")
	public ResponseEntity<SuperHeroe> findHeroe(@RequestParam(name="id") Integer id) {
		SuperHeroe superHeroe = superHeroeService.findbyId(id);
		
		if(superHeroe != null) {
			return new ResponseEntity<>(superHeroe, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(superHeroe, HttpStatus.NO_CONTENT);
		}
	}
    
	@TiempoEjecucion
	@Operation(summary = "Actualiza el nombre de un héroe buscando dicho héroe por ID", description = "Actualiza el nombre de un héroe buscando dicho héroe por ID.")
    @PutMapping
    public ResponseEntity<SuperHeroe> modificarHeroe(@RequestBody SuperHeroe superHeroe){
		SuperHeroe heroe = superHeroeService.modificarHeroe(superHeroe);
    	
    	if(superHeroe != null) {
			return new ResponseEntity<>(heroe, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(heroe, HttpStatus.NO_CONTENT);
		}
    }

	@TiempoEjecucion
	@Operation(summary = "Borra un héroe", description = "Borra un héroe.")
	@DeleteMapping
	public void borrar(@RequestParam(name="id") Integer id) {
		superHeroeService.borrar(id);
	}
}
