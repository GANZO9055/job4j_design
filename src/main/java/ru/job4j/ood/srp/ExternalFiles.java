package ru.job4j.ood.srp;

import java.io.File;

/*
SRP нарушен по причине разной зоны ответственности,
inputFile/outputFile работают с внешними источниками,
а processingFile работает только с внутренними файлами
 */

public interface ExternalFiles {
    String inputFile(File file);

    boolean outputFile(String string, File file);

    String processingFile(String string);
}
