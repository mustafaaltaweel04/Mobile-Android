package com.dash.booksApp.dataaccess;
import java.util.ArrayList;
import java.util.List;

public class BookDA implements IBookDA{
    List<Book> books;
    public BookDA(){
         books = new ArrayList<>();
         books.add(new Book("Introduction to Python", 536, "Python"));
        books.add(new Book("Object-oriented Programming in Java", 486, "Java"));
        books.add(new Book("Data Structures and Algorithms", 368, "Data Structures"));
        books.add(new Book("Machine Learning and Neural Networks", 791, "AI"));

    }
    @Override
    public String[] getCats() {
        String[] cats = {"Python", "Java", "Data Structures", "AI"};
        return cats;
    }

    @Override
    public List<Book> getBooks(String cat) {
        List<Book> result = new ArrayList<>();
        for (Book book: books) {
            if(book.getCategory().equals(cat)){
                result.add(book);
            }
        }
        return result;
    }
}
