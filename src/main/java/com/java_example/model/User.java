package com.java_example.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String name;
    private String id;
}
