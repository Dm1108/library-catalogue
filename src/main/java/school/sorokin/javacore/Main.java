package school.sorokin.javacore;

import java.util.Scanner;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);
    private static final String CHOOSE_POINT_OF_MENU = """
            Выберите пункт меню:
            1. Добавить новую публикацию.
            2. Вывести список всех публикаций.
            3. Поиск публикации по автору.
            4. Вывести общее количество публикаций.
            5. Удаление публикации.
            0. Выход.
            """;
    private static final String CHOOSE_PUBLICATION_TYPE = """
            Выберите тип публикации:
            1 - Book
            2 - Magazine
            3 - Newspaper
            """;
    private static final String PUBLICATION_NAME = "Введите название публикации: ";
    private static final String PUBLICATION_AUTHOR = "Введите автора публикации: ";
    private static final String PUBLICATION_YEAR = "Введите год публикации: ";
    private static final String ENTER_DIGIT = "Вы ввели не цифры. Повторите ввод";
    private static final Library library = new Library();


    public static void main(String[] args) {

//        Library library = new Library();
        while (true) {
            System.out.println(CHOOSE_POINT_OF_MENU);
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                scanner.nextLine();
                switch (menu) {
                    case 1:
                        choosePublicationType();
                        break;
                    case 2:
                        library.listOfPublications();
                        break;
                    case 3:
                        findPublicationByAuthor();
                        break;
                    case 4:
                        System.out.println("Общее количество публикаций: " + Publication.getPublicationCount());
                        break;
                    case 5:
                        deletePublicationByAuthor();
                        break;
                    case 0:
                        System.out.println("Выход из программы");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Вы ввели цифры не из диапазона от 0 до 5. Повторите ввод");
                        break;
                }
            } else {
                System.out.println(ENTER_DIGIT);
                scanner.nextLine();
            }
        }
    }

    private static void choosePublicationType() {
        while (true) {
            System.out.println(CHOOSE_PUBLICATION_TYPE);
            if (scanner.hasNextInt()) {
                int point = scanner.nextInt();
                scanner.nextLine();
                switch (point) {
                    case 1:
                        System.out.println(PUBLICATION_NAME);
                        String titleBook = scanner.nextLine();
                        System.out.println(PUBLICATION_AUTHOR);
                        String authorBook = scanner.nextLine();
                        System.out.println(PUBLICATION_YEAR);
                        int yearBook;
                        while (true) {
                            if (scanner.hasNextInt()) {
                                yearBook = scanner.nextInt();
                                scanner.nextLine();
                                break;
                            } else {
                                System.out.println(ENTER_DIGIT);
                                scanner.nextLine();
                            }
                        }
                        System.out.println("Введите ISBN");
                        String isbn = scanner.nextLine();
                        Book book = new Book(titleBook, authorBook, yearBook, isbn);
                        library.addPublication(book);
                        Publication.increasePublicationCount();
                        break;
                    case 2:
                        System.out.println(PUBLICATION_NAME);
                        String titleMagazine = scanner.nextLine();
                        System.out.println(PUBLICATION_AUTHOR);
                        String authorMagazine = scanner.nextLine();
                        System.out.println(PUBLICATION_YEAR);
                        int yearMagazine;
                        while (true) {
                            if (scanner.hasNextInt()) {
                                yearMagazine = scanner.nextInt();
                                scanner.nextLine();
                                break;
                            } else {
                                System.out.println(ENTER_DIGIT);
                                scanner.nextLine();
                            }
                        }
                        System.out.println("Введите номер выпуска: ");
                        int issueNumber;
                        while (true) {
                            if (scanner.hasNextInt()) {
                                issueNumber = scanner.nextInt();
                                scanner.nextLine();
                                break;
                            } else {
                                System.out.println(ENTER_DIGIT);
                                scanner.nextLine();
                            }
                        }
                        Publication magazine = new Magazine(titleMagazine, authorMagazine,
                                yearMagazine, issueNumber);
                        library.addPublication(magazine);
                        Publication.increasePublicationCount();
                        break;
                    case 3:
                        System.out.println(PUBLICATION_NAME);
                        String titleNewspaper = scanner.nextLine();
                        System.out.println(PUBLICATION_AUTHOR);
                        String authorNewspaper = scanner.nextLine();
                        System.out.println(PUBLICATION_YEAR);
                        int yearNewspaper;
                        while (true) {
                            if (scanner.hasNextInt()) {
                                yearNewspaper = scanner.nextInt();
                                scanner.nextLine();
                                break;
                            } else {
                                System.out.println(ENTER_DIGIT);
                                scanner.nextLine();
                            }
                        }
                        System.out.println("Введите день публикации: ");
                        String publicationDay = scanner.nextLine();
                        Publication newspaper = new Newspaper(titleNewspaper, authorNewspaper,
                                yearNewspaper, publicationDay);
                        library.addPublication(newspaper);
                        Publication.increasePublicationCount();
                        break;
                    default:
                        System.out.println("Нет такой публикации. Введите цифру от 1 до 3.");
                        break;
                }
                break;
            } else {
                System.out.println(ENTER_DIGIT);
                scanner.nextLine();
            }
        }
    }

    private static void findPublicationByAuthor() {
        System.out.println("Введите фамилию автора");
        String author = scanner.nextLine();
        library.searchByAuthor(author);
    }

    private static void deletePublicationByAuthor() {
        System.out.println("Для удаления публикации введите фамилию автора");
        String authorName = scanner.nextLine();
        library.removeByAuthor(authorName);
    }
}

