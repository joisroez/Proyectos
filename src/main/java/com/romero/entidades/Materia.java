package com.romero.entidades;

import java.io.Serializable;

public class Materia  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idMateria;
	private String nombre;
	private String  codigo;
	private Double notaFinal;
	private Double asistenciaFinal;
	private int idMatriculaFk;
	
	
	public Integer getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Double getNotaFinal() {
		return notaFinal;
	}
	public void setNotaFinal(Double notaFinal) {
		this.notaFinal = notaFinal;
	}
	public Double getAsistenciaFinal() {
		return asistenciaFinal;
	}
	public void setAsistenciaFinal(Double asistenciaFinal) {
		this.asistenciaFinal = asistenciaFinal;
	}
	public int getIdMatriculaFk() {
		return idMatriculaFk;
	}
	public void setIdMatriculaFk(int idMatriculaFk) {
		this.idMatriculaFk = idMatriculaFk;
	}
	
	
	
	
}
