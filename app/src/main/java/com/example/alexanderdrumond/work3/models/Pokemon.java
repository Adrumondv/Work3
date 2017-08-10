package com.example.alexanderdrumond.work3.models;

import java.io.Serializable;

/**
 * Created by Alexander Drumond on 09-08-2017.
 */

public class Pokemon implements Serializable {

    private String name,description,uid,key;
    private boolean availability ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Pokemon() {

    }
}
