import java.util.Scanner;

class Admin extends User{
    // Tambahkan informasi username dan password admin
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    public void menuAdmin(Scanner scanner) {
        if (loginAdmin(scanner)) {
            while (true) {
                System.out.println("=== Admin Menu ===");
                System.out.println("1. Tambah Mahasiswa");
                System.out.println("2. Lihat Daftar Mahasiswa");
                System.out.println("3. Tambah Buku");
                System.out.println("4. Lihat Daftar Buku");
                System.out.println("5. Keluar");
                System.out.print("Choose option (1-5): ");
                String option = scanner.nextLine();
                switch (option) {
                    case "1":
                        addStudent(scanner);
                        break;
                    case "2":
                        displayStudent();
                        break;
                    case "3":
                        addBook(scanner);
                        break;
                    case "4":
                        displayBookList();
                        break;
                    case "5":
                        System.out.println("Logging out from admin account.");
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        }else {
            System.out.println("Admin login failed. Exiting.");
        }
    }
    // Metode untuk melakukan autentikasi admin
    private boolean loginAdmin(Scanner scanner) {
        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        // Periksa apakah username dan password sesuai dengan yang diharapkan
        return username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
    }

    public void addStudent(Scanner scanner) {
        System.out.println("Enter student details:");
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        String nim;
        do {
            System.out.print("Enter student NIM: ");
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("NIM must be 15 digits.");
            }
        } while (nim.length() != 15);
        System.out.print("Enter student faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter student program: ");
        String program = scanner.nextLine();
        tugas.userStudent.add(new Student(name, nim, faculty, program));
        System.out.println("Student successfully registered.");
    }

    public void displayStudent() {
        System.out.println("List of Registered Students:");
        for (Student student : tugas.userStudent) {
            System.out.println("Nama: " + student.getName());
            System.out.println("Fakultas: " + student.getFaculty());
            System.out.println("NIM: " + student.getNim());
            System.out.println("Prodi: " + student.getProgram());
            System.out.println();
        }
    }
    public void addBook(Scanner scanner) {
        System.out.println("Choose book category:");
        System.out.println("1. Story Book");
        System.out.println("2. History Book");
        System.out.println("3. Text Book");
        System.out.println("4. Keluar");
        System.out.print("Enter choice (1-4): ");
        String categoryChoice = scanner.nextLine();

        String category;
        switch (categoryChoice) {
            case "1":
                category = "Story Book";
                break;
            case "2":
                category = "History Book";
                break;
            case "3":
                category = "Text Book";
                break;
            case "4":
                System.out.println("System logout...");
                return;
            default:
                System.out.println("Invalid choice. Defaulting to Story Book.");
                category = "Story Book";
                break;
        }
        System.out.println("Enter book details:");
        System.out.print("Enter book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book stock: ");
        int stock = Integer.parseInt(scanner.nextLine());

        tugas.bookList.add(new Book(id, title, author, category, stock));
        System.out.println("Book successfully added to the library.");
    }
    public void displayBookList() {
        System.out.println("List of Books:");
        System.out.println("================================================================");
        System.out.println("|| No. || Id Buku || Nama Buku || Author || Category || Stock ||");
        int index = 1;
        for (Book book : tugas.bookList) {
            System.out.println("|| " + index + "  || " + book.getId() + " || " + book.getTitle() + " || " + book.getAuthor() + " || " + book.getCategory() + "  || " + book.getStock() + " ||");
            index++;
        }
        System.out.println("================================================================");
    }
}