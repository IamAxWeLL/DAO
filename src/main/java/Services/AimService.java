package Services;

import DAO.AimDAO;

import DAO.DBWorker;
import Entity.Aim;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AimService implements AimDAO {

    private DBWorker dbWorker = new DBWorker();

    @Override
    public void add(Aim a) {

        dbWorker.connectToDB();
        String insertData = "INSERT INTO aims VALUES (?,?,?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = dbWorker.getConnection().prepareStatement(insertData);
            preparedStatement.setLong(1, a.getUserID());
            preparedStatement.setDate(2, a.getDate());
            preparedStatement.setString(3, a.getUser());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbWorker.disconnectFromDB();
    }


    @Override
    public List<Aim> getAll() throws SQLException {

        String query = "select * from aims";

        dbWorker.connectToDB();

        Connection connection = dbWorker.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        List<Aim> aimsList = new ArrayList<Aim>();

        while (resultSet.next()) {

            Aim aim = new Aim(
                    resultSet.getLong(1),
                    resultSet.getDate(2),
                    resultSet.getString(3));

            aimsList.add(aim);
        }
        return aimsList;
    };

        @Override
        public Aim getbyId ( int id){

            String query = "SELECT * FROM aims WHERE id=" + id;

            dbWorker.connectToDB();

            Connection connection = dbWorker.getConnection();
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Aim aim = null;
            try {
                aim = new Aim(
                        resultSet.getInt(1),
                        resultSet.getDate(2),
                        resultSet.getString(3)
                        );
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return aim;
        }

        @Override
        public void update (Aim aims){
            dbWorker.connectToDB();

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("UPDATE accounts SET userName=\'");
            stringBuilder.append(aims.getUserID());
            stringBuilder.append("\',firstName=\'");
            stringBuilder.append(aims.getDate());
            stringBuilder.append("\',lastName=\'");
            stringBuilder.append(aims.getUser());
            stringBuilder.append("\',email=\'");
            stringBuilder.append("\'WHERE id=");
            stringBuilder.append(aims.getUserID());
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
        public void remove (Aim aims){

            dbWorker.connectToDB();
            PreparedStatement preparedStatement = null;
            String deleteData = "DELETE FROM aims WHERE id=" + aims.getUserID();

            try {
                preparedStatement = dbWorker.getConnection().prepareStatement(deleteData);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            dbWorker.disconnectFromDB();


        }
    }
