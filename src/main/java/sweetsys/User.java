package sweetsys;

public class User {
    String username;
    String pass;
    int userlevel;
    String email;
    String city;

    public User(String username,String pass){
        this.username=username;
        this.pass=pass;
    }

    public User(String username,String pass, int userlevel){
        this.username=username;
        this.pass=pass;
        this.userlevel=userlevel;

    }

    public User(String username,String pass, int userlevel,String email){
        this.username=username;
        this.pass=pass;
        this.userlevel=userlevel;
        this.email=email;
    }

    public User(String username, String pass, int userlevel, String email, String city) {
        this.username = username;
        this.pass = pass;
        this.userlevel = userlevel;
        this.email = email;
        this.city = city;
    }



    public User(String username, String pass, String city) {
        this.username = username;
        this.pass = pass;
        this.city = city;
    }

    public User(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "{" +
                "username='" + username + '\'' +
                ", pass='" + pass + '\'' +
                ", userlevel=" + userlevel +
                ", Email='" + email + '\'' +
                ", city='" + city + '\'' +
                '}'+"\n";
    }



    public User() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(int userlevel) {
        this.userlevel = userlevel;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }
}
