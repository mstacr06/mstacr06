
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
    
      Scanner scanner = new Scanner(System.in);
        
      Library library = new Library();
      
      User user1 = new User("Mustafa","123456");
      User user2 = new User("begüm", "654321");
      
      library.addUser(user1);
      library.addUser(user2);
      
      Magazine magazine1 = new Magazine(125, "unlulerinhayati");
      Book book1 = new Book("adult", "Anna Karenina");
       library.addItem(book1);
       library.addItem(magazine1);
    
       System.out.println("Welcome to the Library System!");
       
       //login
        System.out.println("enter your username: ");
        String username= scanner.nextLine();
        System.out.println("enter your password: ");
        String password= scanner.nextLine();
        
        if(library.login(username, password)){
        
            System.out.println("\nLogin successful!\n");
            System.out.println("Available items:");
            library.listItems();
            System.out.print("\nEnter the title of the item to borrow: ");
            String borrowTitle = scanner.nextLine();

            LibraryItem itemToBorrow = library.FindItemByTitle(borrowTitle);

            if (itemToBorrow != null && itemToBorrow instanceof Borrowable) {
                ((Borrowable) itemToBorrow).borrow(username);
            } else {
                System.out.println("Item not found or cannot be borrowed.");
            }

            System.out.println("\nUpdated items list:");
            library.listItems();

            // Return item
            System.out.print("\nEnter the title of the item to return: ");
            String returnTitle = scanner.nextLine();

            LibraryItem itemToReturn = library.FindItemByTitle(returnTitle);

            if (itemToReturn != null && itemToReturn instanceof Borrowable) {
                ((Borrowable) itemToReturn).returnItem();
            } else {
                System.out.println("Item not found or cannot be returned.");
            }

            System.out.println("\nFinal items list:");
            library.listItems();

        } else {
            System.out.println("Login failed! Invalid username or password.");
        }

        scanner.close();
    }
}
        
        
    
    
    

