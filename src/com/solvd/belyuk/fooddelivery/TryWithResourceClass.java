package com.solvd.belyuk.fooddelivery;

import com.solvd.belyuk.fooddelivery.exception.WrongAgeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public class TryWithResourceClass implements AutoCloseable {

    public static final Logger LOGGER = LogManager.getLogger(TryWithResourceClass.class);

    @Override
    public void close() {
        LOGGER.info("Resource closed.");
    }

    public int countMyAge(LocalDate dob) throws WrongAgeException {
        int age = LocalDate.now().getYear() - dob.getYear();
        if (age < 0) {
            throw new WrongAgeException();
        }
        return age;
    }
}
