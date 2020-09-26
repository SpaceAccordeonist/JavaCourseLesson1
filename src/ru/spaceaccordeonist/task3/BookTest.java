package ru.spaceaccordeonist.task3;

import ru.spaceaccordeonist.task3.model.Book;

public class BookTest {
    public static void main(String[] args) {
        Book book = new Book("Im Westen nicht Neues", "Erich Maria Remarque", "1929");
        System.out.println(book.toString());
        System.out.println("------------");

        book.setPublisher("Ullstein Verlag");
        System.out.println(book.toString());
    }
}
