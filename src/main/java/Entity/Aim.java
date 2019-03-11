package Entity;


import java.sql.Date;

public class Aim {

    private long userID;
    private Date date;
    private String user;

    public Aim(long userID, Date date, String user){
        this.userID = userID;
        this.date = date;
        this.user = user;
    }
    public Aim(){
        this.userID = 0;
        this.date = new Date(55555555);
        this.user = "";
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Aim{" +
                "userID=" + userID +
                ", date=" + date +
                ", user='" + user + '\'' +
                '}';
    }
}
