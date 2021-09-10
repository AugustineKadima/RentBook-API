package Dao;

import modules.Landlord;
import modules.Property;

import java.util.List;

public interface ILandlordDao {

//    Create
    void add(Landlord landlord);
    void addLandlordToProperty(Landlord landlord, Property property);

//   Read
    List<Landlord> getAll();
    Landlord findById(int id);

//    Update


//    Delete
    void deleteById(int id);
    void clearAll();
}
