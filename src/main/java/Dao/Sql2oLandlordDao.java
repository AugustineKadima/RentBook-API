package Dao;

import modules.Landlord;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oLandlordDao implements ILandlordDao{

    private final Sql2o sql2o;

    public Sql2oLandlordDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Landlord landlord) {
        String sql = "INSERT INTO landlords (name, email, phone_number, gender, location) VALUES (:name, :email, :phone_number, :gender, :location)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(landlord)
                    .executeUpdate()
                    .getKey();
            landlord.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Landlord> getAll() {
        return null;
    }

    @Override
    public Landlord findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
