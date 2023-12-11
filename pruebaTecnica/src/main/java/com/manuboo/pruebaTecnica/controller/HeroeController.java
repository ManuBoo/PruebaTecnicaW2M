package com.manuboo.pruebaTecnica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manuboo.pruebaTecnica.entity.SuperHeroe;
import com.manuboo.pruebaTecnica.service.HeroesServiceInterface;

@RestController
@RequestMapping("/api")
public class HeroeController {

	@Autowired
    private HeroesServiceInterface heroeService;

    @GetMapping("/all")
    public List<SuperHeroe> allHeroes() {
        return heroeService.allHeroes();
    }
	
    @PostMapping("/add")
    public SuperHeroe createHeroe(@RequestBody SuperHeroe superHeroe)
    {
    	
    	SuperHeroe heroe = heroeService.add(superHeroe);
    	
    	return heroe;
    }
    
	
}
