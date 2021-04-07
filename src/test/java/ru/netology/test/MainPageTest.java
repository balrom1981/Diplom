package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {


    @Test
    void shouldApproveFirstCardWithoutCredit() {
        MainPage page = new MainPage();
        val mainPage = open("http://localhost:8080", MainPage.class);
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
        val mainPage = open("http://localhost:8080", MainPage.class);
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
        val mainPage = open("http://localhost:8080", MainPage.class);
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
        val mainPage = open("http://localhost:8080", MainPage.class);
        val cardNumber = DataHelper.getSecondCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvs = DataHelper.getValidCvs();
        page.buyWithCredit(cardNumber, month, year, owner, cvs);
        page.rejectByBank();
    }
}