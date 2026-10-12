
import java.util.*;

public class Task4 {

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

    static Node[] tree;
    static long answer = Long.MIN_VALUE;

    static long dfs(int index) {
        if (index == -1) {
            return 0;
        }

        Node node = tree[index];

        long left = Math.max(0, dfs(node.left));
        long right = Math.max(0, dfs(node.right));

        answer = Math.max(answer, node.value + left + right);

        return node.value + Math.max(left, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        tree = new Node[n];

        for (int i = 0; i < n; i++) {
            long value = sc.nextLong();
            int left = sc.nextInt();
            int right = sc.nextInt();

            tree[i] = new Node(value, left, right);
        }

        dfs(0);
        System.out.println(answer);
    }
}
