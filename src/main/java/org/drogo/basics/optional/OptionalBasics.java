package org.drogo.basics.optional;

import org.drogo.basics.streams.Book;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalBasics {
    public static void main(String[] args) {
        Book book = findBookByName("Optionals");
        //System.out.println(book.getPrice());

        Optional<Book> bookOptional = findOptionalBookByName("Java 8");
        //System.out.println(bookOptional.get().getPrice());
        if (bookOptional.isPresent()) {
            System.out.println(bookOptional.get().getPrice());
        }

        Book book1 = bookOptional.orElse(new Book("Default", "Default", 0, 0.0));
        Book book2 = bookOptional.orElseGet(() -> new Book("Default", "Default", 0, 0.0));
        Book book3 = bookOptional.orElseThrow(() -> new NoSuchElementException("No such Book found!"));

        Double bookPrice = bookOptional.map(Book::getPrice)
                .orElse(0.0);

        try {
            Optional<String> optionalString = Optional.of("Hello");
            System.out.println(optionalString.orElse("Default"));

        } catch (NullPointerException e) {
            {
                System.out.println("NullPointerException caught");
            }
        }

        Optional<String> optinalNullable = Optional.ofNullable(null);
        System.out.println(optinalNullable.orElse("Default"));


    }

    private static Book findBookByName(String name) {
        Book book = new Book(name, "Suraj", 2024, 100);
        return null; //what if the Book is null
    }

    private static Optional<Book> findOptionalBookByName(String name) {
        Book book = new Book(name, "Suraj", 2024, 100);
        return Optional.ofNullable(book);
    }


}
