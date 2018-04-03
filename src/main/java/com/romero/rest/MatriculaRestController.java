package com.romero.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.romero.entidades.Matricula;
import com.romero.interfaces.MatriculaService;



@RestController
@RequestMapping("/matriculas")
@CrossOrigin
public class MatriculaRestController {

	@Autowired MatriculaService matriculaService;
	
	@RequestMapping( path="/insertar", method=RequestMethod.POST )
	public void insertar( @RequestBody Matricula matri ) {
		
		System.out.println( "Insertando registro id: " + matri.getIdMatricula() );
		
		matriculaService.insertar( matri );
	}
	
	@RequestMapping(path="/buscar/{idMatricula}" , method=RequestMethod.GET )
	public Matricula buscar( @PathVariable(value="idMatricula") Integer idMatricula ) {
		
		return matriculaService.buscar( idMatricula );
	}
	
	@RequestMapping("/listar")
	public List<Matricula> listar( ) {
		System.out.println( "Listando registros" );

		return matriculaService.listarMatricula( );
	}
	
	@RequestMapping( path="/actualizar", method=RequestMethod.PUT )
	public void actualizar( @RequestBody Matricula matri ) {
		
		//System.out.println( "Insertando registro id: " + matri.getIdMatricula() );
		
		matriculaService.actualizar( matri );
	}
	
	@RequestMapping(path="/eliminar/{idMatricula}", method=RequestMethod.DELETE)
	public void eliminar( @PathVariable(value="idMatricula") Integer idMatricula ) {
		System.out.println("registro eliminado"+idMatricula);
		matriculaService.eliminar(idMatricula);
	}
	
	
}
