package com.application.service;

import com.application.entity.DbTestEntity;

/**
 * @author shenjies88
 * @since 2020/2/14-8:35 PM
 */
public interface DbTestRepository {

    void save(DbTestEntity foo);

    void delete(String name);
}
