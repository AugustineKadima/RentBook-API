package Dao;

import modules.Landlord;
import modules.Property;
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
    public void addLandlordToProperty(Landlord landlord, Property property) {
        String sql = "INSERT INTO landlords_properties (landlord_id, property_id) VALUES (:landlord_id, :property_id);";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("property_id", property.getId())
                    .addParameter("landlord_id", landlord.getId())
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Landlord> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM landlords")
                    .executeAndFetch(Landlord.class);
        }
    }

    @Override
    public Landlord findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM landlords WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Landlord.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from landlords WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from landlords";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}
