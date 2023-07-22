package model;

import controller.publishValidator;
import dal.DALManager;

public class publishFactory {
    public static DALManager createDALManager(IConnection connectionProvider) {
        return new DALManager(connectionProvider);
    }

    public static publishValidator createValidator() {
        return new publishValidator();
    }

    // Other factory methods...

    public static IConnection createConnection(String URL, String USERNAME, String PASSWORD) {
        return new SQLConnection(URL, USERNAME, PASSWORD);
    }
}
