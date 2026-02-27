package ru.yandex.practicum.gym;

import ru.yandex.practicum.gym.dto.Coach;

public class CounterOfTrainings implements Comparable<CounterOfTrainings> {
    private final Coach coach;
    private int trainingsQuantity;

    public CounterOfTrainings(Coach coach) {
        this.coach = coach;
    }

    @Override
    public int compareTo(CounterOfTrainings o) {
        return trainingsQuantity - o.trainingsQuantity;
    }

    public CounterOfTrainings incrementTrainQuantity() {
        trainingsQuantity++;
        return this;
    }

    @Override
    public String toString() {
        return "CounterOfTrainings{" +
                "coach=" + coach +
                ", trainingsQuantity=" + trainingsQuantity +
                '}';
    }

    public Integer getTrainingsQuantity() {
        return trainingsQuantity;
    }
}
