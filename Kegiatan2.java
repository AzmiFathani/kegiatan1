import java.util.Scanner;

public class Kegiatan2 {
    private Book[] bookList;
    private Student[] userStudents;

    public Kegiatan2(Book[] bookList, Student[] userStudents) {
        this.bookList = bookList;
        this.userStudents = userStudents;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Library Management System");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit Program");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                // Admin login
                menuStudent();
                break;
            case 2:
                // Student login
                menuAdmin();
                break;
            case 3:
                // Student login
                System.out.println("~ Thank You ~");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void inputNim() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Student ID (NIM): ");
        String nim = scanner.nextLine();
        if (checkNim(nim)) {
            // Proceed with student menu
            menuStudent();
        } else {
            System.out.println("Invalid Student ID!");
            inputNim(); // Recursive call if NIM is invalid
        }
    }

    public boolean checkNim(String nim) {
        for (Student student : userStudents) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }

    public void menuAdmin() {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        System.out.println("==== Admin Menu ====");
        System.out.println("1. Add Student");
        System.out.println("2. Display Registered Student");
        System.out.println("3. Logout");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                admin.addStudent();
                menuAdmin();
                break;
            case 2:
                admin.displayStudent();
                menuAdmin();
                break;
            case 3:
                menu();
                break;
            default:
                System.out.println("Invalid choice");
                menuAdmin();
        }
    }

    public void menuStudent() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Welcome Student");
        System.out.println("1. Display Available Books");
        System.out.println("2. Logout");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                student.displayBooks(bookList);
                menuStudent();
                break;
            case 2:
                menu();
                break;
            default:
                System.out.println("Invalid choice");
                menuStudent();
        }
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book("123", "Book A", "Author A", 10),
                new Book("456", "Book B", "Author B", 5),
                new Book("789", "Book C", "Author C", 3)
        };

        Student[] students = {
                new Student(),
                new Student()
        };

        Kegiatan2 main = new Kegiatan2(books, students);
        main.menu();
    }
}

class Book {
    private String id;
    private String title;
    private String author;
    private int stock;

    public Book(String id, String title, String author, int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getStock() {
        return stock;
    }
}

class Student {
    private String name;
    private String nim;
    private String faculty;
    private String program;

    public Student() {
        this.name = name;
        this.nim = nim;
        this.faculty = faculty;
        this.program = program;
    }

    public String getNim() {
        return nim;
    }

    public void displayBooks(Book[] books) {
        System.out.println("Available Books:");
        for (Book book : books) {
            System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Stock: " + book.getStock());
        }
    }
}

class Admin {
    private String name;
    private String nim;
    private String faculty;
    private String program;
    private static final int NIM_LENGTH = 15;
    private Scanner scanner = new Scanner(System.in);
    private Student[] Admin;

    public void addStudent() {
        System.out.println("Adding Student");
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student ID (NIM): ");
        String nim = scanner.nextLine();
        if (nim.length() != NIM_LENGTH) {
            System.out.println("Invalid NIM! NIM should be " + NIM_LENGTH + " characters long.");
            return;
        }
        System.out.print("Enter Faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter Program: ");
        String program = scanner.nextLine();
        System.out.println("Student added successfully!");
    }

    public void displayStudent() {
        System.out.println("\n===== List Of Registered Student =====");
    }

}
