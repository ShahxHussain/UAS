package controller;

import dal.UserDAL;
import model.UserModel;

public class UserController {
    private UserDAL userDAL;

    public UserController() {
        this.userDAL = new UserDAL();
    }

    public void registerUser(String email, String password) {
        UserModel user = new UserModel(email, password);
        boolean success = userDAL.addUser(user);

        if (success) {
            System.out.println("User registered successfully!");
        } else {
            System.out.println("User registration failed!");
        }
    }

    public boolean authenticateUser(String email, String password) {
        UserModel user = new UserModel(email, password);
        return userDAL.authenticate(user);
    }
}
