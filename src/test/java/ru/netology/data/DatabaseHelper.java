package ru.netology.data;

import lombok.val;

import java.sql.DriverManager;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class DatabaseHelper {
    private DatabaseHelper() {
    }

    public static String getStatusPaymentWithoutCredit() {
        val statusSql = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";

        try (
                val connection = getConnection("jdbc:mysql://localhost:3306/app", "user", "pass");
                val statusStmt = connection.createStatement();
        ) {
            try (val rs = statusStmt.executeQuery(statusSql)) {
                if (rs.next()) {
                    val status = rs.getString(1);

                    return status;
                }
                return null;
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static String getStatusPaymentWithCredit() {
        val statusSql = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";

        try (
                val connection = getConnection("jdbc:mysql://localhost:3306/app", "user", "pass");
                val statusStmt = connection.createStatement();
        ) {
            try (val rs = statusStmt.executeQuery(statusSql)) {
                if (rs.next()) {
                    val status = rs.getString(1);

                    return status;
                }
                return null;
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void cleanDataBase() {

        val pays = "DELETE FROM payment_entity";
        val credits = "DELETE FROM credit_request_entity";
        val orders = "DELETE FROM order_entity";

        try (val connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "user", "pass");
             val prepareStatPay = connect.prepareStatement(pays);
             val prepareStatCredit = connect.prepareStatement(credits);
             val prepareStatOrder = connect.prepareStatement(orders);


        ) {
            prepareStatPay.executeUpdate(pays);
            prepareStatCredit.executeUpdate(credits);
            prepareStatOrder.executeUpdate(orders);

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
