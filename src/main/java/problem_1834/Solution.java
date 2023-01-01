package problem_1834;

import java.util.*;

class Solution {
    static class Task implements Comparable<Task> {
        private int[] task;
        private int index;

        public Task(int[] task, int index) {
            this.task = task;
            this.index = index;
        }

        @Override
        public int compareTo(Task o) {
            if (this.task[0] > o.task[0]) {
                return 1;
            }
            if (this.task[0] < o.task[0]) {
                return -1;
            }
            return Integer.compare(this.task[1], o.task[1]);
        }

        @Override
        public String toString() {
            return "Task{" +
                    "task=" + Arrays.toString(task) +
                    ", index=" + index +
                    '}';
        }
    }

    public int[] getOrder(int[][] tasks) {
        // Init
        int n = tasks.length;
        List<Task> tasksList = new ArrayList<>();

        // Fill tasksList from tasks
        for (int i = 0; i < n; i++) {
            tasksList.add(new Task(tasks[i], i));
        }

        // Sorting tasks
        Collections.sort(tasksList);

        PriorityQueue<Task> queue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task task1, Task task2) {
                if (Integer.compare(task1.task[1], task2.task[1]) == 0) {
                    return Integer.compare(task1.index, task2.index);
                }
                return Integer.compare(task1.task[1], task2.task[1]);
            }
        });

        int cpuTime = tasksList.get(0).task[0];
        int[] result = new int[n];
        int countFinishTasks = 0;
        int indexTasksList = 0;

        while (countFinishTasks < n) {
            // do task from queue
            if (queue.isEmpty()) {
                cpuTime = tasksList.get(indexTasksList).task[0];
            } else {
                Task task = queue.poll();
                cpuTime += task.task[1];
                result[countFinishTasks] = task.index;
                countFinishTasks++;
            }

            while (indexTasksList < n && tasksList.get(indexTasksList).task[0] <= cpuTime) {
                queue.add(tasksList.get(indexTasksList));
                indexTasksList++;
            }
        }
        return result;
    }
}