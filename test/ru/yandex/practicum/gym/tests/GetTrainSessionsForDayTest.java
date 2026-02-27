package ru.yandex.practicum.gym.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.gym.Timetable;
import ru.yandex.practicum.gym.dto.TrainingSession;
import ru.yandex.practicum.gym.enums.DayOfWeek;

import java.util.List;

import static ru.yandex.practicum.gym.helpers.GeneralAssert.assertEquals;

@DisplayName("Проверка метода получения всех тренировок, упорядоченных по времени начала, за конкретный день недели")
public class GetTrainSessionsForDayTest extends TimetableTest {

    @BeforeEach
    public void setUp() {
        timetable = new Timetable();
    }

    @Test
    @DisplayName("Проверить, что за вторник не вернулось занятий")
    void testGetTrainingSessionsForDaySingleSession() {
        timetable.addNewTrainingSession(mondayChildTrainingSession);

        assertEquals(0, timetable.getTrainingSessionsForDay(DayOfWeek.TUESDAY).size(), QUANTITY_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Проверить, что за понедельник вернулось одно занятие")
    void testGetTrainingSessionsForDaySingleSession2() {
        timetable.addNewTrainingSession(mondayChildTrainingSession);

        assertEquals(1, timetable.getTrainingSessionsForDay(DayOfWeek.MONDAY).size(), QUANTITY_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Проверить, что за четверг вернулось три занятия в правильном порядке: сначала два в 13:00, потом одно в 20:00")
    void testGetTrainingSessionsForDayMultipleSessions() {
        //Добавление тренировок в расписание
        addTrainingSessionData();

        List<TrainingSession> sessions = timetable.getTrainingSessionsForDay(DayOfWeek.THURSDAY);
        assertEquals(3, sessions.size(), QUANTITY_ERROR_MESSAGE);
        assertEquals(13, sessions.getFirst().getTimeOfDay().getHours(), TIME_ERROR_MESSAGE);
        assertEquals(13, sessions.get(1).getTimeOfDay().getHours(), TIME_ERROR_MESSAGE);
        assertEquals(20, sessions.getLast().getTimeOfDay().getHours(), TIME_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Проверить, что за среду вернулось два занятия в правильном порядке: сначала в 20:00, потом в 20:01")
    void testGetTrainingSessionsForDayMultipleSessions2() {
        //Добавление тренировок в расписание
        addTrainingSessionData();

        List<TrainingSession> wednesdaySessions = timetable.getTrainingSessionsForDay(DayOfWeek.WEDNESDAY);
        assertEquals(2, wednesdaySessions.size(), QUANTITY_ERROR_MESSAGE);
        assertEquals(0, wednesdaySessions.getFirst().getTimeOfDay().getMinutes(), TIME_ERROR_MESSAGE);
        assertEquals(1, wednesdaySessions.getLast().getTimeOfDay().getMinutes(), TIME_ERROR_MESSAGE);
    }

    private void addTrainingSessionData() {
        timetable.addNewTrainingSession(thursdayAdultTrainingSession);
        timetable.addNewTrainingSession(mondayChildTrainingSession);
        timetable.addNewTrainingSession(thursdayChildTrainingSession);
        timetable.addNewTrainingSession(saturdayChildTrainingSession);
        timetable.addNewTrainingSession(wednesdayAdultTrainingSession2);
        timetable.addNewTrainingSession(wednesdayAdultTrainingSession);
        timetable.addNewTrainingSession(thursdayAdultTrainingSession2);
    }
}
