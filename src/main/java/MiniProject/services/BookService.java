package MiniProject.services;

import MiniProject.models.Book;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    public List<Book> read (String path) throws IOException {

        List<Book> books = new ArrayList<>();

        Path pathFileToRead = Paths.get(path);

        List<String> allLines = Files.readAllLines(pathFileToRead);

        for ( int i = 0; i < allLines.size(); ++i) {

            String line = allLines.get(i);

            String[] data = line.split(",");

            Book book = new Book(Double.parseDouble(data[0]), data[1].trim(), (data[2]).trim(), data[3].trim(), data[4].trim(), Double.parseDouble(data[5]));
            books.add(book);

        }

        return books;

    }

    public void write(String path, List<Book> books) throws IOException {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < books.size(); ++i) {

            Book book = books.get(i);

            list.add(book.toString());

        }

        Path pathFileToWrite = Paths.get(path);

        Files.write(pathFileToWrite, list);
    }

}
