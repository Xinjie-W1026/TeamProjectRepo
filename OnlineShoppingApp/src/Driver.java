import java.util.Scanner;


public class Driver {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    private Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        new Driver();
    }
    public Driver(){
        Menu menu = new Menu();
    }

    public void clearScreen() {
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }
}
