package Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class HelperFunctions {
    public int calculateTotal (int quantity , int ppp){
        int total = quantity * ppp;
        return total;

    }
}
