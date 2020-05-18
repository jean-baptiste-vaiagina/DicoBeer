package com.example.dicobeer;


import java.util.List;

public class RestBeerResponse {
    private Integer id;
    private String urlApi;
    private List<Beer> number;

    public Integer getId() {
        return id;
    }

    public String getUrlApi() {
        return urlApi;
    }

    public List<Beer> getNumber() {
        return number;
    }
}
