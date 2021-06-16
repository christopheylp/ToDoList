//TEST Github Actions
package model;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class User {
    int userid;
    String email;
    String lastname;
    String firstname;
    String password;
    LocalDate birthdate;
    Item assigned;

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

    public boolean emailValid(){
        return Pattern.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$", this.email) ;

    }

    public boolean passwordIsValid(){
        return this.password != null && this.password.length() <= 40 && this.password.length() >= 8 ;
    }

    public boolean AgeIsValid(){
        return this.birthdate.isBefore(LocalDate.now().minusYears(13)) ;
    }

    public Item getAssigned() {
        return assigned;
    }

    public void setAssigned(Item assigned) {
        this.assigned = assigned;
    }

    public boolean isValid(){
        //TODO check email regex
        return this.firstname != null &&
                this.lastname != null &&
                this.passwordIsValid() &&
                this.birthdate != null && this.AgeIsValid() &&
                this.email != null && this.emailValid();
    }

    public TodoList makeTodo(String nameTodo){
        if(this.isValid()){
            return new TodoList(this, nameTodo);
        }
        return null;
    }

    public int getUserid() {
        return this.userid;
    }
}
