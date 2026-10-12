
import java.util.*;

public class Task6 {

    static PriorityQueue<Integer> left =
        new PriorityQueue<>(Collections.reverseOrder());

    static PriorityQueue<Integer> right =
        new PriorityQueue<>();

    static Map<Integer, Integer> delayed = new HashMap<>();

    static int leftSize = 0;
    static int rightSize = 0;

    static void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int value = heap.peek();
            int count = delayed.getOrDefault(value, 0);

            if (count == 0) {
                break;
            }

            heap.poll();

            if (count == 1) {
                delayed.remove(value);
            } else {
                delayed.put(value, count - 1);
            }
        }
    }

    static void balance() {
        if (leftSize > rightSize + 1) {
            right.add(left.poll());
            leftSize--;
            rightSize++;
            prune(left);
        } else if (leftSize < rightSize) {
            left.add(right.poll());
            rightSize--;
            leftSize++;
            prune(right);
        }
    }

    static void add(int value) {
        prune(left);
        prune(right);

        if (left.isEmpty() || value <= left.peek()) {
            left.add(value);
            leftSize++;
        } else {
            right.add(value);
            rightSize++;
        }

        balance();
    }

    static void remove(int value) {
        prune(left);
        prune(right);

        delayed.put(value, delayed.getOrDefault(value, 0) + 1);

        if (value <= left.peek()) {
            leftSize--;

            if (value == left.peek()) {
                prune(left);
            }
        } else {
            rightSize--;

            if (!right.isEmpty() && value == right.peek()) {
                prune(right);
            }
        }

        balance();
    }

    static double median() {
        prune(left);
        prune(right);

        if (leftSize > rightSize) {
            return left.peek();
        }

        return ((long) left.peek() + right.peek()) / 2.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            add(a[i]);

            if (i >= k) {
                remove(a[i - k]);
            }

            if (i >= k - 1) {
                if (result.length() > 0) {
                    result.append(' ');
                }

                result.append(
                    String.format(Locale.US, "%.1f", median())
                );
            }
        }

        System.out.println(result);
    }
}
