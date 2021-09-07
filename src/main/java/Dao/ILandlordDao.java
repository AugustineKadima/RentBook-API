package Dao;

import modules.Landlord;

import java.util.List;

public interface ILandlordDao {

//    Create
    void add(Landlord landlord);

//   Read
    List<Landlord> getAll();
    Landlord findById(int id);

//    Update


//    Delete
    void deleteById(int id);
    void clearAll();
}
