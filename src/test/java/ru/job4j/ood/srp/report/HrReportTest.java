package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class HrReportTest {

    @Test
    void reportHrTest() {
    MemoryStore store = new MemoryStore();
    Calendar now = Calendar.getInstance();
    Employee worker1 = new Employee("Ivan", now, now, 100);
    Employee worker2 = new Employee("Ivan", now, now, 150);
    Employee worker3 = new Employee("Ivan", now, now, 120);
    store.add(worker1);
    store.add(worker2);
    store.add(worker3);
    Report engine = new HrReport(store);
    StringBuilder expected = new StringBuilder()
            .append("Name; Salary;")
            .append(System.lineSeparator())
            .append(worker2.getName()).append(" ")
            .append(worker2.getSalary())
            .append(System.lineSeparator())
            .append(worker3.getName()).append(" ")
            .append(worker3.getSalary())
            .append(System.lineSeparator())
            .append(worker1.getName()).append(" ")
            .append(worker1.getSalary())
            .append(System.lineSeparator());
    assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
}
}