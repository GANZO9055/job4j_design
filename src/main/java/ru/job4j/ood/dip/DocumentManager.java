package ru.job4j.ood.dip;

/*
Нарушение DIP, модуль верхнего уровня (DocumentManager)
зависит от модуля низкого уровня (Printer)
 */
public class DocumentManager {
    private Printer printer;

    public DocumentManager() {
        this.printer = new Printer();
    }

    public void printDocument(String document) {
        printer.print(document);
    }
}

class Printer {
    public void print(String document) {
        System.out.println("Printing document: " + document);
    }
}

