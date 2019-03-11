package View;

import Entity.Account;
import DAO.DBWorker;
import Entity.Aim;
import Services.AimService;

import java.sql.*;
import java.util.List;

public class ConsoleView implements View {

    private DBWorker dbWorker;
    private AimService aimService;

    public ConsoleView(DBWorker dbWorker){
        this.dbWorker = dbWorker;
        this.aimService = new AimService();
    }

    @Override
    public void showData() throws SQLException {

    }

    @Override
    public void showAimData() throws SQLException {
        List<Aim> aims = aimService.getAll();
        for (Aim a:aims) {
            System.out.println(a.toString());
        }

        //aimService.add(new Aim(4,new Date(353535),"fafa"));
    }
}