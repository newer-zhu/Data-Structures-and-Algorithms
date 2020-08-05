package queue;

public class ArrayQueue {
            private int maxSize;//队列容量
            private int front;//头指针
            private int rear;//尾指针
            private int[] arr;//存储队列容器

            public ArrayQueue(int arrMaxSize){
                maxSize = arrMaxSize;
                arr = new int[maxSize];
                front = -1;//指向队列头的前一个位置
                rear = -1;//指向队列尾的元素
            }

            //判断队列是否满
            public boolean isFull(){
                return rear == maxSize-1;
            }

            //判断队列是否空
            public boolean isEmpty(){
                return rear == front;
            }

            //添加数据到队列
            public void addQueue(int data){
                if (isFull()){
                    System.out.println("队列满了，不能添加");
                }
                rear++;
        arr[rear] = data;
    }

    //数据出队列,返回出队列的值
    public int outQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    //遍历显示队列
    public void showQueue(){
        if (isEmpty())
            return;
        for (int i=front+1; i<=rear; i++){
            System.out.print(arr[i]+"\t");
        }
    }

    //显示队列头数据
    public int QueueHead(){
        if (isEmpty())
            throw new RuntimeException("队列为空");
        return arr[front+1];
    }
}
