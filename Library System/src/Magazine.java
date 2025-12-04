
class Magazine extends LibraryItem implements Borrowable {

    private int issueNumber;
    private boolean borrowed =false;
    private String borrowedBy;

    public Magazine(int issueNumber, String title) {
        super(title);
        this.issueNumber = issueNumber;
        
    }
    
   
   
    @Override
    public void displayInfo() {
        String status;
          if(borrowed=true){
              status = "[Borrowed by "+borrowedBy+"]"; 
              
        }else{
           status="[available]";
          }
          System.out.println(status);
    }
    
    @Override
    public void borrow(String username) {
        if(borrowed=false){
        
            borrowed=true;
            borrowedBy=username;
            System.out.println(title+" borrowed by "+username);
        }else{
            System.out.println(title+" is already borrowed.");
        }
   
    }

    @Override
    public void returnItem() {
  
        if(borrowed=true){
        System.out.println(title+" is returned by "+ borrowedBy);
        borrowed=false;
        borrowedBy=null;
        }else{
            System.out.println(title+" wasn't borrowed");
        }
    }

    @Override
    public boolean isBorrowed() {

        return borrowed;
    }

    
    

    
    
}
