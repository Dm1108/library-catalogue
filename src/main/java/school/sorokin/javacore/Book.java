package school.sorokin.javacore;

import java.util.Objects;

public class Book extends Publication {

    private String isbn;

    public Book(String title, String author, int year, String isbn) {
        super(title, author, year);
        this.isbn = isbn;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String getType() {
        return "Книга";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title=" + super.getTitle() +
                ", author=" + super.getAuthor() +
                ", year=" + super.getYear() +
                ", ISBN=" + isbn +
                "}";
    }

    @Override
    public void printDetails() {
        System.out.printf("Book: \ntitle - %s, \nauthor - %s, \nyear - %s, \nISBN - %s\n",
                getTitle(), getAuthor(), getYear(), isbn);
    }
}
