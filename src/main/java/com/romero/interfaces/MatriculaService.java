package com.romero.interfaces;

import java.util.List;

import com.romero.entidades.Matricula;

public interface MatriculaService {

	public List<Matricula> listarMatricula();
	public void insertar(Matricula matri);
	public void actualizar(Matricula matri);
	public Matricula buscar(Integer idMatricula);
	public void eliminar(Integer idMatricula);
	
	
	
}
