package com.application.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

/**
 * @author shenjies88
 * @since 2020/2/14-3:52 PM
 */
@Slf4j
@Configuration
public class AutoConfigurationEnableLogger {

    public AutoConfigurationEnableLogger() {
        log.info("Auto Configuration Enabled");
    }
}
