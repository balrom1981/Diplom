package ru.netology.test;

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

public class MainPageTest {

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
    void shouldApproveFirstCardWithoutCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithoutCredit(cardNumber, month, year, owner, cvs);
        page.approvedByBank();
    }

    @Test
    void shouldRejectFirstCardWithoutCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getSecondCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithoutCredit(cardNumber, month, year, owner, cvs);
        page.rejectByBank();
    }

    @Test
    void shouldApproveFirstCardWithCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithCredit(cardNumber, month, year, owner, cvs);
        page.approvedByBank();
    }

    @Test
    void shouldRejectSecondCardWithoutCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getSecondCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithCredit(cardNumber, month, year, owner, cvs);
        page.rejectByBank();
    }

    @Test
    void shouldRejectEmptyCardNumber() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getCardNumberEmpty();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithCredit(cardNumber, month, year, owner, cvs);
        page.formatProblems();
    }

    @Test
    void shouldRejectEmptyMonth() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getEmptyMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithCredit(cardNumber, month, year, owner, cvs);
        page.formatProblems();
    }

    @Test
    void shouldRejectEmptyYear() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getEmptyYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithCredit(cardNumber, month, year, owner, cvs);
        page.formatProblems();
    }

    @Test
    void shouldRejectEmptyOwner() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getEmptyOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithCredit(cardNumber, month, year, owner, cvs);
        page.necessaryField();
    }

    @Test
    void shouldRejectEmptyCvs() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getEmptyCvs();
        page.buyWithCredit(cardNumber, month, year, owner, cvs);
        page.formatProblems();
    }


}
