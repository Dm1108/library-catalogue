package school.sorokin.javacore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {

    private List<Publication> publications = new ArrayList<>();


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
        Iterator<Publication> pubIterator = publications.iterator();
        while (pubIterator.hasNext()) {
            Publication nextPub = pubIterator.next();
            if (nextPub.getAuthor().equalsIgnoreCase(author)) {
                pubIterator.remove();
            }
        }
    }
}
