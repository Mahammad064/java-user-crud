package test1;

public class User {

    public User(long id, String firstname, String lastName, String email){
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
    }

    private long id;
    private String firstname;
    private String lastName;
    private String email;


    public long getId(){
        return id;
    }

    public String getFirstname(){
        return firstname;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
