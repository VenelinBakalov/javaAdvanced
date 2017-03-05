package companyHierarchy;

/**
 * Created by Venelin on 4.3.2017 г..
 */
public class Project {

    private String name;
    private String startDate;
    private String details;
    private String state;

    public Project(String name, String startDate, String details, String state) {
        this.setName(name);
        this.setStartDate(startDate);
        this.setDetails(details);
        this.setState(state);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", startDate='" + startDate + '\'' +
                ", details='" + details + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 3) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private void setStartDate(String startDate) {
        if (startDate == null || startDate.trim().length() < 3) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.startDate = startDate;
    }

    private void setDetails(String details) {
        if (details == null || details.trim().length() < 3) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.details = details;
    }

    private void setState(String state) {
        if (state == null || state.trim().length() < 3 || (!state.equals("open") && !state.equals("closed"))) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.state = state;
    }
}
