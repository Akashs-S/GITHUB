
import java.util.Scanner;

public class LibraryApp {
    
    public static void main(String[] args) {
        
        LibraryService library = new LibraryService();
        Scanner scan =new Scanner(System.in);

        library.addBook(new Book(101,"Java Programming","James adam"));
        library.addBook(new Book(102,"Python Programming","Martin Samuvel"));

    while(true)
    {
        System.out.println("----------------------");
        System.out.println("   Library Management Services   ");
        System.out.println("-----------------------");
        System.out.println("1. Add New Book");
        System.out.println("2. Display All Book");
        System.out.println("3. Issued a Book");
        System.out.println("4. Return a Boook");
        System.out.println("5. Exit");
        System.out.println("Enter your choice");

        int choice = scan.nextInt();
        scan.nextLine();

        switch(choice)
        {
            case 1:
                System.out.println("Enter Book Id:");
                int id =scan.nextInt();
                scan.nextLine();
                System.out.println("Enter Book Title");
                String title =scan.nextLine();
                scan.nextLine();
                System.out.println("Enter Author Name");
                String author =scan.nextLine();
                scan.nextLine();
                library.addBook(new Book(id,title,author));
                break;

            case 2:
                library.displayBooks();
                break;

            case 3:
                System.out.println("Enter BookId to issue:");
                int issueId =scan.nextInt();
                library.issueBook(issueId);
                break;

            case 4:
                System.out.print("Enter book Id to return:");
                int returnId =scan.nextInt();
                library.returnBook(returnId);
                break;

            case 5:
                System.out.println("Existing system. Good Bye");
                scan.close();
                return;

            default:
                System.out.println("Invalid Input. Please try again");
                

        }
    }
    }
}
