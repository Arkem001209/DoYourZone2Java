public class z2mechanics {
    //main parameters for user and fitness level
    private String username;
    private int maxHR;
    private int restinghr;
    private int lowerZone2Range;
    private int upperZone2Range;
    private int totalExperiencePoints;
    public z2mechanics(String Jim){
        username = "Jim";
        maxHR = 200;
        restinghr = 45;
        lowerZone2Range = 120;
        upperZone2Range = 155;
        totalExperiencePoints = 1;
    }
    public void changeExperience(int xp){
        totalExperiencePoints += xp;
    }
    public void changeMaxHR(int max){
        maxHR += max;
    }
    public void changeRestinghr(int resting){
        restinghr += resting;
    }
    public void changeLowerZone2(int lowerChange){
        lowerZone2Range += lowerChange;
    }
    public void changeUpperZone2(int upperChange){
        upperZone2Range += upperChange;
    }
}
