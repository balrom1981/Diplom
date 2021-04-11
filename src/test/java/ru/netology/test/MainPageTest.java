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
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    /* Покупка без кредита */
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
    void shouldRejectSecondCardWithoutCredit() {
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
    void shouldRejectDifferentCardWithoutCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getCardNumberDifferent();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithoutCredit(cardNumber, month, year, owner, cvs);
        page.rejectByBank();
    }

    @Test
    void shouldRejectEmptyCardNumberWithoutCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getCardNumberEmpty();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithoutCredit(cardNumber, month, year, owner, cvs);
        page.formatProblems();
    }

    @Test
    void shouldRejectEmptyMonthWithoutCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getEmptyMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithoutCredit(cardNumber, month, year, owner, cvs);
        page.formatProblems();
    }

    @Test
    void shouldRejectInvalidMonthWithoutCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getInvalidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithoutCredit(cardNumber, month, year, owner, cvs);
        page.durationProblems();
    }

    @Test
    void shouldRejectZeroMonthWithoutCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getZeroMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithoutCredit(cardNumber, month, year, owner, cvs);
        page.durationProblems();
    }

    @Test
    void shouldRejectEmptyYearWithoutCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getEmptyYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithoutCredit(cardNumber, month, year, owner, cvs);
        page.formatProblems();
    }

    @Test
    void shouldRejectInvalidYearWithoutCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getInvalidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithoutCredit(cardNumber, month, year, owner, cvs);
        page.periodValidityProblems();
    }

    @Test
    void shouldRejectEmptyOwnerWithoutCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getEmptyOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithoutCredit(cardNumber, month, year, owner, cvs);
        page.necessaryField();
    }

    @Test
    void shouldRejectInvalidOwnerWithoutCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getInvalidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithoutCredit(cardNumber, month, year, owner, cvs);
        page.formatProblems();
    }

    @Test
    void shouldRejectEmptyCvsWithoutCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getEmptyCvs();
        page.buyWithoutCredit(cardNumber, month, year, owner, cvs);
        page.formatProblems();
    }

    @Test
    void shouldRejectInvalidCvsWithoutCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getInvalidCvs();
        page.buyWithoutCredit(cardNumber, month, year, owner, cvs);
        page.formatProblems();
    }


    /* Покупка с кредитом */
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
    void shouldRejectSecondCardWithCredit() {
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
    void shouldRejectDifferentCardWithCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getCardNumberDifferent();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithCredit(cardNumber, month, year, owner, cvs);
        page.rejectByBank();
    }


    @Test
    void shouldRejectEmptyCardNumberWithCredit() {
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
    void shouldRejectEmptyMonthWithCredit() {
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
    void shouldRejectInvalidMonthWithCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getInvalidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithCredit(cardNumber, month, year, owner, cvs);
        page.durationProblems();
    }

    @Test
    void shouldRejectZeroMonthWithCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getZeroMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithCredit(cardNumber, month, year, owner, cvs);
        page.durationProblems();
    }

    @Test
    void shouldRejectEmptyYearWithCredit() {
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
    void shouldRejectInvalidYearWithCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getInvalidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithCredit(cardNumber, month, year, owner, cvs);
        page.periodValidityProblems();
    }

    @Test
    void shouldRejectEmptyOwnerWithCredit() {
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
    void shouldRejectInvalidOwnerWithCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getInvalidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithCredit(cardNumber, month, year, owner, cvs);
        page.formatProblems();
    }

    @Test
    void shouldRejectEmptyCvsWithCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getEmptyCvs();
        page.buyWithCredit(cardNumber, month, year, owner, cvs);
        page.formatProblems();
    }

    @Test
    void shouldRejectInvalidCvsWithCredit() {
        MainPage page = new MainPage();
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getInvalidCvs();
        page.buyWithCredit(cardNumber, month, year, owner, cvs);
        page.formatProblems();
    }
}
