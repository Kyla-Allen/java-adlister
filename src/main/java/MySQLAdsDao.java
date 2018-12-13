import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;


public class MySQLAdsDao implements Ads {

    private Connection connection;

//    Constructor
     MySQLAdsDao(Config config){
        try {
            this.connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    ==============================================================
    // get a list of all the ads
    public List<Ad> all(){
         List<Ad> results = new ArrayList<>();
         String query = "SELECT * FROM ads";

        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            //Loop
            while (resultSet.next()){
                // add a new Ad object to the ads arraylist (results)
                    // for each resultSet row, extract the values from each column and use them to create a new Ad object to store in the array list
                Ad adToInsert = new Ad(
                        resultSet.getLong("id"),
                        resultSet.getLong("user_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description")
                );
                results.add(adToInsert);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }


//    ==================================================================
    // insert a new ad and return the new ad's id
    public Long insert(Ad ad){
         ResultSet rs = null;
         //Making Statement Object
        try {
            Statement stmt = connection.createStatement();
            //Getting Properties
            long user_id = ad.getUserId();
            String title = ad.getTitle();
            String desc = ad.getDescription();
            //Making the Query
            String query = String.format("INSERT into ads (user_id, title, description)" +
                    "VALUES (%d, '%s', '%s')", user_id, title, desc);
            //Running Query
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        long newId = 0;
        try {
            newId=  rs.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newId;
    }


//    FOR TESTING PURPOSES
public static void main(String[] args) {

         Config config = new Config();
         MySQLAdsDao mySQLAdsDao = new MySQLAdsDao(config);

//         Ad ad = new Ad(2, "Title", "Blah Blah Blah");

    System.out.println(mySQLAdsDao.all());


}
}
