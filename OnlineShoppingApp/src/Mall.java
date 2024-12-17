import java.util.ArrayList;

public class Mall{
        private ArrayList<Product> products= new ArrayList<>();
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public Mall() {
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

        public boolean addProduct(Product product){

            return products.add(product);
        }

        public boolean updateProduct(int id ,double newPrice){
            Product foundProduct = findProduct(id);
            if(foundProduct != null){
                foundProduct.setPrice(newPrice);
                return true;
            }
            return false;
        }
    public boolean removeProduct(int id){
        if(!products.isEmpty()) {
            Product foundProduct = findProduct(id);
            if (foundProduct != null) {
                products.remove(foundProduct);
                return true;
            }
        }
        return false;
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
        public void findProductByName(String name){
            if(name.isEmpty())  return ;
                for(Product p :products){
                    if(p.getProductName().toLowerCase().contains(name.toLowerCase()))
                        System.out.println(p);
            }
    }//partial match search
}