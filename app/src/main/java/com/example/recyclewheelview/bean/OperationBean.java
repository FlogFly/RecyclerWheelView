package com.example.recyclewheelview.bean;

/**
 * Project:RecycleWheelView
 * Author:dyping
 * Date:2017/7/11 19:36
 */

public class OperationBean {

    private String name;
    private String money;
    private String yearPercent;
    private String yearCompletePercent;

    public OperationBean(String name, String money, String yearPercent, String yearCompletePercent) {
        this.name = name;
        this.money = money;
        this.yearPercent = yearPercent;
        this.yearCompletePercent = yearCompletePercent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getYearPercent() {
        return yearPercent;
    }

    public void setYearPercent(String yearPercent) {
        this.yearPercent = yearPercent;
    }

    public String getYearCompletePercent() {
        return yearCompletePercent;
    }

    public void setYearCompletePercent(String yearCompletePercent) {
        this.yearCompletePercent = yearCompletePercent;
    }
}
