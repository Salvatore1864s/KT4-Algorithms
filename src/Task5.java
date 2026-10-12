
import java.util.*;

public class Task5 {

    static class Pair {
        int i;
        int j;
        long sum;

        Pair(int i, int j, long sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int j = 0; j < m; j++) {
            b[j] = sc.nextInt();
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            Comparator.comparingLong(p -> p.sum)
        );

        for (int i = 0; i < n && i < k; i++) {
            pq.add(new Pair(i, 0, (long) a[i] + b[0]));
        }

        long answer = 0;

        for (int count = 0; count < k; count++) {
            Pair current = pq.poll();
            answer = current.sum;

            if (current.j + 1 < m) {
                int nextJ = current.j + 1;

                pq.add(new Pair(
                    current.i,
                    nextJ,
                    (long) a[current.i] + b[nextJ]
                ));
            }
        }

        System.out.println(answer);
    }
}
