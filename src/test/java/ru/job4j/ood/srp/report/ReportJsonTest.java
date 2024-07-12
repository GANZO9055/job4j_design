package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportJsonTest {

    @Test
    void conversationToJson() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();
        Employee worker1 = new Employee("Alex", now, now, 100);
        Employee worker2 = new Employee("Victor", now, now, 120);
        Employee worker3 = new Employee("Andrey", now, now, 300);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        ReportJson reportJson = new ReportJson(store, dateTimeParser);
        String json = reportJson.generate(employee -> true);
        System.out.println(json);
        assertThat(json).contains("Alex", "Victor", "Andrey");
    }
}