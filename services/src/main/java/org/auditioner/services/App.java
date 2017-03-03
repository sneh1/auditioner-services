package com.iowaballetacademy.manage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private App() {

    }

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
//                (new AudutionerApplication()).run("db", "migrate", "config.yml");
                (new AuditionerApplication()).run("server", "config.yml");
            } else {
                (new AuditionerApplication()).run(args);
            }
        } catch (Exception e) {
            LOGGER.error("Failed to start.",e);
        }
    }
}

