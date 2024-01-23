public class Monitor {

    // Thread 상태 : NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED

    /**
     * 모니터가 사용되는 경우
     * - 한번에 하나의 스레드만 실행되어야 할 때
     * - 여러 스레드와 협업이 필요 할 때
     */
    static class BoundedBuffer {
        private final int[] buffer = new int[5];
        private int count = 0;

        public synchronized void produce(int item) throws InterruptedException {
            while (count == buffer.length) {
                wait();
            }
            buffer[count++] = item;
            notifyAll(); // 모든 WAITING 상태의 thread들을 BLOCKED 상태로 변환 (waiting queue, condition variable)
            // 진행 중인 thread 상태는 계속 RUNNABLE 상태로 유지
        }// 끝나고 모니터 lock 반환

        public void consume() {
            int item = 0;
            synchronized (this) { // 각 인스턴스마다 monitor lock을 가지고 있음. 취득 한 후 critical section 진입
                while (count == 0) {
                    try {
                        wait(); // 호출하면서 monitor lock 반환 -> THREAD 상태 : RUNNABLE -> WAITING
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                item = buffer[--count];
                notifyAll();
            }
            System.out.println("Consume: " + item); // RUNNABLE -> TERMINATED 상태로 전환
        }
    }

    static class Main {
        public static void main(String[] args) throws InterruptedException {

            BoundedBuffer buffer = new BoundedBuffer();
            Thread consumer = new Thread(buffer::consume); // 상태 : NEW
            Thread producer = new Thread(() -> { // 상태 : NEW
                try {
                    buffer.produce(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            consumer.start(); // 상태 : RUNNABLE or BLOCKED / WAITING
            producer.start(); // 상태 : BLOCKED or RUNNABLE / WAITING

            consumer.join(); // 호출 -> main thread는 WAITING 상태로 전환 (consumer thread가 종료될 때까지)
            producer.join();
            System.out.println("완료");
        }
    }
}
