package Services;


import DAO.DBWorker;
import Entity.Account;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//connections supposed to be closed?

public class AccountService  {

    private DBWorker dbWorker;

    public AccountService(DBWorker dbWorker){
        this.dbWorker = dbWorker;
    }

    @Override
    public Account get(Account getAccount) {
        return null;
    }

    @Override
    public void create(Account createAccount) {

        dbWorker.connectToDB();
        String insertData = "INSERT INTO accounts VALUES (?,?,?,?,?,?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = dbWorker.getConnection().prepareStatement(insertData);
            preparedStatement.setString(1,createAccount.getUserName());
            preparedStatement.setString(2,createAccount.getFirstName());
            preparedStatement.setString(3,createAccount.getLastName());
            preparedStatement.setString(4,createAccount.getEmail());
            preparedStatement.setInt(5,createAccount.getAge());
            preparedStatement.setInt(6,createAccount.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbWorker.disconnectFromDB();
    }

    @Override
    public void update(Account updateAccount) {

        dbWorker.connectToDB();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE accounts SET userName=\'");
        stringBuilder.append(updateAccount.getUserName());
        stringBuilder.append("\',firstName=\'");
        stringBuilder.append(updateAccount.getFirstName());
        stringBuilder.append("\',lastName=\'");
        stringBuilder.append(updateAccount.getLastName());
        stringBuilder.append("\',email=\'");
        stringBuilder.append(updateAccount.getEmail());
        stringBuilder.append("\',age=\'");
        stringBuilder.append(updateAccount.getAge());
        stringBuilder.append("\'WHERE id=");
        stringBuilder.append(updateAccount.getId());
        System.out.println(stringBuilder.toString());
        try {
            Statement statement = dbWorker.getConnection().createStatement();
            statement.executeUpdate(stringBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dbWorker.disconnectFromDB();
    }

    @Override
    public void delete(int id) {

        dbWorker.connectToDB();
        PreparedStatement preparedStatement = null;
        String deleteData = "DELETE FROM accounts WHERE id=" + id;

        try {
            preparedStatement = dbWorker.getConnection().prepareStatement(deleteData);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dbWorker.disconnectFromDB();

    }
}
