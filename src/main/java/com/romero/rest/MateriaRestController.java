package com.romero.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.romero.entidades.Materia;
import com.romero.interfaces.MateriaService;

@RestController
@RequestMapping("/materias")
@CrossOrigin
public class MateriaRestController {
@Autowired MateriaService materiaService;
	
	@RequestMapping( path="/insertar", method=RequestMethod.POST )
	public void insertar( @RequestBody Materia mate ) {
		
		System.out.println( "Insertando registro id: " + mate.getIdMateria() );
		
		materiaService.insertar( mate );
	}
	
	@RequestMapping(path="/buscar/{idMateria}" , method=RequestMethod.GET )
	public Materia buscar( @PathVariable(value="idMateria") Integer idMateria ) {
		
		return materiaService.buscar( idMateria );
	}
	
	@RequestMapping("/listar")
	public List<Materia> listarMateria( ) {
		System.out.println( "Listando registros" );

		return materiaService.listarMateria( );
	}
	
	@RequestMapping( path="/actualizar", method=RequestMethod.PUT )
	public void actualizar( @RequestBody Materia mate ) {
		
		//System.out.println( "Insertando registro id: " + matri.getIdMatricula() );
		
		materiaService.actualizar( mate );
	}
	
	@RequestMapping(path="/eliminar/{idMateria}", method=RequestMethod.DELETE)
	public void eliminar( @PathVariable(value="idMateria") Integer idMateria ) {
		
		materiaService.eliminar(idMateria);
	}
	
	
}
