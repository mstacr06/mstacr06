class Book extends LibraryItem implements Borrowable{

protected String author;
protected boolean borrowed =false;
protected String borrowedBy; 

    public Book(String author, String title) {
        super(title);
        this.author = author;
    }

   

    @Override
    public void displayInfo() {
       
        String status;
        if(borrowed=true){
        
            status ="[Borrowed by "+ borrowedBy+"]";    
        }else{
        
            status="[available]";
        
        }
        System.out.println(status);
    }

   
    public void borrow(String username) {
       if(borrowed=false){ 
           
       borrowed=true;
       borrowedBy=username;
           System.out.println(title + " borrowed by "+username);
       }else{
       
           System.out.println(title+" is already borrowed");
       
       }
        
    }

    @Override
    public void returnItem() {
        System.out.println("'" + title + "' returned by " + borrowedBy);
        borrowed=false;
        borrowedBy=null;
    }

    @Override
    public boolean isBorrowed() {
    
        return borrowed;
        
    }

    
    

    


}
