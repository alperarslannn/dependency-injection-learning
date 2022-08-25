package com.alperArslan.springframeworkdependencyinjection.datasource;

import com.alperArslan.springframeworkdependencyinjection.config.SfDiConstructorConfig;
import org.springframework.stereotype.Component;

@Component
public class ThirdFakeDataSource {
    private String username;
    private String password;
    private String jdbcUrl;

    public ThirdFakeDataSource(SfDiConstructorConfig sfDiConstructorConfig) {
        this.username = sfDiConstructorConfig.getUsername();
        this.password = sfDiConstructorConfig.getPassword();
        this.jdbcUrl = sfDiConstructorConfig.getJdbcUrl();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }
}
