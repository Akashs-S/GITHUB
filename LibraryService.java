import java.util.*;

public class LibraryService {
    private List<Book> books = new ArrayList<>();
    
    public void addBook(Book book){
        books.add(book);
        System.out.println("Book added sucessfully! ");
    }

    public void displayBooks(){
        if (books.isEmpty()){
            System.out.println("No books available in the Library");
        return;
        }
        System.out.println("\n---Library Collection---");
        for(Book book:books){
            System.out.println(book);
        }
    }
    public void issueBook(int id){
        for (Book book: books){
            if (book.getId()== id){
                if (book.isIssued()){
                    System.out.println("Sorry, this book is already issued.");
                }else{
                    book.setIssued(true);
                    System.out.println("Book issued sucessfully");
                }
                return;           
            }
        }
        System.out.println("Book with ID"+id+"not found.");
    }

    public void returnBook(int id)
    {
        for (Book book : books){
            if (book.getId()==id){
                if (!book.isIssued()){
                    System.out.println("Those book was not issued");
                }else{
                    book.setIssued(false);
                    System.out.println("Book returned sucessfully!");

                }
                return;
            }
        }
        System.out.println("Book with Id" + id +"not Found.");
    }
    
}
