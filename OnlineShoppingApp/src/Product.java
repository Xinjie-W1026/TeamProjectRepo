public class Product {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private String productName = "";
    private int id = -1;
    private double price = 0;

    public Product(String productName, int id, double price) {
        setProductName(productName);
        setId(id);
        setPrice(price);
    }

    public void setProductName(String productName) {
        if(!productName.isEmpty()) {
            this.productName = productName;
        }
        else {
            System.out.println(ANSI_RED + "Unable to set productName, Must not be empty" + ANSI_RESET);
        }
    }

    public void setId(int id) {
        if(id >= 10000 && id <= 99999) {
            this.id = id;
        }
        else {
            System.out.println(ANSI_RED + "Unable to set id, Must be 5-digit integer" + ANSI_RESET);
        }
    }

    public void setPrice(double price) {
        if(price > 0) {
            this.price = price;
        }
        else{
            System.out.println(ANSI_RED + "Unable to set price, Must be positive" + ANSI_RESET);
        }
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return  "id: " + id +
                ", productName : " + productName  +
                ", price: $" + price;
    }
}
