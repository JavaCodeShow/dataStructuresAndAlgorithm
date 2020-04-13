package datastructures.queue;

/**
 * 使用数组模拟一个队列，先进后出
 *
 * @author 江峰
 * @create 2020-04-13   16:50
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(4);
        System.out.println("队列空嘛？ = " + queue.isEmpty());
        queue.addQueue(2);
        queue.addQueue(3);
        queue.addQueue(4);
        queue.addQueue(3);
        System.out.println(queue.toString());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        queue.addQueue(5);
        System.out.println(queue.toString());
        System.out.println(queue.getQueue());
        System.out.println(queue.toString());


    }
}

class ArrayQueue {
    // 数组的最大容量
    private int maxSize;

    // 数组中当前数据的个数
    private int size = 0;

    //
    private int[] queueArr;

    ArrayQueue(int size) {
        this.maxSize = size;
        this.queueArr = new int[size];
    }

    // 入队，添加到队头
    public boolean addQueue(int i) {
        if (size == maxSize) {
            throw new IllegalArgumentException("队列已满");
        }
        for (int j = size; j > 0; j--) {
            queueArr[j] = queueArr[j - 1];
        }
        queueArr[0] = i;
        size++;
        return true;
    }


    /**
     * 出队，从队尾删除元素
     *
     * @return
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        int i = queueArr[--size];
        queueArr[size] = 0;
        return i;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(queueArr[i] + " ");
        }
        return sb.toString();
    }
}
