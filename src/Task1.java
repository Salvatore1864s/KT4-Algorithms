
import java.util.*;

public class Task1 {

    static class Node {
        long value;
        int left;
        int right;

        Node(long value, int left, int right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node[] tree = new Node[n];

        for (int i = 0; i < n; i++) {
            long value = sc.nextLong();
            int left = sc.nextInt();
            int right = sc.nextInt();

            tree[i] = new Node(value, left, right);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long sum = 0;

            for (int i = 0; i < levelSize; i++) {
                int index = queue.poll();
                Node node = tree[index];

                sum += node.value;

                if (node.left != -1) {
                    queue.add(node.left);
                }

                if (node.right != -1) {
                    queue.add(node.right);
                }
            }

            if (result.length() > 0) {
                result.append(' ');
            }

            result.append(sum);
        }

        System.out.println(result);
    }
}
