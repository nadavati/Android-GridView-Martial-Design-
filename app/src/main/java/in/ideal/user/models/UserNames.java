package in.ideal.user.models;

/**
 * Created by Siva on 20-10-2015.
 */
public class UserNames {

    private String name;
    private String bloodGroup;
    private String phoneNmuber;
    private String area;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return name;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPhoneNmuber() {
        return phoneNmuber;
    }

    public void setPhoneNmuber(String phoneNmuber) {
        this.phoneNmuber = phoneNmuber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return name + " : " + bloodGroup + "\n" +phoneNmuber + "\n" + area
                + "\n" + location;
    }
}
