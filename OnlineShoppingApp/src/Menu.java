import java.util.Scanner;
    public class Menu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public Menu() {
        ShoppingMenu();
    }

    public void mainMenu() {

    }
    public void ShoppingMenu(){
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            Mall mall = new Mall();
            ShoppingCart  userCart = new ShoppingCart();
            System.out.println(ANSI_BLUE +"1:enter the Market");
            System.out.println("2:check the ShoppingCart");
            System.out.println("3:exit the System" + ANSI_RESET);
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    clearScreen();
                    mall.getAllProducts();
                    System.out.println(ANSI_BLUE +"Enter the product ID to add the product to your ShoppingCart" + ANSI_RESET);
                    if (sc.hasNextInt()) {
                        int id = sc.nextInt();
                        System.out.println(ANSI_YELLOW + "Confirm to add the product to your ShoppingCart(1:yes;2:no)" + ANSI_RESET);
                        int isAdd = sc.nextInt();
                        if (isAdd == 1) {
                            System.out.print(ANSI_BLUE + "Amount of the added:" + ANSI_RESET);
                            int number = sc.nextInt();
                            userCart.addProduct(mall.findProduct(id), number);
                        }
                        else if (isAdd == 2) {
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    clearScreen();
                    userCart.showProduct();
                    System.out.println(ANSI_BLUE + "Enter the product ID to remove the product from your ShoppingCart" + ANSI_RESET);
                    if (sc.hasNextInt()) {
                        int id = sc.nextInt();
                        System.out.println(ANSI_YELLOW + "Confirm to remove the product(1:yes;2:no)" + ANSI_RESET);
                        int isDelete = sc.nextInt();
                        if (isDelete == 1) {
                            if(userCart.removeProduct(mall.findProduct(id).getProductName()))
                                System.out.println(ANSI_BLUE + "Remove Successfully" + ANSI_RESET);
                            else System.out.println(ANSI_RED + "Please enter the correct ID" + ANSI_RESET);
                        } 
                        else if (isDelete == 2) {
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    sc.close();
                    return;
                }
                default : {
                    System.out.println("Invalid choice entered: " + choice);
                }
                    
            }
        }
    }
    public void clearScreen() {
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }    


}
