public class LibraryManagementSystem {
    public static void main(String[] args) {
        System.out.println("═══ Library Management System Demo ═══");

        // Create media items
        Media book1 = new Book("Java Fundamentals", "B001", "Robert Martin");
        Media dvd1 = new DVD("OOP Concepts", "D001", "Tech Films");
        Media mag1 = new Magazine("Programming Weekly", "M001", 15);

        // Create users
        LibraryUser student = new Student("Alice Johnson", "S12345");
        LibraryUser teacher = new Teacher("Dr. Smith", "T001");
        LibraryUser librarian = new Librarian("Mary Brown", "L001");

        // Display media info
        System.out.println("\nAvailable Media:");
        displayMediaInfo(book1);
        displayMediaInfo(dvd1);
        displayMediaInfo(mag1);

        // Borrowing test
        System.out.println("\n═══ Borrowing Test ═══");
        student.borrowMedia(book1);
        teacher.borrowMedia(dvd1);
        student.borrowMedia(book1); // already borrowed

        // Returning test
        System.out.println("\n═══ Returning Test ═══");
        student.returnMedia(book1);
        librarian.borrowMedia(book1);

        // User info
        System.out.println("\n═══ User Information ═══");
        displayUserInfo(student);
        displayUserInfo(teacher);
        displayUserInfo(librarian);
    }

    // Helper methods
    public static void displayMediaInfo(Media media) {
        media.displayInfo();
    }

    public static void displayUserInfo(LibraryUser user) {
        System.out.println(user.getUserType() + " - Max borrow limit: " + user.getMaxBorrowLimit() + " items");
    }
}
