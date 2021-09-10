package Dao;

import modules.Landlord;
import modules.Property;
import modules.Tenant;

import java.util.List;

public interface IPropertyDao {
//    Create
    void add(Property property);
    void addPropertyToLandlord(Property property, Landlord landlord);
    void addTenantToProperty(Property property, Tenant tenant);


    //    Read
    List<Property> getAll();
    Property findById(int id);
    List<Property> getAllPropertyByLandlord(int landlord_id);

//    Update


//    Delete
    void deleteById(int id);
    void clearAll();
}
