package linkedList;


public class LinkedList {
    /**
     * 定义节点
     */
    static class CityNode{
        public int number;//城市排名（编号）
        public String name;//城市名称（数据）
        public CityNode next;//指向下一个节点
        //构造器
        public CityNode(int num, String name){
            this.number = num;
            this.name = name;
        }

        //重写toString方法便于观察
        @Override
        public String toString() {
            return "CityNode{" +
                    "number=" + number +
                    "-- name=" + name + '}';
        }

    }
    static class CityList{
        //头结点不放数据
        private CityNode head = new CityNode(0,"head");

        //添加节点
        public void add(CityNode node){
            CityNode temp = head;//每次都temp指向头结点
            while (temp.next != null){
                temp = temp.next;//让temp一直遍历到最后一个节点
            }
            //将最后一个节点的next指向要添加的节点
            temp.next = node;
        }

        /**
         * 按顺序插入节点
         */
        public void addByOrder(CityNode node){
            //定义一个临时节点
            CityNode temp = head;
            //当下一个节点不为空时进入循环
            while (temp.next != null){
                //编号如果一样则直接返回
                if (temp.number == node.number){
                    System.out.printf("节点%d已存在\n",node.number);
                    return;
                }
                if (temp.next.number > node.number){
                    //此时temp为要插入位置的前一个节点
                    node.next = temp.next;
                    temp.next = node;
                    return;//操作完成直接返回
                }
                temp = temp.next;//向后移一个节点
            }
            //如果while执行完则说明插入的节点编号位于链表末尾或者编号和链表最后一个节点编号相同
            if ( temp.number == node.number){
                System.out.printf("节点%d已存在\n",node.number);
            }else {
                temp.next = node;
            }
        }

        /**
         * 删除节点
         * @param num
         * @return是否删除成功
         */
        public boolean delete(int num){
            //flag表示删除是否成功
            boolean flag = false;
            CityNode temp = head;
            if (temp.next == null){
                System.out.println("链表为空 ！");
                return false;
            }
            while (temp.next != null){
                //找到了要删除节点的上一个节点
                if (temp.next.number == num ){
                    //如果要删除的节点是最后一个，直接让temp.next指向null
                    if (temp.next.next == null){
                        temp.next = null;
                        System.out.printf("节点%d已经删除\n",num);
                        flag = true;
                        break;
                    }else {
                        temp.next = temp.next.next;
                        System.out.printf("节点%d已经删除\n",num);
                        flag = true;
                        break;
                    }
                }
                temp = temp.next;//向后移一位
            }//如果遍历结束flag还是false
            if (!flag)
                System.out.println("要删除的节点不存在");
            return flag;
        }

        /**
         * 更新节点，返回值为是否修改成功
         */
        public boolean update(CityNode node){
            //flag判断找没找到节点
            boolean flag = false;
            CityNode temp = head;
            //空链表
            if (head.next == null){
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
         * 遍历显示链表。返回值是链表有效节点个数
         * @return
         */
        public int showList(){
            int length = 0;
            if (head.next == null){
                System.out.println("链表为空");
                return 0;
            }
            CityNode temp = head;//临时节点
            while (temp.next != null){
                temp = temp.next;
                System.out.println(temp);
                length++;
            }
            return length;
        }

        /**
         * 反转链表
         * @param list
         * @return 反转后的链表
         */
        public CityList reverseList(CityList list){
            //创建一个新的链表头结点
            CityNode reverseNode = new CityNode(0,"");
            //cur指向第一个有效链表元素
            CityNode cur = list.head.next;
//            如果链表为空或者只有一个有效元素则直接返回
            if (cur == null || cur.next.next == null)
                return list;
            CityNode next;//next指向的是cur的下一个元素
            while (cur != null){
                next = cur.next;
                cur.next = reverseNode.next ;
                reverseNode.next = cur;
                //cur后移一位
                cur = next;
            }
//            list的下一位指向反转后的链表头的下一个元素
            list.head.next = reverseNode.next;
            return list;
        }

        /**
         * 合并两个有序链表
         * @param list
         * @param list1
         * @return 合并后新的链表
         */
        public CityList combine(CityList list,CityList list1){
            CityList list2 = new CityList();
            CityNode temp2 = list2.head;
            CityNode temp = list.head.next;
            CityNode temp1 = list1.head.next;
            while (temp !=null && temp1!= null){
                if (temp.number < temp1.number){
                    temp2.next = temp;
                    temp2 = temp2.next;
                    temp = temp.next;
                }else {
                    temp2.next = temp1;
                    temp2 = temp2.next;
                    temp1 = temp1.next;
                }
            }
            if (temp == null){
                temp2.next = temp1;
            }else {
                temp2.next = temp;
            }
            return list2;
        }

    }



    public static void main(String[] args) {

        CityNode city1 = new CityNode(1, "北京");
        CityNode city3 = new CityNode(3, "北京");
        CityNode city4 = new CityNode(4, "北京");

        CityNode Lcity1 = new CityNode(1, "天津");
        CityNode Lcity2 = new CityNode(2, "天津");
        CityNode Lcity4 = new CityNode(4, "天津");

        CityList list = new CityList();
        list.add(Lcity1);
        list.add(Lcity2);
        list.add(Lcity4);

        CityList list1 = new CityList();
        list1.add(city1);
        list1.add(city3);
        list1.add(city4);

        CityList list2 = list.combine(list, list1);

        list2.showList();

//        System.out.println("---------------------------------");
//        list.reverseList(list).showList();




    }
}
