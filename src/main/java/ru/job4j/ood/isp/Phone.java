package ru.job4j.ood.isp;

public interface Phone {
    void call();
    void answer();
    void toEmail();
}
/*
Нарушениие принципа ISP, неверное выделение абстракции,
из-за чего в классе LandlinePhone (в методе toEmail) возникает ошибка.
 */
class LandlinePhone implements Phone {

    @Override
    public void call() {
        System.out.println("Calling a number");
    }

    @Override
    public void answer() {
        System.out.println("Answer the number");
    }

    @Override
    public void toEmail() {
        throw new RuntimeException("Error");
    }
}

class TouchPhone implements Phone {

    @Override
    public void call() {
        System.out.println("Calling a number");
    }

    @Override
    public void answer() {
        System.out.println("Answer the number");
    }

    @Override
    public void toEmail() {
        System.out.println("Sending by email");
    }
}
