import java.util.ArrayList;
import java.util.Scanner;

class Student extends User{
    private String name;
    private String nim;
    private String faculty;
    private String program;
    private ArrayList<Book> borrowedBooks;
    private int loanDuration;



    // Konstruktor dengan empat argumen
    public Student(String name, String nim, String faculty, String program) {
        this.name = name;
        this.nim = nim;
        this.faculty = faculty;
        this.program = program;
        this.borrowedBooks = new ArrayList<>();
        // this.loanDuration = loanDuration;
    }

    // Konstruktor dengan satu argumen
    public Student(String nim) {
        // Temukan detail mahasiswa dari Main.userStudent berdasarkan nim yang diberikan
        for (Student student : tugas.userStudent) {
            if (student.getNim().equals(nim)) {
                this.name = student.getName();
                this.nim = student.getNim();
                this.faculty = student.getFaculty();
                this.program = student.getProgram();
                this.borrowedBooks = student.getBorrowedBooks();
                break;
            }
        }
    }

    // Metode untuk menambah buku yang dipinjam

    // Metode lainnya
    public String getNim() { return nim; }

    public void menuStudent(Scanner scanner) {
        while (true) {
            System.out.println("=== Student Menu ===");
            System.out.println("1. Buku terpinjam");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Pinjam Buku atau Logout");
            System.out.print("Choose option (1-3): ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Buku terpinjam:");
                    displayBorrowedBooks();
                    // Implementasi logika untuk menampilkan buku yang sedang dipinjam
                    break;
                case "2":
                    displayBooks();
                    borrowBook(scanner);
                    // Implementasi logika untuk pinjam buku
                    break;
                case "3":
                    System.out.println("System logout...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Metode untuk mengembalikan buku yang dipinjam
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books currently borrowed.");
        } else {
            System.out.println("=================================================================================");
            System.out.println("|| No. || Id Buku        || Nama Buku    || Author       || Category   || Durasi ||");
            System.out.println("=================================================================================");
            int index = 1;
            for (Book book : borrowedBooks) {
                System.out.println("|| " + index + "  || " + book.getId() + " || " + book.getTitle() + " || " + book.getAuthor() + " || " + book.getCategory() + " || " + book.getLoanDuration() + " ||" );
                index++;
            }
            System.out.println("=================================================================================");
        }
    }

    public void displayBooks() {
        System.out.println("================================================================");
        System.out.println("|| No. || Id Buku || Nama Buku || Author || Category || Stock ||");
        int index = 1;
        for (Book book : tugas.bookList) {
            System.out.println("|| " + index + "  || " + book.getId() + " || " + book.getTitle() + " || " + book.getAuthor() + " || " + book.getCategory() + "  || " + book.getStock() + " ||");
            index++;
        }
        System.out.println("================================================================");
    }
    public void borrowBook(Scanner scanner) {
        System.out.print("Enter the number of the book you want to borrow: ");
        int bookIndex = Integer.parseInt(scanner.nextLine()) - 1;
        if (bookIndex < 0 || bookIndex >= tugas.bookList.size()) {
            System.out.println("Invalid book selection.");
            return;
        }

        Book selectedBook = tugas.bookList.get(bookIndex);
        System.out.print("Enter the duration of loan (in days): ");
        int loanDuration = Integer.parseInt(scanner.nextLine());

        if (selectedBook.getStock() > 0) {
            // Decrease the stock of the selected book
            selectedBook.setStock(selectedBook.getStock() - 1);
            selectedBook.setLoanDuration(loanDuration); // Set loan duration for the book
            borrowBook(selectedBook);
            System.out.println("Book '" + selectedBook.getTitle() + "' borrowed successfully for " + loanDuration + " days.");
        } else {
            System.out.println("Sorry, the selected book is out of stock.");
        }
    }

    // Di kelas Book, tambahkan setter untuk loanDuration
    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    // Di kelas Book, tambahkan getter untuk loanDuration
    public int getLoanDuration() {
        return loanDuration;
    }
    public String getName() { return name; }
    public String getFaculty() { return faculty; }
    public String getProgram() { return program; }
    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }
}