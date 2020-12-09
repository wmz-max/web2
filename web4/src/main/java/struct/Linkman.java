package struct;

public class Linkman {
    private String name,tel,email,address,QQ;
    private String message;
    public Linkman(String name,String tel,String email,String address,String QQ){
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.address = address;
        this.QQ = QQ;
    }
    public String getName(){ return name; }
    public String getTel() {
        return tel;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }
    public String getQQ() {
        return QQ;
    }
    public String getMessage(){ return message; }
    public void setMessage(String message) { this.message = message; }
    public void setName(String name){ this.name = name; }

}
