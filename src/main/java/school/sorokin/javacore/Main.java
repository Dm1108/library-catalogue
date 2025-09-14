package school.sorokin.javacore;

import java.util.Scanner;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Library library = new Library();
        while (true) {
            System.out.println("""
                    Выберите пункт меню:
                    1. Добавить новую публикацию.
                    2. Вывести список всех публикаций.
                    3. Поиск публикации по автору.
                    4. Вывести общее количество публикаций.
                    5. Удаление публикации.
                    0. Выход.
                    """);
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                scanner.nextLine();
                switch (menu) {
                    case 1:
                        while (true) {
                            System.out.println("""
                                    Выберите тип публикации:
                                    1 - Book
                                    2 - Magazine
                                    3 - Newspaper
                                    """);
                            if (scanner.hasNextInt()) {
                                int point = scanner.nextInt();
                                scanner.nextLine();
                                switch (point) {
                                    case 1:
                                        System.out.println("Введите название публикации: ");
                                        String titleBook = scanner.nextLine();
                                        System.out.println("Введите автора публикации: ");
                                        String authorBook = scanner.nextLine();
                                        System.out.println("Введите год публикации: ");
                                        int yearBook = 0;
                                        while (true) {
                                            if (scanner.hasNextInt()) {
                                                yearBook = scanner.nextInt();
                                                scanner.nextLine();
                                                break;
                                            } else {
                                                System.out.println("Вы ввели не цифры. Повторите ввод");
                                                scanner.nextLine();
                                            }
                                        }
                                        System.out.println("Введите ISBN");
                                        String ISBN = scanner.nextLine();
                                        Book book = new Book(titleBook, authorBook, yearBook, ISBN);
                                        library.addPublication(book);
                                        Publication.increasePublicationCount();
                                        break;
                                    case 2:
                                        System.out.println("Введите название публикации: ");
                                        String titleMagazine = scanner.nextLine();
                                        System.out.println("Введите автора публикации: ");
                                        String authorMagazine = scanner.nextLine();
                                        System.out.println("Введите год публикации: ");
                                        int yearMagazine = 0;
                                        while (true) {
                                            if (scanner.hasNextInt()) {
                                                yearMagazine = scanner.nextInt();
                                                scanner.nextLine();
                                                break;
                                            } else {
                                                System.out.println("Вы ввели не цифры. Повторите ввод");
                                                scanner.nextLine();
                                            }
                                        }
                                        System.out.println("Введите номер выпуска: ");
                                        int issueNumber = 0;
                                        while (true) {
                                            if (scanner.hasNextInt()) {
                                                issueNumber = scanner.nextInt();
                                                scanner.nextLine();
                                                break;
                                            } else {
                                                System.out.println("Вы ввели не цифры. Повторите ввод");
                                                scanner.nextLine();
                                            }
                                        }
                                        Publication magazine = new Magazine(titleMagazine, authorMagazine,
                                                yearMagazine, issueNumber);
                                        library.addPublication(magazine);
                                        Publication.increasePublicationCount();
                                        break;
                                    case 3:
                                        System.out.println("Введите название публикации: ");
                                        String titleNewspaper = scanner.nextLine();
                                        System.out.println("Введите автора публикации: ");
                                        String authorNewspaper = scanner.nextLine();
                                        System.out.println("Введите год публикации: ");
                                        int yearNewspaper = 0;
                                        while (true) {
                                            if (scanner.hasNextInt()) {
                                                yearNewspaper = scanner.nextInt();
                                                scanner.nextLine();
                                                break;
                                            } else {
                                                System.out.println("Вы ввели не цифры. Повторите ввод");
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
                                System.out.println("Вы ввели не цифру. Повторите ввод.");
                                scanner.nextLine();
                            }
                        }
                        break;
                    case 2:
                        library.listOfPublications();
                        break;
                    case 3:
                        System.out.println("Введите фамилию автора");
                        String author = scanner.nextLine();
                        library.searchByAuthor(author);
                        break;
                    case 4:
                        System.out.println("Общее количество публикаций: " + Publication.getPublicationCount());
                        break;
                    case 5:
                        System.out.println("Для удаления публикации введите фамилию автора");
                        String authorName = scanner.nextLine();
                        library.removeByAuthor(authorName);
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
                System.out.println("Вы ввели не число. Повторите ввод");
                scanner.nextLine();
            }
        }
    }
}
