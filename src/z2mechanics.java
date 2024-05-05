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
    //getter methods
    public String getUsername(){
        return username;
    }
    public int getMaxHR(){
        return maxHR;
    }
    public int getRestinghr(){
        return restinghr;
    }
    public int getLowerZone2Range(){
        return lowerZone2Range;
    }
    public int getUpperZone2Range(){
        return upperZone2Range;
    }
    public int getTotalExperiencePoints(){
        return totalExperiencePoints;
    }

    //setter methods
    public void setUsername(String username){
        this.username = username;
    }
    public void setMaxHR(int maxHR){
        this.maxHR = maxHR;
    }
    public void setRestinghr(int restinghr){
        this.restinghr = restinghr;
    }
    public void setLowerZone2Range(int lowerZone2Range){
        this.lowerZone2Range = lowerZone2Range;
    }
    public void setUpperZone2Range(int upperZone2Range){
        this.upperZone2Range = upperZone2Range;
    }

    public void setTotalExperiencePoints(int totalExperiencePoints) {
        this.totalExperiencePoints = totalExperiencePoints;
    }
}
