package ru.yandex.practicum.gym.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.gym.Timetable;
import ru.yandex.practicum.gym.dto.TimeOfDay;
import ru.yandex.practicum.gym.enums.DayOfWeek;

import static ru.yandex.practicum.gym.helpers.GeneralAssert.assertEquals;

@DisplayName("Проверка метода получения всех тренировок, начинающихся в конкретное время, за конкретный день недели")
public class GetTrainingSessionsForDayAndTimeTest extends TimetableTest {

    @BeforeAll
    public static void setData() {
        timetable = new Timetable();
        addTrainingSessionData();
    }

    @Test
    @DisplayName("Проверить, что за понедельник в 13:00 вернулось одно занятие")
    void testGetTrainingSessionsForDayAndTime() {
        assertEquals(1,
                timetable.getTrainingSessionsForDayAndTime(DayOfWeek.MONDAY, new TimeOfDay(13, 0)).size(),
                QUANTITY_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Проверить, что за понедельник в 14:00 не вернулось занятий")
    void testGetTrainingSessionsForDayAndTime2() {
        assertEquals(0,
                timetable.getTrainingSessionsForDayAndTime(DayOfWeek.MONDAY, new TimeOfDay(14, 0)).size(),
                QUANTITY_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Проверить, что за пятницу в 13:00 не вернулось занятий")
    void testGetTrainingSessionsForDayAndTime3() {
        assertEquals(0,
                timetable.getTrainingSessionsForDayAndTime(DayOfWeek.FRIDAY, new TimeOfDay(13, 0)).size(),
                QUANTITY_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Проверить, что за четверг в 13:00 вернулось 2 занятия")
    void testGetTrainingSessionsForDayAndTime4() {
        assertEquals(2,
                timetable.getTrainingSessionsForDayAndTime(DayOfWeek.THURSDAY, new TimeOfDay(13, 0)).size(),
                QUANTITY_ERROR_MESSAGE);
    }

    private static void addTrainingSessionData() {
        timetable.addNewTrainingSession(mondayChildTrainingSession);
        timetable.addNewTrainingSession(thursdayAdultTrainingSession2);
        timetable.addNewTrainingSession(thursdayChildTrainingSession);
    }
}
