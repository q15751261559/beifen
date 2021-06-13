package com.example.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "obj")
public class StudentProperties {
    private String sname;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    private int sage;

    @Override
    public String toString() {
        return "StudentProperties{" +
                "sname='" + sname + '\'' +
                ", sage=" + sage +
                '}';
    }
}
