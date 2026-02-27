package ru.yandex.practicum.gym;

import ru.yandex.practicum.gym.dto.Coach;
import ru.yandex.practicum.gym.dto.TimeOfDay;
import ru.yandex.practicum.gym.dto.TrainingSession;
import ru.yandex.practicum.gym.enums.DayOfWeek;

import java.util.*;

public class Timetable {

    private final HashMap<DayOfWeek, TreeMap<TimeOfDay, List<TrainingSession>>> timetable = new HashMap<>();

    /**
     * Добавление новой тренировочной сессии в расписание
     * - Если по времени добавляемой тренировки вернулся null, то создаем список
     * - Если по дню недели добавляемой тренировки вернулся null, то создаем мапу и список
     * - Добавляем в созданный список тренировку
     * - Добавляем в созданную мапу созданный список по времени добавляемой тренировки
     * - Кладем в целевую мапу timetable созданную мапу в данном методе по ключу дня недели
     * @param trainingSession - тренировчная сессия для добавления
     */
    public void addNewTrainingSession(TrainingSession trainingSession) {
        TreeMap<TimeOfDay, List<TrainingSession>> innerMap = timetable.get(trainingSession.getDayOfWeek());
        List<TrainingSession> sessions;

        if (innerMap != null) {
            sessions = innerMap.get(trainingSession.getTimeOfDay());
            if (sessions == null) {
                sessions = new ArrayList<>();
            }
        } else {
            sessions = new ArrayList<>();
            innerMap = new TreeMap<>();
        }

        sessions.add(trainingSession);
        innerMap.put(trainingSession.getTimeOfDay(), sessions);
        timetable.put(trainingSession.getDayOfWeek(), innerMap);
    }

    /**
     * Получение всех тренировок, упорядоченных по времени начала, за конкретный день недели
     * @param dayOfWeek - день недели
     * @return - список тренировок упорядоченных по времени начала от меньшего к большему
     */
    public List<TrainingSession> getTrainingSessionsForDay(DayOfWeek dayOfWeek) {
        List<TrainingSession> trainingSessions = new ArrayList<>();
        TreeMap<TimeOfDay, List<TrainingSession>> innerMap = timetable.getOrDefault(dayOfWeek, new TreeMap<>());

        for (TimeOfDay key : innerMap.navigableKeySet()) {
            trainingSessions.addAll(innerMap.get(key));
        }

        return trainingSessions;
    }

    /**
     * Получение всех тренировок, начинающихся в конкретное время, за конкретный день недели
     * @param dayOfWeek - день недели
     * @param timeOfDay - время начала тренировки
     * @return список тренировок по времени и дню недели
     */
    public List<TrainingSession> getTrainingSessionsForDayAndTime(DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {
        return timetable.getOrDefault(dayOfWeek, new TreeMap<>()).getOrDefault(timeOfDay, new ArrayList<>());
    }

    /**
     * Получение списка тренеров с количеством тренировок для каждого во всем расписании
     * - Получаем список тренировок поочередно:
     *     - по каждому дню недели
     *     - по каждому существующему времени начала
     * - Перебираем каждый полученный список тренировок
     * - Если в результирующей мапе уже есть тренер по проверямой тренировке, то увеличиваем счетчик кол-ва тренировок
     * для этого тренера
     * - Если в результирующей мапе нет тренера по проверямой тренировке, то добавляем тренера и создаем новый счетчик
     * - Достаем все значения (списки) из результирующей мапы и кладем все в один список
     * - Сортируем финальный список
     * @return - список тренеров с количеством тренировок упорядоченных в порядке убывания
     */
    public List<CounterOfTrainings> getCountByCoaches() {
        Map<Coach, CounterOfTrainings> result = new HashMap<>();

        for (TreeMap<TimeOfDay, List<TrainingSession>> value : timetable.values()) {
            for (List<TrainingSession> innerMapValue : value.values()) {
                for (TrainingSession trainingSession : innerMapValue) {
                    Coach coach = trainingSession.getCoach();
                    if (result.containsKey(coach)) {
                        result.get(coach).incrementTrainQuantity();
                    } else {
                        result.put(coach, new CounterOfTrainings(coach).incrementTrainQuantity());
                    }
                }
            }
        }

        List<CounterOfTrainings> counterOfTrainings = new ArrayList<>(result.values().stream().toList());
        Collections.sort(counterOfTrainings);
        return counterOfTrainings.reversed();
    }
}
