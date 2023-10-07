package ru.netology.Todos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void matchesMeetingTestContainsInTopic() {
        Task meeting = new Meeting(
                1, "домашнее задание", "нетология", "в понедельник"
        );

        boolean expected = true;
        boolean actual = meeting.matches("задание");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesMeetingTestNoContainsInTopic() {
        Task meeting = new Meeting(
                1, "домашнее задание", "нетология", "в понедельник"
        );

        boolean expected = false;
        boolean actual = meeting.matches("тест");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesMeetingTestContainsInProject() {
        Task meeting = new Meeting(
                1, "домашнее задание", "нетология", "в понедельник"
        );

        boolean expected = true;
        boolean actual = meeting.matches("нетология");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesMeetingTestNoContainsInProject() {
        Task meeting = new Meeting(
                1, "домашнее задание", "нетология", "в понедельник"
        );

        boolean expected = false;
        boolean actual = meeting.matches("5");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesMeetingTestContainsInTopicandProject() {
        Task meeting = new Meeting(
                1, "домашнее задание нетологии", "нетология", "в понедельник"
        );

        boolean expected = true;
        boolean actual = meeting.matches("нетол");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesMeetingTestNoContainsInTopicandProject() {
        Task meeting = new Meeting(
                1, "домашнее задание", "нетология", "в понедельник"
        );

        boolean expected = false;
        boolean actual = meeting.matches("вторник");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesSimpleTaskTestContainsInTitle() {
        Task simpleTask = new SimpleTask(2, "Написать тесты");

        boolean expected = true;
        boolean actual = simpleTask.matches("тест");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesSimpleTaskTestNoContainsInTitle() {
        Task simpleTask = new SimpleTask(2, "Написать тесты");

        boolean expected = false;
        boolean actual = simpleTask.matches("решить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesEpicTestContainsIn2Subtasks() {
        Task epic = new Epic(3, new String[]{"посмотреть видео", "написать код", "написать тесты"});

        boolean expected = true;
        boolean actual = epic.matches("написать");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void matchesEpicTestContainsIn1Subtasks() {
        Task epic = new Epic(3, new String[]{"посмотреть видео", "написать код", "написать тесты"});

        boolean expected = true;
        boolean actual = epic.matches("видео");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void matchesEpicTestNoContainsInSubtasks() {
        Task epic = new Epic(3, new String[]{"посмотреть видео", "написать код", "написать тесты"});

        boolean expected = false;
        boolean actual = epic.matches("спать");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void matchesEpicTestNoSubtasks() {
        Task epic = new Epic(3, new String[]{});

        boolean expected = false;
        boolean actual = epic.matches("нет");
        Assertions.assertEquals(expected, actual);
    }
}
