package com.letscode.io;

public class Listagem {
    private int id;
    private int year;
    private int age;
    private String name;
    private String movie;

    public Listagem(int id, int year, int age, String name, String movie) {
        this.id = id;
        this.year = year;
        this.age = age;
        this.name = name;
        this.movie = movie;
    }

    @Override
    public String toString() {
        return
                " \nid=" + id +
                ", year=" + year +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", movie='" + movie + '\''
                ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

}