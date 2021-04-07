package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private SelenideElement buttonBuy = $("[class='button button_size_m button_theme_alfa-on-white']");
    private SelenideElement buttonBuyByCredit= $$("[class='button button_view_extra button_size_m button_theme_alfa-on-white']").get(0);
    private SelenideElement fieldCardNumber = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement fieldMonth = $("[placeholder='08']");
    private SelenideElement fieldYear = $("[placeholder='22']");
    private SelenideElement fieldOwner = $(byText("Владелец"));
    private SelenideElement fieldCvc = $("[placeholder='999']");
    private SelenideElement buttonContinue = $$("[class='button button_view_extra button_size_m button_theme_alfa-on-white']").get(1);


}
