import java.util.ArrayList;
import java.util.List;
public class Mall{
        private List<Product> products;

        public Mall() {
            products = new ArrayList<>();
            initProducts();
        }

        public void initProducts() {
            Product C1 = new Product("Laptop",10001 , 1200D);
            Product C2 = new Product("Milk",10002 , 10.50D);
            Product C3 = new Product("Watermelon",10003,10.50D);
            Product C4 = new Product("Charger",10004,8.88D);
            Product C5 = new Product("Pot",10005,55.03D);
            Product C6 = new Product("Phone",10006,600.00D);
            products.add(C1);
            products.add(C2);
            products.add(C3);
            products.add(C4);
            products.add(C5);
            products.add(C6);
        }

        public void getAllProducts() {
            for(Product p : products){
                System.out.println(p);
            }
        }
        public Product findProduct(int id){
            for(Product p : products){
                if(p.getId() == id)
                    return p;
            }
           return null;
    }
    public Product findProductByName(String name){
            for(Product p :products){
                if(p.getProductName().equals(name))
                    return p;
            }
            return null;
    }
}