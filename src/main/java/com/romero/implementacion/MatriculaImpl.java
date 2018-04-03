package com.romero.implementacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import com.romero.entidades.Matricula;
import com.romero.interfaces.MatriculaService;
@Component
public class MatriculaImpl implements MatriculaService{

	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Matricula> listarMatricula() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		
		sql.append( "select * from matricula" );
		
		List<Map<String, Object>> datos = jdbcTemplate.queryForList(sql.toString());
		
		List<Matricula> ret = new ArrayList<>();
		
		datos.forEach( s-> {
			
			Matricula m = new Matricula();
			
			m.setIdMatricula( (Integer )s.get("idmatricula") );
			m.setSemestre( (String)s.get("semestre") );
			m.setEstudianteId( (String )s.get("estudianteid") );
			m.setFecha( (String )s.get("fecha") );
			m.setPeriodoAcademicoId( (String )s.get("periodoacademicoid") );
			
			ret.add( m );
		});
		
		return ret;
	}

	@Override
	public void insertar(Matricula matri) {
		// TODO Auto-generated method stub
StringBuilder sql = new StringBuilder();
		
		sql.append( "insert into matricula (semestre,estudianteid,fecha,periodoacademicoid) values(?,?,?,?)" );
		
		jdbcTemplate.update( sql.toString( ), 
				//matri.getIdMatricula(),
				matri.getSemestre(),
				matri.getEstudianteId(),
				matri.getFecha(),
				matri.getPeriodoAcademicoId()
				
				);
	}

	@Override
	public void actualizar(Matricula matri) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		sb.append("update matricula set semestre=?, estudianteid=?, fecha=? ,periodoacademicoid=? where idmatricula=?");
		jdbcTemplate.update(sb.toString(), matri.getSemestre(),matri.getEstudianteId(),matri.getFecha(),matri.getPeriodoAcademicoId(),matri.getIdMatricula());
	}

	@Override
	public Matricula buscar(Integer idMatricula) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		
		sql.append( "select * from matricula where idMatricula=?" );
		
		Matricula ret = jdbcTemplate.queryForObject(sql.toString( ), new RowMapper<Matricula>() {

				@Override
				public Matricula mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					Matricula est = new Matricula( );
					
					est.setIdMatricula( rs.getInt("idmatricula") );
					est.setSemestre( rs.getString("semestre") );
					est.setEstudianteId( rs.getString("estudianteid") );
					est.setFecha( rs.getString("fecha") );
					est.setPeriodoAcademicoId( rs.getString("periodoacademicoid") );
					
					return est;
				}
			}
			, idMatricula
		 );
		
		return ret;
	}

	@Override
	public void eliminar(Integer idMatricula) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		sb.append("delete from matricula where idmatricula=?");
		jdbcTemplate.update(sb.toString(),idMatricula);
	}

}
