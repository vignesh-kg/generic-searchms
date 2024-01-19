package com.searchms.genericsearchms.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Map;

@Document(indexName = "generic")
public class GenericObject {
    @Id
    private String id;
    private Map<String, Object> map;

    public GenericObject(Map<String,Object> map) {
        this.map = map;
    }

    public GenericObject() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }


    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
