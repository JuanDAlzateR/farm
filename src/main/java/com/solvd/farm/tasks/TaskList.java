package com.solvd.farm.tasks;

import com.solvd.farm.interfaces.ITask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TaskList {
    public static final Logger LOGGER = LogManager.getLogger(TaskList.class);
    private ArrayList<TaskThread> taskList = new ArrayList<>();

    public void add(ITask task) {
        taskList.add(new TaskThread(task));
    }

    public void add(String taskName, ITask task) {
        taskList.add(new TaskThread(taskName, task));
    }

    public void add(TaskThread taskThread) {
        taskList.add(taskThread);
    }

    public void display() {
        LOGGER.info("--Tasks List--");
        IntStream.range(0, taskList.size())
                .forEach(i -> {
                    LOGGER.info(i + ") " + taskList.get(i));
                });
    }

    public void start(int i) {
        taskList.get(i).start();
    }

    public void stop(int i) {
        taskList.get(i).stop();
        taskList.remove(i);
    }

}
