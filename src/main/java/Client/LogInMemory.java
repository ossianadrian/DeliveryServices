package Client;
import Server.*;


public class LogInMemory {
    //this is a singleton

    private Mailer mailer;
    private Administrator admin;
    private ActivityCoordinator activityCoordinator;
    private String typeOfUserLoggedIn="";

    public String getTypeOfUserLoggedIn() {
        return typeOfUserLoggedIn;
    }

    public void setTypeOfUserLoggedIn(String typeOfUserLoggedIn) {
        this.typeOfUserLoggedIn = typeOfUserLoggedIn;
    }

    public void setMailer(Mailer m){
        this.mailer = m;

    }

    public void setAdmin(Administrator a){
        this.admin = a;
    }

    public void setActivityCoordinator(ActivityCoordinator a){
        this.activityCoordinator = a;
    }

    public Mailer getMailer() {
        return mailer;
    }

    public Administrator getAdmin() {
        return admin;
    }

    public ActivityCoordinator getActivityCoordinator() {
        return activityCoordinator;
    }


}
