package e.ticaret.sistemi;

import java.util.ArrayList;

public class ECommerceSystem {
  
    private ArrayList<Product> products;
    private ArrayList<Customer> customers;
    private ArrayList<Order> orders;

  public ECommerceSystem() {
    this.products = new ArrayList<>();
    this.customers = new ArrayList<>();
    this.orders = new ArrayList<>();
}
    public ECommerceSystem(ArrayList<Product> products, ArrayList<Customer> customers, ArrayList<Order> orders) {
    this.products = products; 
    this.customers = customers;
    this.orders = orders;
    
}

    
    public void addProduct(Product p){
    
        products.add(p);
        System.out.println("Product added: "+p.getName());
    
    }
    public void addCustomer(Customer c){
    
        customers.add(c);
        System.out.println("Customer added: "+ c.getName());
    
    }
    public void placeOrder(Customer c, int productId, int quantity) {
        for (Product p : products) {
            if (p.getId() == productId) {
                if (p.getStock() >= quantity) {
                    p.setStock(p.getStock() - quantity);
                    Order order = new Order(orders.size() + 1, c);
                    order.addItem(new OrderItem(p, quantity));
                    orders.add(order);
                    System.out.println("Order placed for " + c.getName() + ": " + p.getName());
                } else {
                    System.out.println("Not enough stock for " + p.getName());
                }
                return;
            }
        }
        System.out.println("Product not found!");
    }public void returnOrder(int orderId) {
        for (Order o : orders) {
            if (o.toString().contains("Order ID: " + orderId)) {
                o.markAsReturned();
                System.out.println("Order #" + orderId + " marked as returned.");
                return;
            }
        }
        System.out.println("Order not found!");
    }

    // Siparişleri listeleme
    public void listOrders() {
        for (Order o : orders) {
            System.out.println(o);
            System.out.println("----------------------");
        }
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
    

            
            
            
        
        
        

    
