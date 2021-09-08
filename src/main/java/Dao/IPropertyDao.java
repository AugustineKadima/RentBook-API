package Dao;

import modules.Property;

import java.util.List;

public interface IPropertyDao {
//    Create
    void add(Property property);

//    Read
    List<Property> getAll();
    Property findById(int id);
    List<Property> getAllPropertyByLandlord(int landlord_id);

//    Update


//    Delete
    void deleteById(int id);
    void clearAll();
}
