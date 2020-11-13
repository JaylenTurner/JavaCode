import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HW9_JaylenTurner
{
    public static void main(String[] args)
    {
        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists person");
            statement.executeUpdate("create table person (firstName string, lastName string, address string, city string, state string, zipcode string, phoneNumber string, email string)");

            Scanner fileReader = new Scanner(new File("/Users/jaylenturner/IdeaProjects/DSaAHW/src/us-contacts.csv"));
            while (fileReader.hasNextLine()){
                String[] person = fileReader.nextLine().split(",");
                String first = person[0];
                String last = person[1];
                String address = person[2];
                String city = person[3];
                String state = person[4];
                String zip = person[5];
                String phone = person[6];
                String email = person[7];

                statement.executeUpdate("insert into person values('" + first + "', '" + last + "', '" + address + "', '" + city + "', '" + state + "', '" + zip + "', '" + phone + "', '" + email +"')");
            }


            ResultSet rs = statement.executeQuery("select * from person where phoneNumber like '201%' order by lastName");
            while(rs.next())
            {
                // read the result set
                System.out.printf("\n%s %s %s %s %s %s %s %s",rs.getString("firstName"), rs.getString("lastName"),rs.getString("address"), rs.getString("city"), rs.getString("state"), rs.getString("zipcode"), rs.getString("phoneNumber"), rs.getString("email"));
            }
        }
        catch(SQLException | FileNotFoundException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }
}
