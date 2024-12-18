import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    Mall mall = new Mall();
    ShoppingCart  userCart = new ShoppingCart();
    Scanner sc = new Scanner(System.in);
    public Menu() {
        mainMenu();
    }

    public void mainMenu() {
        System.out.print(ANSI_BLUE +"""
            ----Main Menu
            0 : Exit System
            1 : Store Menu(For Administrator)
            2 : Shopping Menu(For Customer)
            """ + ANSI_RESET);
        int choice = sc.nextInt();
        while(choice!=0){
            switch (choice){
                case 1 -> StoreMenu();
                case 2 -> ShoppingMenu();
                default -> System.out.println(ANSI_RED + "Invalid choice entered: " + choice + ANSI_RESET);
            }
            System.out.print(ANSI_BLUE +"""
            ----Main Menu
            0 : Exit System
            1 : Store Menu(For Administrator)
            2 : Shopping Menu(For Customer)
            """ + ANSI_RESET);
            choice = sc.nextInt();
        }
    }
    public void StoreMenu(){
        System.out.print(ANSI_BLUE +"""
            ----Store Menu
            0 : Exit the menu
            1 : List all the products
            2 : Add product to the Store
            3 : Update product price
            4 : remove the product
            5 : search for product(name)
            """ + ANSI_RESET);
        int choice = sc.nextInt();
        while(choice != 0)
        {
            switch (choice) {
                case 1 -> listProducts();
                case 2 -> addProductToStore();
                case 3 -> updateProduct();
                case 4 -> removeProductFromStore();
                case 5 -> searchProductFromStore();
                default -> System.out.println(ANSI_RED + "Invalid choice entered: " + choice + ANSI_RESET);
            }
            System.out.print(ANSI_BLUE +"""
            ----Store Menu
            0 : Exit the menu
            1 : List all the products
            2 : Add product to the Store
            3 : Update product price
            4 : remove the product
            5 : search for product(name)
            """ + ANSI_RESET);
            choice = sc.nextInt();
        }
    }
    public void ShoppingMenu(){
        System.out.print(ANSI_BLUE +"""
            ----Shopping Menu
            0 : Exit the menu
            1 : Show all the products in mall
            2 : Search for product(name)
            3 : Add product to your Shopping Cart
            4 : Remove product from your Shopping Cart
            5 : List all the products in your Shopping Cart
            """ + ANSI_RESET);
        int choice = sc.nextInt();
        while(choice != 0)
        {
            switch (choice) {
                case 1 -> listProducts();
                case 2 -> searchProductFromStore();
                case 3 -> addProductToShoppingCart();
                case 4 -> removeProductFromShoppingCart();
                case 5 -> listProductsInShoppingCart();
                default -> System.out.println(ANSI_RED + "Invalid choice entered: " + choice + ANSI_RESET);
            }
            System.out.print(ANSI_BLUE +"""
            ----Shopping Menu
            0 : Exit the menu
            1 : Show all the products in mall
            2 : Search for product(name)
            3 : Add product to your Shopping Cart
            4 : Remove product from your Shopping Cart
            5 : List all the products in your Shopping Cart
            """ + ANSI_RESET);
            choice = sc.nextInt();
        }
    }
    private void listProducts(){
        clearScreen();
        mall.getAllProducts();
        stop(2);
    }
    private void addProductToStore(){
        System.out.println(ANSI_BLUE + "Please Enter Product Details...");
        sc.nextLine();
        System.out.print("Enter Product Name : ");
        String productName = sc.nextLine();
        System.out.print("Enter Product id : ");
        int id = sc.nextInt();
        System.out.print("Enter Product Price : " + ANSI_RESET);
        double price = sc.nextDouble();
        boolean isAdded = mall.addProduct(new Product(productName , id , price));
        if (isAdded)
            System.out.println(ANSI_BLUE + "Added Successfully" + ANSI_RESET);
        else
            System.out.println(ANSI_RED + "Please try it again" + ANSI_RESET);
        stop(1);
    }
    private void updateProduct(){
        System.out.print(ANSI_BLUE + "Enter id : " + ANSI_RESET);
        int id = sc.nextInt();
        System.out.print(ANSI_BLUE + "Enter New Price : " + ANSI_RESET);
        double price = sc.nextDouble();
        boolean isChanged = mall.updateProduct(id,price);
        if (isChanged){
            System.out.println(ANSI_BLUE + "Updated Successfully" + ANSI_RESET);
        }
        else{
            System.out.println(ANSI_RED + "Please try it again" + ANSI_RESET);
        }
        stop(1);
    }
    private void removeProductFromStore(){
        System.out.println(ANSI_BLUE + "Enter product ID to remove the product from Store: " + ANSI_RESET);
        if (sc.hasNextInt()) {
            int id = sc.nextInt();
            System.out.println(ANSI_YELLOW + "Confirm to remove the product(1:yes;2:no)" + ANSI_RESET);
            int isDelete = sc.nextInt();
            if (isDelete == 1) {
                if(mall.removeProduct(id))
                    System.out.println(ANSI_BLUE + "Removed Successfully" + ANSI_RESET);
                else
                    System.out.println(ANSI_RED + "Please enter the correct ID" + ANSI_RESET);
            }
        }
        stop(1);
    }
    private void searchProductFromStore(){
        sc.nextLine();
        System.out.print(ANSI_BLUE +"Enter product name(can be partial) to search the product:  " + ANSI_RESET);
        String productName = sc.nextLine();
        if(!mall.findProductByName(productName))
            System.out.println(ANSI_RED + "Found No Product" + ANSI_RESET);
        stop(2);
    }
    private void listProductsInShoppingCart(){
        clearScreen();
        userCart.showProduct();
        stop(2);
    }
    private void addProductToShoppingCart(){
        System.out.print(ANSI_BLUE +"Enter product ID to add the product to your ShoppingCart: " + ANSI_RESET);
        if (sc.hasNextInt()) {
            int id = sc.nextInt();
            System.out.println(ANSI_YELLOW + "Confirm to add the product to your ShoppingCart(1:yes;2:no)" + ANSI_RESET);
            int isAdd = sc.nextInt();
            if (isAdd == 1) {
                System.out.print(ANSI_BLUE + "Amount of the added:" + ANSI_RESET);
                int number = sc.nextInt();
                if(userCart.addProduct(mall.findProduct(id), number))
                    System.out.println(ANSI_BLUE +"Added Successfully" + ANSI_RESET);
                else
                    System.out.println(ANSI_RED + "Please try it again" + ANSI_RESET);
            }
        }
        stop(1);
    }
    private void removeProductFromShoppingCart(){
        System.out.println(ANSI_BLUE + "Enter the product ID to remove the product from your ShoppingCart : " + ANSI_RESET);
        if (sc.hasNextInt()) {
            int id = sc.nextInt();
            System.out.println(ANSI_YELLOW + "Confirm to remove the product(1:yes;2:no)" + ANSI_RESET);
            int isDelete = sc.nextInt();
            if (isDelete == 1) {
                if(userCart.removeProduct(mall.findProduct(id).getProductName()))
                    System.out.println(ANSI_BLUE + "Removed Successfully" + ANSI_RESET);
                else System.out.println(ANSI_RED + "Please enter the correct ID" + ANSI_RESET);
            }
        }
        stop(1);
    }
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private void stop(int second){
        try {
            TimeUnit.SECONDS.sleep(second);
        }
        catch(Exception e) {}
    }
}
