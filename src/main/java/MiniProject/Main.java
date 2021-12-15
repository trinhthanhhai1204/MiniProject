package MiniProject;

import MiniProject.controllers.BookManager;
import MiniProject.models.Book;
import MiniProject.services.BookService;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String choose = null;
        boolean exit = false;

        BookManager bookManager = new BookManager("\\Java\\MiniProject\\src\\resources\\book-input.txt");

        BookService service = new BookService();

        List<Book> books = service.read("\\Java\\MiniProject\\src\\resources\\book-input.txt");
        showMenu();

        while(true) {

            choose = scanner.nextLine();

            switch (choose) {

                case"1":

                    System.out.println("Add book");
                    bookManager.addBook(scanner);
                    System.out.println("Added book successfully!");
                    break;

                case"2":
                    System.out.println("Edit Book");
                    System.out.println("Ener ID: ");
                    double bookId = scanner.nextDouble();
                    scanner.nextLine();
                    bookManager.editName(bookId);
                    bookManager.editAuthor(bookId);
                    bookManager.editLanguage(bookId);
                    bookManager.editCategory(bookId);
                    bookManager.editPrice(bookId);
                    System.out.println("Book edited successfully!");
                    break;

                case"3":
                    System.out.println("Delete Book");
                    System.out.println("Enter ID: ");
                    bookId = scanner.nextDouble();
                    scanner.nextLine();
                    bookManager.delete(bookId);
                    System.out.println("Deleted!");
                    break;

                case"4":
                    System.out.println("List Book: ");
                    bookManager.showAll();
                    break;

                case"5":
                    System.out.println("Sort by name: ");
                    bookManager.sortByName();
                    bookManager.showAll();
                    System.out.println("Sorted!");
                    break;


                case"6":
                   System.out.println("Sort by author");
                   bookManager.sortByAuthor();
                   bookManager.showAll();
                   System.out.println("Sorted!");
                   break;

                case"7":
                   System.out.println("Sort by language");
                   bookManager.sortByLanguage();
                   bookManager.showAll();
                   System.out.println("Sorted!");
                   break;


                case"8":
                   System.out.println("Sort by ID");
                   bookManager.sortById();
                   bookManager.showAll();
                   System.out.println("Sorted!");
                   break;

                case"9":
                   System.out.println("Sort by Price");
                   bookManager.sortByPrice();
                   bookManager.showAll();
                   System.out.println("Sorted!");
                   break;

                case"10":
                    System.out.println("Find by Name");
                    System.out.println("Enter Name:");
                    String nameToFind = scanner.nextLine();
                    System.out.println("The book you need is:");
                    System.out.println(bookManager.findByName(nameToFind));                                           break;

                case"11":
                    System.out.println("Find by Author");
                    System.out.println("Enter Author:");
                    String authorToFind = scanner.nextLine();
                    System.out.println("The book you need is:");
                    System.out.println(bookManager.findByAuthor(authorToFind));
                    break;

                case"12":
                    System.out.println("Find by Category");
                    System.out.println("Enter Category:");
                    String categoryToFind = scanner.nextLine();
                    System.out.println("The book you need is:");
                    System.out.println(bookManager.findByCategory(categoryToFind));
                    break;

                case"13":
                    bookManager.write("\\Java\\MiniProject\\src\\resources\\book-output.txt");
                    System.out.println("Exported!");
                    break;


                case"0":
                    System.out.println("Exit");
                    exit = true;
                    break;

                default:
                    System.out.println("Please choose action: ");
                    break;

            }

            if (exit){

                break;

            }

            showMenu();

        }


    }
    public static void showMenu(){

        System.out.println("--------------------Menu----------------");
        System.out.println("1.Add Book");
        System.out.println("2.Edit Book");
        System.out.println("3.Delete Book");
        System.out.println("4.Show all book");
        System.out.println("5.Sort by Name");
        System.out.println("6.Sort by Author");
        System.out.println("7.Sort by Language");
        System.out.println("8.Sort by ID");
        System.out.println("9.Sort by Price");
        System.out.println("10.Find by Name");
        System.out.println("11.Find by Author");
        System.out.println("12.Find by Category");
        System.out.println("13.Export by txt");
        System.out.println("0.Exit");
        System.out.println("----------------------------------------");
        System.out.println("Please choose action: ");

    }
}