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

import com.romero.entidades.Materia;
import com.romero.entidades.Matricula;
import com.romero.interfaces.MateriaService;
@Component
public class MateriaImpl implements MateriaService {

	
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Materia> listarMateria() {
		// TODO Auto-generated method stub
StringBuilder sql = new StringBuilder();
		
		sql.append( "select * from materia" );
		
		List<Map<String, Object>> datos = jdbcTemplate.queryForList(sql.toString());
		
		List<Materia> ret = new ArrayList<>();
		
		datos.forEach( s-> {
			
			Materia m = new Materia();
			
			m.setIdMateria( (Integer )s.get("idmateria") );
			m.setNombre( (String)s.get("nombre") );
			m.setCodigo( (String )s.get("codigo") );
			m.setNotaFinal( (Double )s.get("notafinal") );
			m.setAsistenciaFinal( (Double )s.get("asistenciafinal") );
			m.setIdMatriculaFk( (Integer)s.get("idmatriculafk") );
			
			ret.add( m );
		});
		
		return ret;
	}

	@Override
	public void insertar(Materia mate) {
		// TODO Auto-generated method stub
		
StringBuilder sql = new StringBuilder();
		
		sql.append( "insert into materia (nombre,codigo,notafinal,asistenciafinal,idmatriculafk) values(?,?,?,?,?)" );
		
		jdbcTemplate.update( sql.toString( ), 
				//matri.getIdMatricula(),
				mate.getNombre(),
				mate.getCodigo(),
				mate.getNotaFinal(),
				mate.getAsistenciaFinal(),
				mate.getIdMatriculaFk()
				
				);
	}

	@Override
	public void actualizar(Materia mate) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		sb.append("update materia set nombre=?, codigo=?, notafinal=? ,asistenciafinal=?,idmatriculafk=? where idmateria=?");
		jdbcTemplate.update(sb.toString(), mate.getNombre(),
				mate.getCodigo(),
				mate.getNotaFinal(),
				mate.getAsistenciaFinal(),
				mate.getIdMatriculaFk(),
				mate.getIdMateria());
	}

	@Override
	public Materia buscar(Integer idMateria) {
		// TODO Auto-generated method stub
StringBuilder sql = new StringBuilder();
		
		sql.append( "select * from materia where idMateria=?" );
		
		Materia ret = jdbcTemplate.queryForObject(sql.toString( ), new RowMapper<Materia>() {

				@Override
				public Materia mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					Materia est = new Materia( );
					
					est.setIdMateria( rs.getInt("idmateria") );
					est.setNombre( rs.getString("nombre") );
					est.setCodigo( rs.getString("codigo") );
					est.setNotaFinal( rs.getDouble("notafinal") );
					est.setAsistenciaFinal( rs.getDouble("asistenciafinal") );
					est.setIdMatriculaFk( rs.getInt("idmatriculafk") );
					
					return est;
				}
			}
			, idMateria
		 );
		
		return ret;
	}

	@Override
	public void eliminar(Integer idMateria) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		sb.append("delete from materia where idmateria=?");
		jdbcTemplate.update(sb.toString(),idMateria);
	}

}
