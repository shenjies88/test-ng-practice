package com.application.impl;

import com.application.interfaces.Bar;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;

/**
 * @author shenjies88
 * @since 2020/2/14-9:33 PM
 */
@Component
public class BarImpl implements Bar {

    @Override
    public Set<String> getAllCodes() {
        return Collections.singleton("123");
    }
}
