package ru.yandex.practicum.gym.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.gym.Timetable;

import static ru.yandex.practicum.gym.helpers.GeneralAssert.assertEquals;

@DisplayName("Проверка метода получения списка тренеров с количеством тренировок упорядоченных в порядке убывания")
public class GetCountByCoachesTest extends TimetableTest {

    @BeforeEach
    public void setUp() {
        timetable = new Timetable();
    }

    @Test
    @DisplayName("Проверить, что список с количеством тренеров пустой")
    void testGetCountByCoaches() {
        assertEquals(0, timetable.getCountByCoaches().size(), COACH_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Проверить, что список с количеством тренеров равен 3")
    void testGetCountByCoaches2() {
        //Добавление тренировок в расписание
        addTrainingSessionData();

        assertEquals(3, timetable.getCountByCoaches().size(), COACH_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Проверить, что тренеры отсортированы в списке по убыванию кол-ва тренировок")
    void testGetCountByCoaches3() {
        //Добавление тренировок в расписание
        addTrainingSessionData();

        assertEquals(3, timetable.getCountByCoaches().getFirst().getTrainingsQuantity(),
                QUANTITY_ERROR_MESSAGE);
        assertEquals(2, timetable.getCountByCoaches().get(1).getTrainingsQuantity(),
                QUANTITY_ERROR_MESSAGE);
        assertEquals(1, timetable.getCountByCoaches().getLast().getTrainingsQuantity(),
                QUANTITY_ERROR_MESSAGE);
    }

    private void addTrainingSessionData() {
        timetable.addNewTrainingSession(thursdayAdultTrainingSession);
        timetable.addNewTrainingSession(mondayChildTrainingSession);
        timetable.addNewTrainingSession(thursdayChildTrainingSession);
        timetable.addNewTrainingSession(saturdayChildTrainingSession);
        timetable.addNewTrainingSession(thursdayAdultTrainingSession2);
        timetable.addNewTrainingSession(wednesdayAdultTrainingSession);
    }
}
