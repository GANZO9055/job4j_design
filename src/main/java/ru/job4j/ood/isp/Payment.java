package ru.job4j.ood.isp;

public interface Payment {
    void paymentCash();
    void paymentQr();
    void paymentTransferMoney();
}
/*
Нарушениие принципа ISP, неверно разделены интерфейсы,
в следствии чего классы, реализующие данный интерфейс,
реализуют методы, которые не вписываются в логику данных классов.
 */
class PaymentCash implements Payment {

    @Override
    public void paymentCash() {
        System.out.println("Payment is completed");
    }

    @Override
    public void paymentQr() {
        throw new RuntimeException("Error");
    }

    @Override
    public void paymentTransferMoney() {
        throw new RuntimeException("Error");
    }
}

class PaymentByBankTransfer implements Payment {

    @Override
    public void paymentCash() {
        throw new RuntimeException("Error");
    }

    @Override
    public void paymentQr() {
        System.out.println("Payment is completed");
    }

    @Override
    public void paymentTransferMoney() {
        System.out.println("Payment is completed");
    }
}