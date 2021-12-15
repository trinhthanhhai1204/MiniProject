package MiniProject.controllers;

import MiniProject.models.Book;
import MiniProject.services.BookService;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookManager {

    private List<Book> list;

    private final String pathFileToInput;

    private BookService service;

    public BookManager(String pathFileToInput) {

        this.pathFileToInput = pathFileToInput;
        this.service = new BookService();

        try {

            this.list = service.read(pathFileToInput);

        } catch (IOException e) {}

    }

    public void sortByName() {

        Collections.sort(list, (s1, s2) -> s1.getName().compareTo(s2.getName()));

    }

    public void sortByAuthor() {

        Collections.sort(list, (s1, s2) -> s1.getAuthor().compareTo(s2.getAuthor()));

    }

    public void sortByLanguage() {

        Collections.sort(list, (s1, s2) -> s1.getLanguage().compareTo(s2.getLanguage()));

    }

    public void sortById() {

        Collections.sort(list, (s1, s2) -> Double.compare(s1.getId(), s2.getId()));

    }

    public void sortByPrice() {

        Collections.sort(list, (s1, s2) -> Double.compare(s1.getPrice(), s2.getPrice()));
    }

    public Book findByName(String name) {

        for(Book s: list) {

            if (s.getName().equals(name)) {

                return s;

            }

        }

        return null;
    }

    public Book findByAuthor(String author) {

        for(Book s: list) {

            if (s.getAuthor().equals(author)) {

                return s;

            }

        }

        return null;
    }


    public Book findById(List<Book> list, double id) {

        for(Book s: list) {

            if (s.getId() == id) {

                return s;

            }

        }

        return null;

    }

    public Book findByCategory(String category) {

        for(Book s: list) {

            if (s.getCategory().equals(category)) {

                return s;

            }

        }

        return null;
    }

    public void addBook(Scanner sc) {

        list.add(new Book().input(sc));

    }

    public void editName(double id) {

        Book book = findById(list, id);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new name of book: ");
        String newName = scanner.nextLine();
        book.setName(newName);

    }

    public void editAuthor(double id) {

        Book book = findById(list, id);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new author of book: ");
        String newAuthor = scanner.nextLine();
        book.setAuthor(newAuthor);

    }

    public void editLanguage(double id) {

        Book book = findById(list, id);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new language of book: ");
        String newLanguage = scanner.nextLine();
        book.setLanguage(newLanguage);

    }

    public void editCategory(double id) {

        Book book = findById(list, id);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new category: ");
        String newCategory = scanner.nextLine();
        book.setCategory(newCategory);

    }
    public void editPrice(double id) {

        Book book = findById(list, id);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new price: ");
        Double newPrice = scanner.nextDouble();
        scanner.nextLine();
        book.setPrice(newPrice);

    }

    public void delete(double id) {

        Book findById = findById(list, id);
        list.remove(findById);

    }

    public void showAll() {

        for (Book s:list) {

            System.out.println(s.toString());

        }

    }

    public void write(String path) throws IOException {

        service.write(path, list);

    }

}
