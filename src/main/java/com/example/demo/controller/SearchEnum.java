package com.example.demo.controller;

public enum SearchEnum {

    AUTHOR("author"),
    PUBLISHER("publisher"),
    TITLE("title"),
    YEAR("year"),
    ISBN("isbn"),
    GENRE("genre"),
    SALES("sales"),
    SANATATE("sanatate"),
    TOPANTREPRENORIAT("topantreprenoriat"),
    ORDERDPUBLUSHER("orderpublisher"),
    BESTSELLER("bestseller"),
    ALLSEARCH("allsearch");


    String name;

    SearchEnum(String name) {
        this.name = name;
    }


}
