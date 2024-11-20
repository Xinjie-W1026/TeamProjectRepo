import java.util.Scanner;

public class Driver {
    private Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        new Driver();
    }
    public Driver(){

    }

    public void clearScreen() {
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }
}
