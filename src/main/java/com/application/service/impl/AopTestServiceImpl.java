package com.application.service.impl;

import com.application.service.AopTestService;
import org.springframework.stereotype.Service;

/**
 * @author shenjies88
 * @since 2020/2/15-5:35 PM
 */
@Service
public class AopTestServiceImpl implements AopTestService {

    private int count;

    @Override
    public int incrementAndGet() {
        count++;
        return count;
    }
}
