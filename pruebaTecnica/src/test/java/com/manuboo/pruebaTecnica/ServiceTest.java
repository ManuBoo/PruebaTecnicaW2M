package com.manuboo.pruebaTecnica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.manuboo.pruebaTecnica.entity.SuperHeroe;
import com.manuboo.pruebaTecnica.service.SuperHeroeServiceImp;

@SpringBootTest
public class ServiceTest {

	
	 @Autowired
	    private SuperHeroeServiceImp superHeroeService;

	    @Test
	    public void buscarPorTextoEnNombreTest() {
	        
	        // Llamada al método del repositorio
	        List<SuperHeroe> resultado = superHeroeService.buscar("man");
	        assertNotNull(resultado);
	    }
	    
	    @Test
	    public void modificarTest() {
	    	SuperHeroe superHeroe = new SuperHeroe(1, "Hulk") ;
	    	superHeroe = superHeroeService.modificarHeroe(superHeroe);
	    	assertEquals(superHeroe.getNombre(), "Hulk");
	    	
	    }
	    
	    @Test
	    public void findAllTest() {
	    	
	    	 List<SuperHeroe> resultado = superHeroeService.allHeroes();
		        assertNotNull(resultado);
	    }
	    
	    @Test
	    public void findByIdTest() {
	    	
	    	SuperHeroe resultado = superHeroeService.findbyId(2);
	        assertNotNull(resultado);
	    }
	    
	    @Test
	    public void borrarTest() {
	    	superHeroeService.borrar(1);
	    	
	    	SuperHeroe resultado = superHeroeService.findbyId(1);
	    	
	    	assertNull(resultado);
	    }
	   
}
