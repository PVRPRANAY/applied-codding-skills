import java.util.*;

class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        // Add the current request
        queue.add(t);

        // Remove requests older than 3000 milliseconds
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        // Number of requests in [t - 3000, t]
        return queue.size();
    }
}