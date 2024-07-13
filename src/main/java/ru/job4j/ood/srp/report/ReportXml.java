package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportXml implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportXml(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        StringBuilder formatXml = new StringBuilder();
        formatXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<employees>\n");
        for (Employee employee : employees) {
            formatXml.append("\t<employee>\n")
                    .append("\t\t<name>").append(employee.getName()).append("</name>\n")
                    .append("\t\t<hired>").append(
                            dateTimeParser.parse(employee.getHired())).append("</hired>\n")
                    .append("\t\t<fired>").append(
                            dateTimeParser.parse(employee.getFired())).append("</fired>\n")
                    .append("\t\t<salary>").append(employee.getSalary()).append("</salary>\n")
                    .append("\t</employee>\n");
        }
        formatXml.append("</employees>\n");
        return formatXml.toString();
    }
}
