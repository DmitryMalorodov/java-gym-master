package ru.yandex.practicum.gym.tests.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.gym.dto.TrainingSession;
import ru.yandex.practicum.gym.enums.DayOfWeek;

import java.util.List;

import static ru.yandex.practicum.gym.helpers.GeneralAssert.assertEquals;

@DisplayName("Проверка метода получения всех тренировок, упорядоченных по времени начала, за конкретный день недели")
public class GetTrainSessionsForDayTest extends TimetableTest {

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    void testGetTrainingSessionsForDaySingleSession() {
        timetable.addNewTrainingSession(mondayChildTrainingSession);

        //Проверить, что за понедельник вернулось одно занятие
        assertEquals(1, timetable.getTrainingSessionsForDay(DayOfWeek.MONDAY).size(), QUANTITY_ERROR_MESSAGE);
        //Проверить, что за вторник не вернулось занятий
        assertEquals(0, timetable.getTrainingSessionsForDay(DayOfWeek.TUESDAY).size(), QUANTITY_ERROR_MESSAGE);
    }

    @Test
    void testGetTrainingSessionsForDayMultipleSessions() {
        //Добавление тренировок в расписание
        addTrainingSessionData();

        // Проверить, что за понедельник вернулось одно занятие
        assertEquals(1, timetable.getTrainingSessionsForDay(DayOfWeek.MONDAY).size(), QUANTITY_ERROR_MESSAGE);

        // Проверить, что за четверг вернулось два занятия в правильном порядке: сначала в 13:00, потом в 20:00
        List<TrainingSession> sessions = timetable.getTrainingSessionsForDay(DayOfWeek.THURSDAY);
        assertEquals(2, sessions.size(), QUANTITY_ERROR_MESSAGE);
        assertEquals(13, sessions.getFirst().getTimeOfDay().getHours(), TIME_ERROR_MESSAGE);
        assertEquals(20, sessions.getLast().getTimeOfDay().getHours(), TIME_ERROR_MESSAGE);

        // Проверить, что за среду вернулось два занятия в правильном порядке: сначала в 20:00, потом в 20:01
        List<TrainingSession> wednesdaySessions = timetable.getTrainingSessionsForDay(DayOfWeek.WEDNESDAY);
        assertEquals(2, wednesdaySessions.size(), QUANTITY_ERROR_MESSAGE);
        assertEquals(0, wednesdaySessions.getFirst().getTimeOfDay().getMinutes(), TIME_ERROR_MESSAGE);
        assertEquals(1, wednesdaySessions.getLast().getTimeOfDay().getMinutes(), TIME_ERROR_MESSAGE);

        // Проверить, что за вторник не вернулось занятий
        assertEquals(0, timetable.getTrainingSessionsForDay(DayOfWeek.TUESDAY).size(), QUANTITY_ERROR_MESSAGE);
    }

    private void addTrainingSessionData() {
        timetable.addNewTrainingSession(thursdayAdultTrainingSession);
        timetable.addNewTrainingSession(mondayChildTrainingSession);
        timetable.addNewTrainingSession(thursdayChildTrainingSession);
        timetable.addNewTrainingSession(saturdayChildTrainingSession);
        timetable.addNewTrainingSession(wednesdayAdultTrainingSession2);
        timetable.addNewTrainingSession(wednesdayAdultTrainingSession);
    }
}
