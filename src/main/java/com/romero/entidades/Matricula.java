package com.romero.entidades;

import java.io.Serializable;

public class Matricula implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private Integer idMatricula;
	private String semestre;
	private String estudianteId;
	private String fecha;
	private String periodoAcademicoId;
	
	
	public Integer getIdMatricula() {
		return idMatricula;
	}
	public void setIdMatricula(Integer idMatricula) {
		this.idMatricula = idMatricula;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getEstudianteId() {
		return estudianteId;
	}
	public void setEstudianteId(String estudianteId) {
		this.estudianteId = estudianteId;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getPeriodoAcademicoId() {
		return periodoAcademicoId;
	}
	public void setPeriodoAcademicoId(String periodoAcademicoId) {
		this.periodoAcademicoId = periodoAcademicoId;
	}
	
	

}
