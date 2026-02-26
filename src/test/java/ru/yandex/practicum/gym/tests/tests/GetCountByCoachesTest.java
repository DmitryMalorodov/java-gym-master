package ru.yandex.practicum.gym.tests.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ru.yandex.practicum.gym.helpers.GeneralAssert.assertEquals;

@DisplayName("Проверка метода получения список тренеров с количеством тренировок упорядоченных в порядке убывания")
public class GetCountByCoachesTest extends TimetableTest {

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    void testGetCountByCoaches() {
        //Проверить, что список с количеством тренеров пустой
        assertEquals(0, timetable.getCountByCoaches().size(), COACH_ERROR_MESSAGE);

        //Добавление тренировок в расписание
        addTrainingSessionData();

        //Проверить, что список с количеством тренеров равен 3
        assertEquals(3, timetable.getCountByCoaches().size(), COACH_ERROR_MESSAGE);

        //Проверить, что первый тренер в списке имеет 3 тренировки
        assertEquals(3, timetable.getCountByCoaches().getFirst().getTrainingsQuantity(),
                QUANTITY_ERROR_MESSAGE);
        //Проверить, что второй тренер в списке имеет 2 тренировки
        assertEquals(2, timetable.getCountByCoaches().get(1).getTrainingsQuantity(),
                QUANTITY_ERROR_MESSAGE);
        //Проверить, что третий тренер в списке имеет 1 тренировку
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
