package com.romero.interfaces;

import java.util.List;

import com.romero.entidades.Materia;

public interface MateriaService {

	public List<Materia> listarMateria();
	public void insertar(Materia mate);
	public void actualizar(Materia mate);
	public Materia buscar(Integer idMateria);
	public void eliminar(Integer idMateria);
	
}
