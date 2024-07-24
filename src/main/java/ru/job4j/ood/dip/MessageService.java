package ru.job4j.ood.dip;
/*
Нарушение DIP, модуль верхнего уровня (MessageService)
зависит от модуля низкого уровня (EmailSender)
 */
class MessageService {
    private EmailSender emailSender;

    public MessageService() {
        this.emailSender = new EmailSender();
    }

    public void sendMessage(String message) {
        emailSender.sendEmail(message);
    }
}

class EmailSender {
    public void sendEmail(String message) {
        System.out.println("Email sent: " + message);
    }
}
