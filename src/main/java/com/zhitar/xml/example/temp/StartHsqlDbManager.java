package com.zhitar.xml.example.temp;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class StartHsqlDbManager {
    private static final String SA = "sa";

    @PostConstruct
    public void startDbManager() {
        DatabaseManagerSwing.main(new String[]{
                "--url", "jdbc:hsqldb:mem:testdb",
                "--user", SA, "--password",
                SA
        });
    }
}
