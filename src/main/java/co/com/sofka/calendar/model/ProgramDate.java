package co.com.sofka.calendar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;

@Document
public final class ProgramDate {
    @Id
    private String id;

    private final String categoryName;
    private final LocalDate date;

    public ProgramDate(String categoryName, LocalDate date) {
        this.categoryName = Objects.requireNonNull(categoryName);
        this.date = Objects.requireNonNull(date);
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
