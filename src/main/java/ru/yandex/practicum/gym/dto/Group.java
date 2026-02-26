package ru.yandex.practicum.gym.dto;

import ru.yandex.practicum.gym.enums.Age;

public class Group {
    //название группы
    private final String title;
    //тип (взрослая или детская)
    private final Age age;
    //длительность (в минутах)
    private final int duration;

    public Group(String title, Age age, int duration) {
        this.title = title;
        this.age = age;
        this.duration = duration;
    }
}
