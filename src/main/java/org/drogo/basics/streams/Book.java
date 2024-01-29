package org.drogo.basics.streams;


import java.util.*;

public class Book {
    private String title;
    private String author;
    private int year;
    private double price;

    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}

class StreamsProblem {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Java 8 in Action", "Raoul", 2014, 40.0),
                new Book("Effective Java", "Joshua", 2008, 35.0),
                new Book("Clean Code", "Robert Martin", 2008, 45.0),
                new Book("The Pragmatic Programmer", "Andrew Hunt", 1999, 50.0)
        );

        //1. Print titles of the books published after 2000
        books.stream()
                .filter(b -> b.getYear() > 2000)
                .map(Book::getTitle)
                .forEach(System.out::println);

        //2. Calculate total prices of all books
        double sum = books.stream()
                .mapToDouble(Book::getPrice)
                .sum();

        //3. Find the book with highest price
        OptionalDouble max = books.stream()
                .mapToDouble(Book::getPrice)
                .max();
        max.ifPresent(System.out::println);

        Book expensiveBook = books.stream()
                .max(Comparator.comparingDouble(Book::getPrice))
                .orElse(null);

        //4. Create a new list with books prices less than 40
        List<Book> booksLessThan40 = books.stream()
                .filter(book -> book.getPrice() < 40.0)
                .toList();

        //5.What is the second highest price
        Optional<Double> secondHighestPrice = books.stream()
                .mapToDouble(Book::getPrice)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();


    }

}
