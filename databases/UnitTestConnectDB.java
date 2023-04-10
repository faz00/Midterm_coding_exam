package databases;

import org.junit.Assert;

import java.io.IOException;
import java.sql.SQLException;

public class UnitTestConnectDB {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        ConnectToMongoDB connectToMongoDB = new ConnectToMongoDB();

       //ConnectToSqlDB.connectToSqlDatabase();
        Assert.assertEquals("", "");


    }
}
