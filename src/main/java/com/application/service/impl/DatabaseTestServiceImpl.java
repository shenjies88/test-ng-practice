package com.application.service.impl;

import com.application.entity.DatabaseTestEntity;
import com.application.service.DatabaseTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author shenjies88
 * @since 2020/2/14-8:35 PM
 */
@Service
public class DatabaseTestServiceImpl implements DatabaseTestService {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(DatabaseTestEntity entity) {
        jdbcTemplate.update("INSERT INTO FOO(name) VALUES (?)", entity.getName());
    }

    @Override
    public void delete(String name) {
        jdbcTemplate.update("DELETE FROM FOO WHERE NAME = ?", name);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
