package com.dash.booksApp.dataaccess;

public class Book {
    private String name;
    private int pages;
    private String category;

    public Book(){

    }

    public Book(String name, int pages, String category) {
        this.name = name;
        this.pages = pages;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
