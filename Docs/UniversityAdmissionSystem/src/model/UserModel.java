package model;

import java.util.Objects;

public class UserModel {
    private String email;
    private String password;

    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserModel other = (UserModel) obj;
        return email.equals(other.email) && password.equals(other.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}
