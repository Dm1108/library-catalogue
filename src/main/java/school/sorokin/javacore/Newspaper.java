package school.sorokin.javacore;

import java.util.Objects;

public class Newspaper extends Publication {

    private String publicationDay;

    public Newspaper(String title, String author, int year, String publicationDay) {
        super(title, author, year);
        this.publicationDay = publicationDay;
    }

    @Override
    public String getType() {
        return "Газета";
    }

    public String getPublicationDay() {
        return publicationDay;
    }

    public void setPublicationDay(String publicationDay) {
        this.publicationDay = publicationDay;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Newspaper newspaper = (Newspaper) o;
        return Objects.equals(publicationDay, newspaper.publicationDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publicationDay);
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "title=" + getTitle() +
                ", author=" + getAuthor() +
                ", year=" + getYear() +
                ", publicationDay='" + publicationDay +
                "}";
    }

    @Override
    public void printDetails() {
        System.out.printf("Newspaper: \ntitle - %s, \nauthor - %s, \nyear - %s, \npublicationDay - %s",
                getTitle(), getAuthor(), getYear(), publicationDay);
    }
}
