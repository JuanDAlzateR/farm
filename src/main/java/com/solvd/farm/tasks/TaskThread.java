package com.solvd.farm.tasks;

import com.solvd.farm.interfaces.ITask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TaskThread {
    public static final Logger LOGGER = LogManager.getLogger(TaskThread.class);
    private ITask task;
    private Thread thread;
    private String name = "new task";

    public TaskThread(ITask task) {
        this.task = task;
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        this.thread = thread;
    }

    public TaskThread(String name, ITask task) {
        this(task);
        this.name = name;

    }

    public void start() {
        thread.start();
    }

    public void stop() {
        task.stop();
        thread.interrupt();
    }

    @Override
    public String toString() {
        return name;
    }

}
