package ru.yandex.practicum.gym.helpers;

import org.junit.jupiter.api.Assertions;

public class GeneralAssert {

    public static <T> void assertEquals(T expectedValue, T actualValue, String errorMessage) {
        Assertions.assertEquals(expectedValue, actualValue,
                String.format(errorMessage, expectedValue, actualValue));
    }
}