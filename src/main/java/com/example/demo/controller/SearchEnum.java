package com.example.demo.controller;

public enum SearchEnum {

    AUTHOR("author"),
    PUBLISHER("publisher"),
    TITLE("title"),
    YEAR("year"),
    ISBN("isbn"),
    GENRE("genre");

    String name;

    SearchEnum(String name) {
        this.name = name;
    }


}
