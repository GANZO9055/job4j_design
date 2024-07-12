package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportXmlTest {

    @Test
    void conversationToXml() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Alex", now, now, 100);
        Employee worker2 = new Employee("Victor", now, now, 120);
        Employee worker3 = new Employee("Andrey", now, now, 300);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        ReportXml reportXml = new ReportXml(store, parser);
        String xml = reportXml.generate(employee -> true);
        System.out.println(xml);
        assertThat(xml).contains("Alex", "Victor", "Andrey");
    }
}