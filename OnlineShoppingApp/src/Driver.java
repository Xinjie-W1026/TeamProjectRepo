import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Driver {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static void main(String[] args) {
        new Driver();
    }
    public Driver(){
        setup();
        clearScreen();
        Menu menu = new Menu();
        System.out.println(ANSI_BLUE + "Exiting System...bye" + ANSI_RESET);
        System.exit(0);
    }
    public void setup(){
        System.out.println(ANSI_BLUE + "///////////////////////////////////////");
        System.out.println("Online Shopping System V2.0");
        System.out.println("///////////////////////////////////////");
        System.out.println();
        System.out.println();
        System.out.print("Please wait while the system loads...");
        try {
            System.out.print("...");
            TimeUnit.SECONDS.sleep(1);
            System.out.print("...");
            TimeUnit.SECONDS.sleep(1);
            System.out.print("...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("..."  + ANSI_RESET);
            System.out.println();
        }
        catch(Exception e) {}
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
