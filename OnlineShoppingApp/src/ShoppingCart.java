import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Products> productList = new ArrayList<>();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public boolean addProduct(Product product,int quantity){
        if(quantity <= 0|| product == null) return false;
        int foundindex = findProduct(product.getProductName());
        if(foundindex != -1){
            productList.get(foundindex).setQuantity(quantity + productList.get(foundindex).getQuantity());
        }
        else {
            productList.add(new Products(product,quantity));
        }
        return true;
    }

    private int findProduct(String productName){
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
        }
        return false;
    }
    public double totalPrice(){
        double sum = 0;
        for(Products p :productList)
            sum += p.getItem().getPrice()*p.getQuantity();
        return sum;
    }
    public void showProduct(){
        if(!productList.isEmpty()){
            for(Products p :productList)
                System.out.println(ANSI_BLUE + p + ANSI_RESET);
            System.out.println(ANSI_BLUE + "The total price is $"+totalPrice() + ANSI_RESET);
        }
        else{
            System.out.println(ANSI_RED + "No product in the Shopping Cart" + ANSI_RESET);
        }
    }
    private class Products {
        private final Product item;
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
                System.out.println(ANSI_RED + "Unable to set quantity, Must be positive" + ANSI_RESET);
            }
        }
        public String toString() {
            return item + ", The amount of products: " + quantity;
        }
    }
}
