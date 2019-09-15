package com.janio.clock.impl;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public enum ApplicationProperties {
    INSTANCE;

    private final Properties properties;

    ApplicationProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public int getTimeDuration() {
        String duration = properties.getProperty("clock.time.duration");
        return Integer.parseInt(duration);
    }

    public String getZoneId() {
        return properties.getProperty("clock.zone.id");
    }

    public TimeUnit getTimeUnit() {
        String unit = properties.getProperty("clock.time.unit");
        switch (unit){
            case "SECONDS" :
                return TimeUnit.SECONDS;
            case "MINUTES" :
                return TimeUnit.MINUTES;
            case "HOURS" :
                return TimeUnit.HOURS;
            default: return TimeUnit.SECONDS;
        }
    }
 }
