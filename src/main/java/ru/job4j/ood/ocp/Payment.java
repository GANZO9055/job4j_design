package ru.job4j.ood.ocp;

public class Payment {

    /*
    Нарушение принципа OCP, при добавлении нового типа оплаты (Qr),
    происходит изменение метода paymentType
     */
    public void paymentType(String pay) {
        if (pay.equals("creditCard")) {
            System.out.println("Payment credit card");
        } else if (pay.equals("cash")) {
            System.out.println("Payment cash");
        } else if (pay.equals("Qr")) {
            System.out.println("Payment Qr");
        } else {
            System.out.println("Error");
        }
    }
}
