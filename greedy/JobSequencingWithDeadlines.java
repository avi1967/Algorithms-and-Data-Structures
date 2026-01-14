// Algorithm: Job Sequencing with Deadlines (Greedy)
// Time Complexity: O(n log n + n * D)
//   - Sorting jobs by profit: O(n log n)
//   - Scheduling across deadlines: O(n * D), where D is max deadline
// Space Complexity: O(D)
// Key Idea: Greedily schedule the most profitable jobs first,
//           placing each job as late as possible before its deadline.
//
// Correctness (Greedy Choice Property):
// - There exists an optimal solution that schedules the job with
//   the highest profit among all remaining jobs at the latest
//   available slot before its deadline.

package greedy;

public class JobSequencingWithDeadlines {

    // Job representation
    static class Job {
        String id;
        int deadline;
        int profit;

        Job(String id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    /**
     * Schedules jobs to maximize total profit subject to deadlines.
     *
     * @param jobs array of jobs
     * @return maximum achievable profit
     */
    public static int schedule(Job[] jobs) {

        // Step 1: Sort jobs by decreasing profit
        quickSort(jobs, 0, jobs.length - 1);

        // Step 2: Find maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // Step 3: Allocate time slots
        boolean[] slot = new boolean[maxDeadline];
        int totalProfit = 0;

        // Step 4: Greedily assign jobs
        for (Job job : jobs) {
            for (int t = job.deadline - 1; t >= 0; t--) {
                if (!slot[t]) {
                    slot[t] = true;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        return totalProfit;
    }

    // QuickSort jobs by descending profit
    private static void quickSort(Job[] jobs, int low, int high) {
        if (low < high) {
            int p = partition(jobs, low, high);
            quickSort(jobs, low, p - 1);
            quickSort(jobs, p + 1, high);
        }
    }

    private static int partition(Job[] jobs, int low, int high) {
        int pivot = jobs[high].profit;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (jobs[j].profit > pivot) {
                i++;
                swap(jobs, i, j);
            }
        }
        swap(jobs, i + 1, high);
        return i + 1;
    }

    private static void swap(Job[] jobs, int i, int j) {
        Job temp = jobs[i];
        jobs[i] = jobs[j];
        jobs[j] = temp;
    }
}
