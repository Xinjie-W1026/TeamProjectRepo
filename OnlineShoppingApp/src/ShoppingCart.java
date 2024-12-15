import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Products> productList;
    public ShoppingCart(){
        productList = new ArrayList<>();
    }
    public void addProduct(Product product,int quantity){
        if(quantity<=0||product == null) return ;
        int foundindex = findProduct(product.getProductName());
        if(foundindex != -1){
            productList.get(foundindex).setQuantity(quantity + productList.get(foundindex).getQuantity());
        }
        else {
            productList.add(new Products(product,quantity));
        }
    }

     private int findProduct(String productName){
        Products foundProduct = null;
        if(!productList.isEmpty()) {
            for(int i = 0;i < productList.size();i++)
                if(productList.get(i).getItem().getProductName().equals(productName)) {
                    return i;
                }
        }
        return -1;
    }
    public boolean removeProduct(String productName){
        if(!productList.isEmpty()) {
            int foundindex = findProduct(productName);
            if (foundindex != -1) {
                productList.remove(foundindex);
                return true;
            }
            return false;
        }
        else
            return false;
    }
    public double totalprice(){
        double sum = 0;
        for(Products p :productList)
            sum += p.getItem().getPrice()*p.getQuantity();
        return sum;
    }
    public void showProduct(){
        if(!productList.isEmpty()){
            System.out.println("The total price is $"+totalprice());
            for(Products p :productList)
                System.out.println(p);
        }
        else{
            System.out.println("No product in the Shopping Cart");
        }
    }
    private class Products {
        private Product item;
        private int quantity;

        public Products(Product item, int quantity) {
            this.item = item;
            setQuantity(quantity);
        }

        public Product getItem() {
            return item;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            if(quantity > 0) {
                this.quantity = quantity;
            }
            else{
                System.out.println("Unable to set quantity, Must be positive");
            }
        }
    }
}
