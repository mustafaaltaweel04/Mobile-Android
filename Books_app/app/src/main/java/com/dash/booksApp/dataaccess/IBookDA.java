package com.dash.booksApp.dataaccess;

import java.util.List;

public interface IBookDA {
    String[] getCats();

    List<Book> getBooks(String cat);

}
