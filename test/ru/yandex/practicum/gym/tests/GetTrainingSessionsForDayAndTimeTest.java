package ru.yandex.practicum.gym.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.gym.dto.TimeOfDay;
import ru.yandex.practicum.gym.enums.DayOfWeek;

import static ru.yandex.practicum.gym.helpers.GeneralAssert.assertEquals;

@DisplayName("Проверка метода получения всех тренировок, начинающихся в конкретное время, за конкретный день недели")
public class GetTrainingSessionsForDayAndTimeTest extends TimetableTest {

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    void testGetTrainingSessionsForDayAndTime() {
        //Добавление тренировок в расписание
        addTrainingSessionData();

        //Проверить, что за понедельник в 13:00 вернулось одно занятие
        assertEquals(1,
                timetable.getTrainingSessionsForDayAndTime(DayOfWeek.MONDAY, new TimeOfDay(13, 0)).size(),
                QUANTITY_ERROR_MESSAGE);

        //Проверить, что за понедельник в 14:00 не вернулось занятий
        assertEquals(0,
                timetable.getTrainingSessionsForDayAndTime(DayOfWeek.MONDAY, new TimeOfDay(14, 0)).size(),
                QUANTITY_ERROR_MESSAGE);

        //Проверить, что за пятницу в 13:00 не вернулось занятий
        assertEquals(0,
                timetable.getTrainingSessionsForDayAndTime(DayOfWeek.FRIDAY, new TimeOfDay(13, 0)).size(),
                QUANTITY_ERROR_MESSAGE);

        //Проверить, что за четверг в 13:00 вернулось 2 занятия
        assertEquals(2,
                timetable.getTrainingSessionsForDayAndTime(DayOfWeek.THURSDAY, new TimeOfDay(13, 0)).size(),
                QUANTITY_ERROR_MESSAGE);
    }

    private void addTrainingSessionData() {
        timetable.addNewTrainingSession(mondayChildTrainingSession);
        timetable.addNewTrainingSession(thursdayAdultTrainingSession2);
        timetable.addNewTrainingSession(thursdayChildTrainingSession);
    }
}
