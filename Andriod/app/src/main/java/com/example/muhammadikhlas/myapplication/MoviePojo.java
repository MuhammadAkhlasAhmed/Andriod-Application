package com.example.muhammadikhlas.myapplication;

/**
 * Created by Muhammad IKHLAS on 12/24/2017.
 */

public class MoviePojo {
    int rating;
    String tagline;
    String name;

    public  MoviePojo(int rating,String tagline,String name){

        this.rating=rating;
        this.tagline=tagline;
        this.name=name;
    }



    public String getname() {
        return name;
    }




    public String gettagline() {
        return tagline;
    }



    public String getrating() {
        return String.valueOf(rating);
    }







}
