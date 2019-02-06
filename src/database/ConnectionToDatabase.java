package database;

import java.sql.*;

public class ConnectionToDatabase {

    public ResultSet rs;

    public ConnectionToDatabase(String username, String password) {
        connectToDatabase(username, password);
    }

    private void connectToDatabase(String username, String password) {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11225254?verifyServerCertificate=false&useSSL=true", username, password);

            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("select * from questions");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void queryData(int numberOfRows, int id[], String question[], String answer1[], String answer2[], String answer3[]) throws SQLException {
        int counter = 0;
        while(rs.next()) {
            for (int i = counter; i < numberOfRows; i++) {
                id[i] = rs.getInt(1);
                question[i] = rs.getString(2);
                answer1[i] = rs.getString(3);
                answer2[i] = rs.getString(4);
                answer3[i] = rs.getString(5);
            }
            counter++;
        }
    }
}