package common;


public class UserDTO {
     String UserName;
     String password;

    public UserDTO(String UserName, String password) {
        this.UserName = UserName;
        this.password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     
}
