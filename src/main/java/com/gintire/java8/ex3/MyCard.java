package com.gintire.java8.ex3;

import me.xdrop.jrand.generators.money.CVVGenerator;
import me.xdrop.jrand.generators.money.ExpiryDateGenerator;
import me.xdrop.jrand.generators.money.ExpiryDateGeneratorGen;
import me.xdrop.jrand.generators.money.IssueDateGenerator;
import me.xdrop.jrand.model.money.CardType;

import java.util.Date;

public class MyCard {
    String card_number;
    CVVGenerator cvv;
    ExpiryDateGeneratorGen expiry_date;
    IssueDateGenerator issue_date;
    CardType cardType;

    public MyCard() {
    }

    public MyCard(String card_number, CVVGenerator cvv, ExpiryDateGeneratorGen expiry_date, IssueDateGenerator issue_date, CardType cardType) {
        this.card_number = card_number;
        this.cvv = cvv;
        this.expiry_date = expiry_date;
        this.issue_date = issue_date;
        this.cardType = cardType;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public CVVGenerator getCvv() {
        return cvv;
    }

    public void setCvv(CVVGenerator cvv) {
        this.cvv = cvv;
    }

    public ExpiryDateGeneratorGen getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(ExpiryDateGeneratorGen expiry_date) {
        this.expiry_date = expiry_date;
    }

    public IssueDateGenerator getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(IssueDateGenerator issue_date) {
        this.issue_date = issue_date;
    }

    public String getCardType() {
        return cardType.toString();
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
}
