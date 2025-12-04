package e.ticaret.sistemi;

import java.util.ArrayList;

public class Order {
    
    private int id;
    private Customer customer;
    private ArrayList<OrderItem> items;
    private boolean isReturned;

    public Order(int id, Customer customer) {
    this.id = id;
    this.customer = customer;
    this.items = new ArrayList<>();
    this.isReturned = false;
}


    
    
    public void addItem(OrderItem item){
    
    
        items.add(item);
        
    }

    public double calculateTotal(){
    
        double total = 0;
        
        for(OrderItem item: items){
        
            total+= item.calculateTotal();
        }
        return total;
    }
    public void markAsReturned(){
    
        isReturned = true;
        
    }
    @Override
    public String toString() {
        String info = "Order ID: " + id + " | Customer: " + customer.getName() + "\n";
        for (OrderItem item : items) {
            info += "   " + item.toString() + "\n";
        }
        info += "Total: " + calculateTotal() + "₺";
        if (isReturned) info += " (Returned)";
        return info;
    }
}
    

