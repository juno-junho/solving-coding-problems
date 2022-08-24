import java.util.LinkedList;
import java.util.Queue;

public class Truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // truck weight 배열에서 하나씩 돌면서 다리를 건너게 하는데,  Queue로 하면되겠다 ...
        // queue의 total 요소의 합이 weight를 넘으면 안된다.
        Queue<Integer> queue = new LinkedList<>();
        int second = 0;
        int totalWeight = 0;
        for (int i = 0; i < truck_weights.length; i++) {
            totalWeight += truck_weights[i];
            queue.add(truck_weights[i]);
            second++;

            //
        }
        return second;
    }

}
