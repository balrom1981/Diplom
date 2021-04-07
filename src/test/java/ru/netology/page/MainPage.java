package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private SelenideElement buttonBuy = $("[class='button button_size_m button_theme_alfa-on-white']");
    private SelenideElement buttonBuyByCredit = $$("[class='button button_view_extra button_size_m button_theme_alfa-on-white']").get(0);
    private SelenideElement fieldCardNumber = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement fieldMonth = $("[placeholder='08']");
    private SelenideElement fieldYear = $("[placeholder='22']");
    private SelenideElement fieldOwner = $(byText("Владелец"));
    private SelenideElement fieldCvc = $("[placeholder='999']");
    private SelenideElement buttonContinue = $$("[class='button button_view_extra button_size_m button_theme_alfa-on-white']").get(1);

    private SelenideElement bankApproved = $(withText("Операция одобрена Банком."));
    private SelenideElement bankRefusal = $(withText("Ошибка! Банк отказал в проведении операции."));
    private SelenideElement errorFormat = $(withText("Неверный формат"));
    private SelenideElement invalidDurationCard = $(withText("Неверно указан срок действия карты"));
    private SelenideElement cardExpired = $(withText("Истёк срок действия карты"));

    public void buyWithoutCredit(){
        buttonBuy.click();
        fieldCardNumber.setValue(DataHelper.getFirstCardNumber());
        fieldMonth.setValue(DataHelper.getValidMonth());
        fieldYear.setValue(DataHelper.getValidYear());
        fieldOwner.setValue(DataHelper.getValidOwner());
        fieldCvc.setValue(DataHelper.getValidCvs());
        buttonContinue.click();
    }
    public void buyWithCredit(){
        buttonBuyByCredit.click();
        fieldCardNumber.setValue(DataHelper.getFirstCardNumber());
        fieldMonth.setValue(DataHelper.getValidMonth());
        fieldYear.setValue(DataHelper.getValidYear());
        fieldOwner.setValue(DataHelper.getValidOwner());
        fieldCvc.setValue(DataHelper.getValidCvs());
        buttonContinue.click();
    }

    public void approvedByBank(){
        bankApproved.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void rejectByBank(){
        bankRefusal.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void formatProblems(){
        errorFormat.shouldBe(visible);
    }

    public void durationProblems(){
        invalidDurationCard.shouldBe(visible);
    }

    public void periodValidityProblems(){
        cardExpired.shouldBe(visible);
    }
}
