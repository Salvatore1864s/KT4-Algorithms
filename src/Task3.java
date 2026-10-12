
import java.util.*;

public class Task3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();

            if (left.isEmpty() || number <= left.peek()) {
                left.add(number);
            } else {
                right.add(number);
            }

            if (left.size() > right.size() + 1) {
                right.add(left.poll());
            } else if (right.size() > left.size()) {
                left.add(right.poll());
            }

            double median;

            if (left.size() == right.size()) {
                median = ((long) left.peek() + right.peek()) / 2.0;
            } else {
                median = left.peek();
            }

            if (result.length() > 0) {
                result.append(' ');
            }

            result.append(String.format(Locale.US, "%.1f", median));
        }

        System.out.println(result);
    }
}
