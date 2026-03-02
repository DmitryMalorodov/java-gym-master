package ru.yandex.practicum.gym.tests;

import ru.yandex.practicum.gym.Timetable;
import ru.yandex.practicum.gym.helpers.TestData;

public class TimetableTest extends TestData {
    static final String QUANTITY_ERROR_MESSAGE = "Ожидаемое кол-во занятий '%d' не соответствует фактическому '%d'";
    static final String TIME_ERROR_MESSAGE = "Ожидаемое время занятия '%d' не соответствует фактическому '%d'";
    static final String COACH_ERROR_MESSAGE = "Ожидаемое кол-во тренеров '%d' не соответствует фактическому '%d'";

    static Timetable timetable;
}
