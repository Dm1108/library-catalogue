package school.sorokin.javacore;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private final List<Publication> publications = new ArrayList<>();


    public List<Publication> getPublications() {
        return publications;
    }

    public void addPublication(Publication pub) {
        publications.add(pub);
        int pubCount = Publication.getPublicationCount();
        Publication.setPublicationCount(pubCount++);
    }

    public void listOfPublications() {
        System.out.println(publications);
    }

    public void searchByAuthor(String author) {
        for (Publication pub : publications) {
            if (pub.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(pub);
            }
        }
    }

    public void removeByAuthor(String author) {
        publications.removeIf(pub -> pub.getAuthor().equalsIgnoreCase(author));
    }
}
