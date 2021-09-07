package modules;

import java.util.Objects;

public class Landlord {

    private String name;
    private String email;
    private String phone_number;
    private String gender;
    private String location;
    private int id ;

    public Landlord(String name, String email, String phone_number, String gender, String location) {
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.gender = gender;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Landlord landlord = (Landlord) o;
        return name.equals(landlord.name) && email.equals(landlord.email) && phone_number.equals(landlord.phone_number) && gender.equals(landlord.gender) && location.equals(landlord.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, phone_number, gender, location);
    }
}
