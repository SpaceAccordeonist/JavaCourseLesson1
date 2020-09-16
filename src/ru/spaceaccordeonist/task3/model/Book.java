package ru.spaceaccordeonist.task3.model;

import java.util.Date;

public class Book {
    private String title;
    private String author;
    private String publication;
    private String publisher = "no information";

    public Book(String title, String author, String publication) {
        this.title = title;
        this.author = author;
        this.publication = publication;
    }

    public Book(String title, String author, String publication, String publisher) {
        this(title, author, publication);
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublication() {
        return publication;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "title: " + title + "\n" +
            "author: " + author + "\n" +
            "publisher: " + publisher + "\n" +
            "publication date: " + publication;
    }
}
