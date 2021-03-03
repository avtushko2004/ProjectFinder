package sample;

import java.sql.*;

public class DataBaseHandler extends Config {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void regUser(User user) throws SQLException{
        String userData = "INSERT INTO " + Const.USER_TABLE + "(" +
        Const.USER_LOGIN + "," + Const.USER_PASS + "," +Const.USER_EMAIL + ")" +
                " VALUES (?,?,?)";
        try {
                PreparedStatement userPs = getDbConnection().prepareStatement(userData);
                userPs.setString(1, user.getLogin());
                userPs.setString(2, user.getPassword());
                userPs.setString(3, user.getEmail());
                userPs.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getUser(User user){
        ResultSet rs = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + "WHERE" +
                Const.USER_LOGIN + "=? AND " + Const.USER_PASS + "=?";
        try {
            PreparedStatement ps = getDbConnection().prepareStatement(select);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
