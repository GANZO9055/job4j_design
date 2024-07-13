package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.GregorianCalendarJSON;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportJson implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final Gson gson;

    public ReportJson(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.gson = new GsonBuilder()
                .registerTypeAdapter(GregorianCalendar.class, new GregorianCalendarJSON())
                .setPrettyPrinting()
                .create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        return gson.toJson(employees);
    }
}
