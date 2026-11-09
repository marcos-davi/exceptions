package nivel1;

import java.util.ArrayList;

public class Sales {
    ArrayList<Product> products = new ArrayList<>();
    double totalPrice;

    private double calculateTotal() {
        if (products.isEmpty()) {
            throw new EmptySaleException("The sale is empty. Please add products to the sale.");
        } else {
            for (Product p : products) {
                totalPrice += p.getPrice();
            }
        }

        return totalPrice;
    }

    public void simulateIndexOutOfBoundsException() {

        try {
            Product p1 = products.get(10);
            System.out.println(p1.getName());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds");
        }

    }
}
