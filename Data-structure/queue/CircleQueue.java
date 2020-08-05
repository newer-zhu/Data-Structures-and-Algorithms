package queue;

public class CircleQueue {
    private int maxSize;//队列容量
    private int front;//头指针
    private int rear;//尾指针
    private int[] arr;//存储队列容器

    //初始化队列
    public CircleQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        rear = 0;
        front = 0;
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据
    public void addQueue(int data){
        if (isFull()){
            System.out.println("队列满了");
            return;
        }
        arr[rear] = data;
        //取模是为了rear在队列最后一位时能指回队列前面空的位置
        rear = (rear + 1) % maxSize;
    }

    //数据出列
    public int outQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        //设置临时变量保存返回的出队列的值
        int temp = arr[front];
        //取模是为了front在队列最后一位时能指回队列前面空的位置
        front = (front + 1) % maxSize;
        return temp;
    }

    //查询队列的有效元素个数
    public int size(){
        //计算元素个数的公式
        return (rear - front + maxSize) % maxSize;
    }

    //遍历显示
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }
        //循环执行size()次
        for (int i = front; i < front+size(); i++){
            //i可能会超过maxSize，取模使其不越界
            System.out.print(arr[i % maxSize]+"\t");
        }
    }
}
