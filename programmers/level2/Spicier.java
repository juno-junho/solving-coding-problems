
import java.util.PriorityQueue;
// heap이라는 자료구조에 대해서 공부하기...
// PriorityQueue 쓰이는 구나... 확실히 알기...

public class Spicier {
    // 스코빌 지수 k이상.
    // 모든 음식의 스코빌 지수를 k 이상으로 만들기위해서 지수가 가장 낮은 두개음식을 섞어 새음식 만듬
    // output = 가장 안매운 음식 스코빌 지수 + (두번째로 안매운 스코빌 지수*2)
    // 모든 음식의 스코빌 지수가 k 이상 될때까지 섞는다.
    // 모든 음식의 스코빌 지수를 k 이상으로 만들기 위해서 섞어야 하는 최소횟수 return
    static int solution(int[] scoville, int K) {
        // 스코빌에서 가장 낮은거 두개 뽑는다. (sort)
        // 계산해서 새로운것 만든다.
        // 가장 낮은게 k 이상인지 확인한다
        // 반복
        int mix = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // scoville꺼 다 담기.
        for (int a = 0; a < scoville.length; a++) {
            priorityQueue.offer(scoville[a]);
        }
        // 비어있지 않고 제일 작은 값이 k 보다 작으면 mix하기.
        while (priorityQueue.peek() < K){
            int mixed = mix(priorityQueue.poll(), priorityQueue.poll());
            mix++;
            priorityQueue.add(mixed);
            // 믹스 후 비어 있거나 이제 1개 밖에 안남아있으면 -1 반환
            if (priorityQueue.size() <= 0) return -1;
        }
        // 처음부터 다 k 보다 크면 0 반환 / 아니면 mix된 후 k보다
        return mix;
    }
    static int mix(int a, int b){
        return  a + 2*b;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2}, 2));
    }
}
