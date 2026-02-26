package ru.yandex.practicum.gym.helpers;

import ru.yandex.practicum.gym.dto.Coach;
import ru.yandex.practicum.gym.dto.Group;
import ru.yandex.practicum.gym.dto.TimeOfDay;
import ru.yandex.practicum.gym.dto.TrainingSession;
import ru.yandex.practicum.gym.enums.Age;
import ru.yandex.practicum.gym.enums.DayOfWeek;

public class TestData {
    private static final Group groupChild = new Group("Акробатика для детей", Age.CHILD, 60);
    private static final Group groupAdult = new Group("Акробатика для взрослых", Age.ADULT, 90);
    private static final Coach coach = new Coach("Васильев", "Николай", "Сергеевич");
    private static final Coach coach2 = new Coach("Васильев", "Николай", "Николаевич");
    private static final Coach coach3 = new Coach("Иванов", "Николай", "Николаевич");

    protected static final TrainingSession mondayChildTrainingSession = new TrainingSession(groupChild, coach,
            DayOfWeek.MONDAY, new TimeOfDay(13, 0));
    protected static final TrainingSession wednesdayAdultTrainingSession = new TrainingSession(groupAdult, coach2,
            DayOfWeek.WEDNESDAY, new TimeOfDay(20, 0));
    protected static final TrainingSession wednesdayAdultTrainingSession2 = new TrainingSession(groupAdult, coach2,
            DayOfWeek.WEDNESDAY, new TimeOfDay(20, 1));
    protected static final TrainingSession thursdayAdultTrainingSession = new TrainingSession(groupAdult, coach2,
            DayOfWeek.THURSDAY, new TimeOfDay(20, 0));
    protected static final TrainingSession thursdayChildTrainingSession = new TrainingSession(groupChild, coach,
            DayOfWeek.THURSDAY, new TimeOfDay(13, 0));
    protected static final TrainingSession thursdayAdultTrainingSession2 = new TrainingSession(groupAdult, coach3,
            DayOfWeek.THURSDAY, new TimeOfDay(13, 0));
    protected static final TrainingSession saturdayChildTrainingSession = new TrainingSession(groupChild, coach,
            DayOfWeek.SATURDAY, new TimeOfDay(10, 0));
}
