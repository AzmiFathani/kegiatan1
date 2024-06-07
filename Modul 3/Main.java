import java.util.Scanner;
import java.util.ArrayList;

class tugas {
    static ArrayList<Book> bookList = new ArrayList<>();
    static ArrayList<Student> userStudent = new ArrayList<>();

    public static void main(String[] args) {
        initializeData();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    inputNim(scanner);
                    break;
                case "2":
                    Admin admin = new Admin();
                    admin.menuAdmin(scanner);
                    break;
                case "3":
                    System.out.println("Thank you. Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void inputNim(Scanner scanner) {
        System.out.print("Enter your NIM (input 99 for back): ");
        String nim = scanner.nextLine();
        if (nim.equals("99")) {
            return;
        } else if (checkNim(nim)) {
            Student student = new Student(nim);
            student.menuStudent(scanner); // Panggil menuStudent dari objek student yang sudah dibuat
        } else {
            System.out.println("Invalid NIM. Please try again.");
            inputNim(scanner);
        }
    }

    public static boolean checkNim(String nim) {
        for (Student student : userStudent) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }

    public static void initializeData() {
        // Inisialisasi data buku
        bookList.add(new Book("388c-e681-9152", "Naruto", "Kishimoto", "Comic", 8));
        bookList.add(new Book("ed90-be30-5cdb", "Indonesia", "Soekarno", "Sejarah", 11));
        bookList.add(new Book("d95e-0c4a-9523", "Galaksi", "PoppiPertiwi", "Romance", 3));

        // Inisialisasi data user
        userStudent.add(new Student("Maulana Bima", "20231037031123", "Teknik", "Informatika"));
        userStudent.add(new Student("Azmi Fathani", "202310370311116", "Pendidikan", "Kedokteran"));
        userStudent.add(new Student("Ravlindo Saputra", "202310370311115", "Teknik", "Informatika"));
    }

}

