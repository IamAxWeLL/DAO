package DAO;

import Entity.Aim;

import java.sql.SQLException;
import java.util.List;

public interface AimDAO {

    void add(Aim a);
    List<Aim> getAll() throws SQLException;
    Aim getbyId(int id);
    void update(Aim a);
    void remove(Aim a);

}
