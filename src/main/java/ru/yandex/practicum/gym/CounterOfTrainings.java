package ru.yandex.practicum.gym;

import ru.yandex.practicum.gym.dto.Coach;

public class CounterOfTrainings implements Comparable<CounterOfTrainings> {
    private final Coach coach;
    private Integer trainingsQuantity;

    public CounterOfTrainings(Coach coach) {
        this.coach = coach;
        trainingsQuantity = 1;
    }

    @Override
    public int compareTo(CounterOfTrainings o) {
        return o.trainingsQuantity - trainingsQuantity;
    }

    public void incrementTrainQuantity() {
        trainingsQuantity++;
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
