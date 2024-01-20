package task2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LibraryCatalog library = new LibraryCatalog();

        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");

        library.addBook(book1);
        library.addBook(book2);

        ArrayList<Book> searchResult = library.searchByAuthor("Harper Lee");
        System.out.println("Books by Harper Lee: " + searchResult);

        library.checkOutBook(book1);
        library.checkOutBook(book1); // Trying to check out the same book again

        library.returnBook(book1);
        library.returnBook(book1); // Trying to return the same book again
    }
}