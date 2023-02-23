package problem_502;

import java.util.*;

class Solution {
    class Project implements Comparable<Project>{
        public int profit;
        public int capital;

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }

        @Override
        public int compareTo(Project project) {
            return Integer.compare(capital, project.capital);
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            projects.add(new Project(profits[i], capital[i]));
        }
        Collections.sort(projects);

        PriorityQueue<Project> priorityQueue = new PriorityQueue<>(new Comparator<Project>() {
            @Override
            public int compare(Project project1, Project project2) {
                return Integer.compare(project2.profit, project1.profit);
            }
        });
        int i = 0;
        for (int j = 0; j < k; j++) {
            // put projects to priorityQueue which we can buy
            while (i < n && projects.get(i).capital <= w) {
                priorityQueue.add(projects.get(i));
                i++;
            }

            // get the best project that we can buy
            Project bestProject = priorityQueue.poll();
            if (bestProject == null || bestProject.profit == 0) {
                return w;
            }

            w += bestProject.profit;
        }
        return w;
    }
}