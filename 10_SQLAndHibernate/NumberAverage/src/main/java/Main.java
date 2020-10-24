
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost/skillbox?serverTimezone=UTC";
        try {
            Connection connection = DriverManager.getConnection(url, "root", "adminadmin");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name, COUNT(*)/(MAX(MONTH(subscription_date))-MIN(MONTH(subscription_date))+1) as Avg_purchases FROM purchaselist GROUP BY course_name ORDER BY Avg_purchases DESC");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("course_name") + "  -  " + resultSet.getDouble("Avg_purchases"));
            }
            resultSet.close();
            statement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
