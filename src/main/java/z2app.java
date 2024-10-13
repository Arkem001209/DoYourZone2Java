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
            if (select == 5){
                System.out.println("Goodbye");
                continue;
            }
            else if (select == 1){
                System.out.println("Your current Max Heart rate is " + athlete.getMaxHR() + ". What would you like to update it to?");
                int tempMaxHR = input.nextInt();
                athlete.setMaxHR(tempMaxHR);
                System.out.println("Max Heart rate is updated");
                showCurrentStats(athlete);
            }
            else if (select == 2) {
                System.out.println("Your current Resting Heart Rate is " + athlete.getRestinghr() + ". What would you like to update it to?");
                int temprestingHR = input.nextInt();
                athlete.setRestinghr(temprestingHR);
                System.out.println("Your resting heart rate is updated");
                showCurrentStats(athlete);
            }
            else if (select == 3) {
                System.out.println("Your current zone 2 heart rate range is: " + athlete.getLowerZone2Range() + " - " + athlete.getUpperZone2Range() + ". First enter your new lower zone two range number.");
                int templowerband = input.nextInt();
                athlete.setLowerZone2Range(templowerband);
                System.out.println("New lower band set. Now set the upper band.");
                int tempupperband = input.nextInt();
                athlete.setUpperZone2Range(tempupperband);
                System.out.println("new zone 2 range set! Good luck with your training.");
                showCurrentStats(athlete);
            }

            else if (select == 4) {
                System.out.println("Please enter the average Heart rate of your activity");
                int tempactivityhr = input.nextInt();
                if (tempactivityhr >= athlete.getLowerZone2Range() && tempactivityhr <= athlete.getUpperZone2Range()) {
                    System.out.println("Well done for keeping it zone 2! you have gained experience");
                    athlete.setTotalExperiencePoints(athlete.getTotalExperiencePoints() + 10);
                    if (athlete.getCalculatedLevel(athlete.getTotalExperiencePoints()) >= athlete.getCurrentLevel()){
                        athlete.levelUp();
                        System.out.println("Level up! Keep up the good work, you are now level " + athlete.getCurrentLevel());
                        //athlete.setTotalExperiencePoints(1);
                    }
                    else{
                        System.out.println(">> Current Experience Points: " + athlete.getTotalExperiencePoints());
                    }
                }
                else {
                    System.out.println("Kill that ego! Overdoing it isn't going to make you faster. Remember that for your next zone 2 workout.");
                }
                showCurrentStats(athlete);
            }
        } while (select != 5);

    }
    public static void zone2Menu(String username){
        System.out.println(
                "-----------------------------------------------------------------------------------------------" +
                        "\nWelcome back " + username + "! Its time to grow that aerobic base. I hope you've been keeping"+
                        "\nto your zone 2 heart rate zones. See below your most up to date statistics:"+
                        "\n DEVELOPER TO DO: Add to this instruction list when server is set up"+
                        "\n"+
                        "\n"+
                        "\n What would you like to do now?"+
                        "\n-----------------------------------------------------------------------------------------------"
        );
    }

    private static void showCurrentStats(z2mechanics username) {
        System.out.println(">> Current Max Heart Rate: " + username.getMaxHR());
        System.out.println(">> Current Resting Heart Rate: " + username.getRestinghr());
        System.out.println(">> Current lower Z2 Heart Rate Range: " + username.getLowerZone2Range());
        System.out.println(">> Current upper Z2 Heart Rate Range: " + username.getUpperZone2Range());
        System.out.println(">> Current XP: " + username.getTotalExperiencePoints());
        System.out.println(">> Current Level: " + username.getCurrentLevel());
    }
}

