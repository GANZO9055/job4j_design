package ru.job4j.ood.ocp;

public class Document {

    /*
    Нарушение принципа OCP, при добавлении нового типа документа (TXT),
    происходит изменение метода printDocument
     */
    public void printDocument(String documentType) {
        if (documentType.equals("PDF")) {
            System.out.println("Printing PDF document");
        } else if (documentType.equals("Word")) {
            System.out.println("Printing Word document");
        } else if (documentType.equals("TXT")) {
            System.out.println("Printing TXT document");
        } else {
            System.out.println("Error");
        }
    }
}
