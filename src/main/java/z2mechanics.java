import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class z2mechanics {
    //main parameters for user and fitness level
    private String username;
    private int maxHR;
    private int restinghr;
    private int lowerZone2Range;
    private int upperZone2Range;
    private int totalExperiencePoints;
    private int currentLevel;

    public z2mechanics(String Jim){
        username = "Jim";
        maxHR = 200;
        restinghr = 45;
        lowerZone2Range = 120;
        upperZone2Range = 155;
        totalExperiencePoints = 1;
        currentLevel = 1;
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
    public void levelUp(){
        currentLevel ++;
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
    public int getCurrentLevel(){
        return currentLevel;
    }
    public int getCalculatedLevel(int totalXP){
        return totalXP/100;
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

    public void createUser(String user_name, String new_passwordHash) {
        Connection conn = null;
        PreparedStatement insertUserStmt = null;
        PreparedStatement insertPasswordStmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            conn .setAutoCommit(false);

            //query for usernames
            String userSQL = "INSERT INTO users (user_name) VALUES (?)";
            insertUserStmt = conn.prepareStatement(userSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            insertUserStmt.setString(1, user_name);

            insertUserStmt.executeUpdate();

            var generatedKeys = insertUserStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int userId = generatedKeys.getInt(1);

                String passwordSQL = "INSERT INTO user_passwords (user_id, user_password) (?, ?)";
                insertPasswordStmt = conn.prepareStatement(passwordSQL);
                insertPasswordStmt.setInt(1, userId);
                insertPasswordStmt.setString(2, new_passwordHash);

                insertPasswordStmt.executeUpdate();

                conn.commit();
            }
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback(); // Roll back transaction in case of error
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (insertUserStmt != null) insertUserStmt.close();
                if (insertPasswordStmt != null) insertPasswordStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

