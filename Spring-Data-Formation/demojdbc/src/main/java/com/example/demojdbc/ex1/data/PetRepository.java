package com.example.demojdbc.ex1.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class PetRepository{

    protected static final String SQL_FIND_BY_ID = "SELECT * FROM pet WHERE id = :id";
    protected static final String SQL_FIND_ALL = "SELECT * FROM pet";
    protected static final String SQL_INSERT = "INSERT INTO pet (name, species) values (:name, :species)";
    protected static final String SQL_DELETE_BY_ID = "DELETE FROM pet WHERE id = :id";

    protected static final RowMapper<Pet> rowMapper = new BeanPropertyRowMapper<>(Pet.class);

    @Autowired
    protected NamedParameterJdbcTemplate jdbcTemplate;

    public Pet findById(Integer id) {
        try {
            SqlParameterSource paramSource = new MapSqlParameterSource("id", id);
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, paramSource, rowMapper);
        } catch (DataAccessException e) {
            // propager une exception perso
            return null;
        }
    }

    public Iterable<Pet> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, rowMapper);
    }

    public int save(Pet pet) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("name", pet.getName());
        paramSource.addValue("species", pet.getSpecies());
        return jdbcTemplate.update(SQL_INSERT, paramSource);
    }

    public int deleteById(Integer id) {
        SqlParameterSource paramSource = new MapSqlParameterSource("id", id);
        return jdbcTemplate.update(SQL_DELETE_BY_ID, paramSource);
    }
}