package ru.job4j.ood.srp.formatter;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class GregorianCalendarJSON implements JsonSerializer<GregorianCalendar> {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");
    @Override
    public JsonElement serialize(GregorianCalendar calendar, Type type, JsonSerializationContext context) {
        return context.serialize(DATE_FORMAT.format(calendar.getTime()));
    }
}
