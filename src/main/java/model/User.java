package model;

import java.time.LocalDate;
import java.time.Period;

public class User {
    String email;
    String lastname;
    String firstname;
    String password;
    LocalDate birthdate;

    public User(String email, String lastname, String firstname, String password, LocalDate birthdate) {
        this.email = email;
        this.lastname = lastname;
        this.firstname = firstname;
        this.password = password;
        this.birthdate = birthdate;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isValid(){
        if(
                this.firstname != null &&
                this.lastname != null &&
                this.password != null && this.password.length() <= 40 && this.password.length() >= 8 &&
                this.birthdate != null && this.birthdate.isBefore(LocalDate.now().minusYears(13))
                //TODO check email regex
        ){
            return true;
        }else{
            return false;
        }
    }
}
