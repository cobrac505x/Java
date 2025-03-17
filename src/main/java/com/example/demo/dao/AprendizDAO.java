package com.example.demo.dao;

import com.example.demo.model.Aprendiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AprendizDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Mapeador de filas (RowMapper) para convertir ResultSet en objetos Aprendiz
    private static final class AprendizMapper implements RowMapper<Aprendiz> {
        @Override
        public Aprendiz mapRow(ResultSet rs, int rowNum) throws SQLException {
            Aprendiz aprendiz = new Aprendiz();
            aprendiz.setId(rs.getInt("id"));
            aprendiz.setNombre(rs.getString("nombre"));
            aprendiz.setTelefono(rs.getString("telefono"));
            return aprendiz;
        }
    }

    // Método para obtener todos los aprendices
    public List<Aprendiz> findAll() {
        String sql = "SELECT * FROM aprendiz";
        return jdbcTemplate.query(sql, new AprendizMapper());
    }

    // Método para obtener un aprendiz por su ID
    public Aprendiz findById(Integer id) {
        String sql = "SELECT * FROM aprendiz WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new AprendizMapper(), id);
    }

    // Método para guardar un nuevo aprendiz
    public void save(Aprendiz aprendiz) {
        String sql = "INSERT INTO aprendiz (nombre, telefono) VALUES (?, ?)";
        jdbcTemplate.update(sql, aprendiz.getNombre(), aprendiz.getTelefono());
    }

    // Método para actualizar un aprendiz existente
    public void update(Aprendiz aprendiz) {
        String sql = "UPDATE aprendiz SET nombre = ?, telefono = ? WHERE id = ?";
        jdbcTemplate.update(sql, aprendiz.getNombre(), aprendiz.getTelefono(), aprendiz.getId());
    }

    // Método para eliminar un aprendiz por su ID
    public void deleteById(Integer id) {
        String sql = "DELETE FROM aprendiz WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}