package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.val;

import java.sql.SQLException;
import java.util.Locale;

import static java.sql.DriverManager.getConnection;

public class DataHelper {
    private static Faker faker = new Faker(new Locale("en"));

    private DataHelper() {
    }

    public static String getFirstCardNumber() {
        return "4444 4444 4444 4441";
    }

    public static String getFirstCardStatus() {
        return "APPROVED";
    }

    public static String getSecondCardNumber() {
        return "4444 4444 4444 4442";
    }

    public static String getSecondCardStatus() {
        return "DECLINED";
    }

    public static String getCardNumberDifferent() {
        return faker.business().creditCardNumber();
    }

    public static String getCardNumberEmpty() {
        return "                   ";
    }

    public static String getValidMonth() {
        return "01";
    }

    public static String getInvalidMonth() {
        return "13";
    }

    public static String getEmptyMonth() {
        return "  ";
    }

    public static String getZeroMonth() {
        return "00";
    }

    public static String getValidYear() {
        return "24";
    }

    public static String getInvalidYear() {
        return "14";
    }

    public static String getEmptyYear() {
        return "  ";
    }

    public static String getValidOwner() {
        return faker.name().fullName();
    }

    public static String getInvalidOwner() {
        return "Петр(. 123";
    }

    public static String getEmptyOwner() {
        return "  ";
    }

    public static String getValidCvs() {
        return "456";
    }

    public static String getInvalidCvs() {
        return "12";
    }

    public static String getEmptyCvs() {
        return "  ";
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
}
