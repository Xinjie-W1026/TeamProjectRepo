import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> productList;
    public ShoppingCart(){
        productList = new ArrayList<>();
    }
    private void addProduct(Product product){
        productList.add(product);
    }
    private Product findProduct(String productName){
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
    private boolean removeProduct(String productName){
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
    private void showProduct(){
        if(!productList.isEmpty()){
            for(Product p :productList)
                System.out.println(p);
        }
    }
}
