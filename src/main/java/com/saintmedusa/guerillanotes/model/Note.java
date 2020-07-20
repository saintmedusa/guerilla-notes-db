package com.saintmedusa.guerillanotes.model;

import com.saintmedusa.guerillanotes.encryption.AES;
import javax.crypto.SecretKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;
import javax.persistence.*;


@Entity
public class Note {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private final UUID id;
    private final String tagID;
    private final String key;
    private final String text;
    private final String location;
    private final Integer destroyCount;
    private final Boolean isPrivate;

    private final AES encryptionTool = new AES();

    public Note() {
        this(null, null, null, null, 0, false);
    }

    public Note(UUID id,
                String tagID,
                String text) {
        this(id, tagID, text, null, 0, false);
    }

    public Note(UUID id,
                String tagID,
                String text,
                String location,
                Integer destroyCount,
                Boolean isPrivate) {
        this.id = id; //change
        this.tagID = tagID;
        this.text = text;
        this.location = location;
        this.destroyCount = destroyCount;
        this.isPrivate = isPrivate;
        if (isPrivate) {
            this.key = this.encryptionTool.getKey().toString();
        } else {
            this.key = null;
        }
    }


    public String getTagID() {
        return tagID;
    }

    public UUID getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getText() {
        return text;
    }

    public String getLocation() {
        return location;
    }
//    public void setLocation(Map<String, Double> location) {
//        this.location = location;
//    }


    public Integer getDestroyCount() {
        return destroyCount;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", tagID='" + tagID + '\'' +
                ", text='" + text + '\'' +
                ", location=" + location +
                ", destroyCount=" + destroyCount +
                '}';
    }
}
