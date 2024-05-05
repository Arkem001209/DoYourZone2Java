import java.util.Scanner;

public class z2app {
    public static void main(String[] args){
        int select;

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to DoYourZone2 V1.0! Use this app to track your zone 2. With each successful zone 2 workout you will get stronger! Enter your username to continue:");
        String username = input.nextLine();

        z2mechanics athlete = new z2mechanics(username);

        //User instructions
        zone2Menu(username);

        do {
            System.out.println(">> [1] Update Max Heart Rate");
            System.out.println(">> [2] Update Resting Heart Rate");
            System.out.println(">> [3] Update Zone 2 Heart Rate Zone");
            System.out.println(">> [4] Upload metrics for a workout");
            System.out.println(">> [5] Exit game");

            select = input.nextInt();
            if (select == 7){
                continue;
            }
        } while (select != 5);

    }
    public static void zone2Menu(String username){
        System.out.println(
                "-----------------------------------------------------------------------------------------------" +
                        "\nWelcome back " + username + "! Its time to grow that aerobic base. I hope youve been keeping to"+
                        "\nyour zone 2 heart rate zones. See below your most up to date statistics:"+
                        "\n DEVELOPER TO DO: Add to this instruction list when server isset up"+
                        "\n"+
                        "\n"+
                        "\n What would you like to do now?"+
                        "\n-----------------------------------------------------------------------------------------------"
        );
    }
}

