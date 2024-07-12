package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportJson implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final Gson gson;

    public ReportJson(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.gson = new Gson();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        List<String> formattedEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            formattedEmployees.add(formatted(employee));
        }
        return gson.toJson(formattedEmployees);
    }

    private String formatted(Employee employee) {
        return "name: " + employee.getName()
                + ", hired: " + dateTimeParser.parse(employee.getHired())
                + ", fired: " + dateTimeParser.parse(employee.getFired())
                + ", salary: " + employee.getSalary();
    }
}
