package struct;

public class LoginInfo{

    private String username,password;
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
//    public String getMessage(){
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}