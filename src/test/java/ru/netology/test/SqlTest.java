package ru.netology.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqlTest {

    @BeforeEach
    void shouldOpenWeb() {
        open("http://localhost:8080", MainPage.class);
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


    @Test
    void shouldCheckStatusSqlFirstCardWithoutCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithoutCredit(cardNumber, month, year, owner, cvs);
        Configuration.timeout = 15000;
        page.approvedByBank();
        val expected = DataHelper.getFirstCardStatus();
        val actual = DataHelper.getStatusPaymentWithoutCredit();
        assertEquals(expected, actual);

    }

    @Test
    void shouldCheckStatusSqlSecondCardWithoutCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getSecondCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithoutCredit(cardNumber, month, year, owner, cvs);
        page.approvedByBank();
        val expected = DataHelper.getSecondCardStatus();
        val actual = DataHelper.getStatusPaymentWithoutCredit();
        assertEquals(expected, actual);

    }

    @Test
    void shouldCheckStatusSqlFirstCardWithCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithCredit(cardNumber, month, year, owner, cvs);
        page.approvedByBank();
        val expected = DataHelper.getFirstCardStatus();
        val actual = DataHelper.getStatusPaymentWithCredit();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCheckStatusSqlSecondCardWithCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getSecondCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithCredit(cardNumber, month, year, owner, cvs);
        page.approvedByBank();
        val expected = DataHelper.getSecondCardStatus();
        val actual = DataHelper.getStatusPaymentWithCredit();
        assertEquals(expected, actual);
    }

}
