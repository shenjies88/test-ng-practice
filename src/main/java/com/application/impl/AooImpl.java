package com.application.impl;

import com.application.interfaces.Aoo;
import com.application.interfaces.Bar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author shenjies88
 * @since 2020/2/14-8:10 PM
 */
@Component
public class AooImpl implements Aoo {

    @Autowired
    private Bar bar;

    @Override
    public boolean checkCodeDuplicate(String code) {
        return bar.getAllCodes().contains(code);
    }
}
