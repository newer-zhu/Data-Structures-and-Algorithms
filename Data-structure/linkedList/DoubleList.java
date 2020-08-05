package linkedList;

import org.w3c.dom.Node;

public class DoubleList {
    static class City_Node{
        public int number;//城市排名（编号）
        public String name;//城市名称（数据）
        public City_Node next;//指向下一个节点
        public City_Node pre; //指向上一个节点

        @Override
        public String toString() {
            return "Node{" +
                    "number=" + number +
                    ", name='" + name +
                    '}';
        }

        public City_Node(int number, String name) {
            this.number = number;
            this.name = name;
        }
    }

    static class DoubleLinkedList{
        private City_Node head = new City_Node(0,"head");

        /**
         * 遍历显示链表。返回值是链表有效节点个数
         * @return
         */
        public int showList(){
            int length = 0;
            if (head.next == null){
                System.out.println("链表为空");
                return 0;
            }
            City_Node temp = head;//临时节点
            while (temp.next != null){
                temp = temp.next;
                System.out.println(temp);
                length++;
            }
            return length;
        }

        /**
         * 添加元素
         */
        public void add(City_Node node){
            City_Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
            node.pre = temp;
        }

        /**
         * 更新节点，返回值为是否修改成功
         */
        public boolean update(City_Node node){
            //flag判断找没找到节点
            boolean flag = false;
            City_Node temp = head;
            //空链表
            if (temp.next == null){
                System.out.println("链表为空");
                return false;
            }
            while (temp.next != null){
                temp = temp.next;
                //找到了
                if (temp.number == node.number){
                    //值交换
                    temp.name = node.name;
                    flag = true;
                    break;
                }
            }
            return flag;
        }

        /**
         * 删除节点
         */
        public void delete(int num){
            City_Node temp = head.next;
            //空链表
            if (temp == null){
                System.out.println("空链表");
                return;
            }
            while (temp.next != null){
                if (temp.number == num){
                    temp.pre.next = temp.next;
                    temp.next.pre = temp.pre;
                    return;
                }
                temp = temp.next;
            }
            //如果要删除的链表在末尾
            if (temp.number == num){
                temp.pre.next = null;
            }else {
                System.out.println("节点不存在");
            }
        }
    }

    public static void main(String[] args) {
        City_Node c1 = new City_Node(1, "beijing");
        City_Node c2 = new City_Node(2, "shanghai");
        City_Node c3 = new City_Node(3, "gaungzhou");
        City_Node c4 = new City_Node(4, "shengzheng");
        City_Node c = new City_Node(3,"changsha");

        DoubleLinkedList list = new DoubleLinkedList();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.update(c);
        list.showList();
    }
}
