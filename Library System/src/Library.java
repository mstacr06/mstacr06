
import java.util.ArrayList;


public class Library {
    
    private ArrayList<User> users= new ArrayList<>();
    private ArrayList<LibraryItem> items= new ArrayList<>();
    
    public void addUser(User user){
    
    users.add(user);
    
    }
    
    public void addItem(LibraryItem item){
    
    items.add(item);
    
    }
    public boolean login(String username,String password){
    
    for(User u : users){
        
        if(u.getUsername().equals(username)&&u.getPassword().equals(password)){
        
        return true;
        
        }
        
    }
    return false;
    }

    public LibraryItem FindItemByTitle(String title){
    
        for(LibraryItem item: items){
        
            if(item.title.equalsIgnoreCase(title)){
            return item;
            }
                
        
        }
            return null;
    
    }
    
    public void listItems(){
    
        for(LibraryItem item:items){
        
        item.displayInfo();
        }
    
    }
    
}
