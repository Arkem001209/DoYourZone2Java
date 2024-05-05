import java.util.Scanner;

public class z2app {
    public static void main(String[] args){
        int select;

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to DoYourZone2 V1.0! Use this app to track your zone 2. With each successful zone 2 workout you will get stronger! Enter your username to continue:");
        String username = input.nextLine();

        z2mechanics athlete = new z2mechanics(username);
    }
}
