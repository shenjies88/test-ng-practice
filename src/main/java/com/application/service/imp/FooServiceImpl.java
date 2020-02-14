package com.application.service.imp;

import com.application.service.FooService;
import org.springframework.stereotype.Service;

/**
 * @author shenjies88
 * @since 2020/2/14-2:01 PM
 */
@Service
public class FooServiceImpl implements FooService {

    private int count = 0;

    @Override
    public void plusCount() {
        this.count++;
    }

    @Override
    public int getCount() {
        return count;
    }
}
