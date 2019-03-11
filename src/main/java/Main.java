import DAO.DBWorker;
import Services.AccountService;
import View.ConsoleView;
import View.View;

import java.sql.SQLException;

public class Main {

    // сделать dbWorker singleton;
    // проект на гитхаб

    public static void main(String[] args) {

        DBWorker dbWorker = new DBWorker();

        View consoleView = new ConsoleView(dbWorker);
        try {
            consoleView.showAimData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
