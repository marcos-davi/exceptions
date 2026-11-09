package nivel1;

import java.util.ArrayList;

public class Sales {
    ArrayList<Product> products = new ArrayList<>();
    double totalPrice;

    private double calculateTotal() throws EmptySaleException {
        if (products.isEmpty()) {
            throw new EmptySaleException("The sale is empty. Please add products to the sale.");
        } else {
            for(Product p : products) {
                totalPrice += p.getPrice();
            }

        }

     return totalPrice;
    }
}
