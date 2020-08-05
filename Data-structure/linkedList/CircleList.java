package linkedList;

public class CircleList {
    static class Boy{
        private int number;
        private Boy next;

        public Boy(int number) {
            this.number = number;
        }
    }

    static class CircleLinkedList{
        //first指针,一开始指向null
        private Boy first = null;

        /**
         * 创建有num个节点的环形链表
         * @param num
         */
        public void creat(int num){
            if (num < 1){
                System.out.println("编号不能小于1");
                return;
            }
            //辅助指针
            Boy curBoy = null;
            for (int i=1; i<=num; i++){
                Boy boy = new Boy(i);
                //如果加入了第一个boy，就让first指向boy
                if (i == 1){
                    //first一旦指向了第一个boy便固定了
                    first = boy;
                    first.next = first;
                    curBoy = first;
                } else {
                    curBoy.next = boy;
                    boy.next = first;
                    curBoy = boy;
                }
            }
        }

        /**
         * 遍历链表
         */
        public void show(){
            if (first == null){
                System.out.println("链表为空");
                return;
            }
            Boy curBoy = first;
            while (true){
                System.out.printf("boy %d\n",curBoy.number);
                //遍历到最后一个节点
                if (curBoy.next == first){
                    break;
                }
                curBoy = curBoy.next;
            }
        }

        /**
         * 出圈的顺序
         * @param start 第几个boy开始
         * @param count 数几下
         * @param number 链表中的boy个数
         */
        public void joseph(int start, int count, int number){
            //参数校验
            if (first == null || start < 1 || start > number){
                System.out.println("参数错误");
            }
            //让first指向start
            for (int j=0; j<start-1; j++){
                first = first.next;
            }
            //辅助指针指向first的上个节点
            Boy temp = first;
            while (temp.next != first){
                temp = temp.next;
            }
            while (first != temp) {
                for (int i = 0; i < count - 1; i++) {
                    first = first.next;
                    temp = temp.next;
                }
                //元素出圈
                System.out.printf("boy %d is out\n", first.number);
                first = first.next;
                temp.next = first;
            }
            System.out.printf("boy %d is alive\n",first.number);
            first = null;
        }

        public static void main(String[] args) {
            CircleLinkedList list = new CircleLinkedList();
            list.creat(6);
            list.joseph(1,5,6);

        }
    }










}
