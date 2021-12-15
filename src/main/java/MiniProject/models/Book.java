package MiniProject.models;

import java.util.Scanner;

public class Book {

    private double id;
    private String name;
    private String author;
    private String language;
    private String category;
    private double price;

    public Book() {

    }

    public Book(double id, String name, String author, String language, String category, double price) {
        this.name = name;
        this.author = author;
        this.id = id;
        this.language = language;
        this.category = category;
        this.price = price;
    }
    public Book input(Scanner sc) {

        System.out.println("Enter name of book: ");
        String name = sc.nextLine();

        System.out.println("Enter author of book: ");
        String author = sc.nextLine();

        System.out.println("Enter ID of book: ");
        double id = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter language of book: ");
        String language = sc.nextLine();

        System.out.println("Enter category of book: ");
        String category = sc.nextLine();

        System.out.println("Enter price of book: ");
        double price = sc.nextDouble();
        sc.nextLine();

        return new Book(id,name,author,language,category,price);
    }

    public double getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID = " + id + "| Name = " + name + "| Author = " + author + "| Language = " + language + "| Category = " + category + "| Price = " + price;
    }





}
