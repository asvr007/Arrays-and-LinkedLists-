import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.addLast(num);
            map.put(num, map.getOrDefault(num, 0) + 1);


            if (deque.size() > m) {
                int leftMost = deque.removeFirst();
                map.put(leftMost, map.get(leftMost) - 1);
                if (map.get(leftMost) == 0) {
                    map.remove(leftMost);
                }
            }

            maxUnique = Math.max(maxUnique, map.size());

            if (maxUnique == m) {
                break;
            }
        }

        System.out.println(maxUnique);
        in.close();
    }
}
