package com.application.service;

import com.application.entity.DatabaseTestEntity;

/**
 * @author shenjies88
 * @since 2020/2/14-8:35 PM
 */
public interface DatabaseTestService {

    void save(DatabaseTestEntity foo);

    void delete(String name);
}
