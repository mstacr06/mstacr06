package e.ticaret.sistemi;
public class Main {
    public static void main(String[] args) {

        // Sistemi oluşturuyoruz.
        ECommerceSystem system = new ECommerceSystem();

        // Ürünleri ekliyoruz.
        system.addProduct(new Product(1, "Laptop", 25000, 5));
        system.addProduct(new Product(2, "Mouse", 300, 10));
        system.addProduct(new Product(3, "Keyboard", 700, 8));

        // Müşterileri ekliyoruz.
        system.addCustomer(new Customer(1, "Ali", "ali@mail.com"));
        system.addCustomer(new Customer(2, "Ayse", "ayse@mail.com"));

        // Sipariş oluşturuyoruz.
        system.placeOrder(system.getCustomers().get(0), 1, 1); // Ali - Laptop
        system.placeOrder(system.getCustomers().get(1), 2, 2); // Ayşe - Mouse x2

        // Siparişleri listeliyoruz.
        System.out.println("\n--- All Orders ---");
        system.listOrders();

        // Sipariş iadesi yapıyoruz.
        system.returnOrder(1);

        // Güncel listeyi tekrar yazdırıyoruz.
        System.out.println("\n--- After Return ---");
        system.listOrders();
    }
}
