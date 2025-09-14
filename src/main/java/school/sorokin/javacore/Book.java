package school.sorokin.javacore;

import java.util.Objects;

public class Book extends Publication {

    private String ISBN;

    public Book(String title, String author, int year, String ISBN) {
        super(title, author, year);
        this.ISBN = ISBN;
    }


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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
        return Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ISBN);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title=" + super.getTitle() +
                ", author=" + super.getAuthor() +
                ", year=" + super.getYear() +
                ", ISBN=" + ISBN +
                "}";
    }

    @Override
    public void printDetails() {
        System.out.printf("Book: \ntitle - %s, \nauthor - %s, \nyear - %s, \nISBN - %s\n",
                getTitle(), getAuthor(), getYear(), ISBN);
    }
}
