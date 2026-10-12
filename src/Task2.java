
import java.util.*;

public class Task2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            frequency.put(number, frequency.getOrDefault(number, 0) + 1);
        }

        List<Integer> numbers = new ArrayList<>(frequency.keySet());

        numbers.sort((a, b) -> {
            int byFrequency = frequency.get(b).compareTo(frequency.get(a));

            if (byFrequency != 0) {
                return byFrequency;
            }

            return Integer.compare(a, b);
        });

        for (int i = 0; i < k; i++) {
            if (i > 0) {
                System.out.print(" ");
            }

            System.out.print(numbers.get(i));
        }

        System.out.println();
    }
}
