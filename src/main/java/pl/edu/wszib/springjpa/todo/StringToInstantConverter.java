package pl.edu.wszib.springjpa.todo;

import org.springframework.core.convert.converter.Converter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class StringToInstantConverter implements Converter<String, Instant> {
    @Override
    public Instant convert(String source) {
        return LocalDate.parse(source)
                .atStartOfDay()
                .toInstant(ZoneOffset.UTC);
    }
}
