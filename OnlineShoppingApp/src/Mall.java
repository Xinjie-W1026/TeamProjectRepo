import java.util.ArrayList;
import java.util.List;
public class Mall{

        private List<Product> products;

        public Mall() {
            products = new ArrayList<>();
        }

        public void initProducts() {
            Product C1 = new Product("Laptop",1 , 1200D);
            Product C2 = new Product("Milk",2 , 10.50D);
            Product C3 = new Product("Watermelon",3,10.50D);
            Product C4 = new Product("Charger",4,8.88D);
            Product C5 = new Product("Pot",5,55.03D);
            Product C6 = new Product("Phone",6,600.00D);
            products.add(C1);
            products.add(C2);
            products.add(C3);
            products.add(C4);
            products.add(C5);
            products.add(C6);
        }

    public List<Product> getAllProducts() {
            return  products;
    }
    public Product findProduct(int id){
            for(Product p : products){
                if(p.getId() == id)
                    return p;
            }
           return null;
    }

}