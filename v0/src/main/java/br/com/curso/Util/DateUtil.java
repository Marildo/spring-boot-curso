package br.com.curso.Util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtil {

    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime dateTime){
        return DateTimeFormatter.ofPattern("yyy-mm-dd HH:mm:ss").format(dateTime);
    }
}
