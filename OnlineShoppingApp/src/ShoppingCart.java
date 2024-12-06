import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> productList;
    public ShoppingCart(){
        productList = new ArrayList<>();
    }
    public void addProduct(Product product){
        productList.add(product);
    }
    public Product findProduct(String productName){
        Product foundProduct = null;
        if(!productList.isEmpty()) {
            for(Product p :productList){
                if(p.getProductName().equals(productName)) {
                    foundProduct = p;
                    break;
                }
            }
        }
        return foundProduct;
    }
    public boolean removeProduct(String productName){
        if(!productList.isEmpty()) {
            Product foundRemoveProduct = findProduct(productName);
            if (foundRemoveProduct != null) {
                productList.remove(foundRemoveProduct);
                return true;
            }
            return false;
        }
        else
            return false;
    }
    public double totalprice(){
        double sum=0;
        for(Product p :productList)
            sum += p.getPrice();
        return sum;
    }
    public void showProduct(){
        if(!productList.isEmpty()){
            System.out.println("The total price is "+totalprice());
            for(Product p :productList)
                System.out.println(p);
        }
        else{
            System.out.println("No product in the Shopping Cart");
        }
    }
}
