package products_shop.app.dto.view;

public class UserDtoViewFullName {

    private String firstName;

    private String lastName;

    public UserDtoViewFullName() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.firstName==null?this.lastName:String.format("%s %s",this.firstName,this.lastName);
    }

}
