/*There is a turnstile at the entrance of a building. It can allow only one person to pass at each second. People are either entering or exiting. You're given:

time[] – an array where time[i] is the time when person i will arrive at the turnstile.

direction[] – an array where direction[i] is:

0 if person i wants to enter,

1 if person i wants to exit.

Return an array result[] where result[i] is the time when person i passes through the turnstile.
*/



import java.util.*;

public class TurnstileSimulation {

    static class Person {
        int index, time, direction;

        Person(int index, int time, int direction) {
            this.index = index;
            this.time = time;
            this.direction = direction;
        }
    }

    public int[] getTurnstileTimes(int[] time, int[] direction) {
        int n = time.length;
        int[] result = new int[n];

        Queue<Person> enter = new LinkedList<>();
        Queue<Person> exit = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (direction[i] == 0) {
                enter.offer(new Person(i, time[i], 0));
            } else {
                exit.offer(new Person(i, time[i], 1));
            }
        }

        int currentTime = 0;
        int lastUsedTime = -1;
        int lastDirection = 1; // default priority to exit if idle

        while (!enter.isEmpty() || !exit.isEmpty()) {
            boolean enterReady = !enter.isEmpty() && enter.peek().time <= currentTime;
            boolean exitReady = !exit.isEmpty() && exit.peek().time <= currentTime;

            if (enterReady || exitReady) {
                if (enterReady && exitReady) {
                    if (lastUsedTime < currentTime) {
                        // Turnstile idle last second — priority to exit
                        if (exit.peek().time <= currentTime) {
                            Person p = exit.poll();
                            result[p.index] = currentTime;
                            lastDirection = 1;
                        } else {
                            Person p = enter.poll();
                            result[p.index] = currentTime;
                            lastDirection = 0;
                        }
                    } else if (lastDirection == 1) {
                        Person p = exit.poll();
                        result[p.index] = currentTime;
                    } else {
                        Person p = enter.poll();
                        result[p.index] = currentTime;
                    }
                } else if (exitReady) {
                    Person p = exit.poll();
                    result[p.index] = currentTime;
                    lastDirection = 1;
                } else {
                    Person p = enter.poll();
                    result[p.index] = currentTime;
                    lastDirection = 0;
                }
                lastUsedTime = currentTime;
            }

            currentTime++;
        }

        return result;
    }

    public static void main(String[] args) {
        TurnstileSimulation sim = new TurnstileSimulation();
        int[] time = {0, 0, 1, 5};
        int[] direction = {0, 1, 1, 0};
        int[] result = sim.getTurnstileTimes(time, direction);
        System.out.println(Arrays.toString(result)); // [2, 0, 1, 5]
    }
}

