package com.application.controller;

import com.application.interfaces.Aoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenjies88
 * @since 2020/2/15-1:18 PM
 */
@RestController
public class AooController {

    @Autowired
    public Aoo aoo;

    @GetMapping("/foo/check-code-dup")
    public Boolean checkCodeDup(@RequestParam String code) {
        return this.aoo.checkCodeDuplicate(code);
    }
}
