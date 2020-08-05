package hashTable;

public class EmpList {
    //头节点
    private Emp head;
    /**
     * 添加数据
     * @param emp
     */
    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }
        Emp temp = head;
        if (temp.next == null){
            temp.next = emp;
        }else {
            temp = temp.next;
        }
    }
    /**
     * 展示数据
     */
    public void List(int id){
        if (head == null){
            System.out.println("第"+(id+1)+"链表为空");
            return;
        }
        Emp temp = head;
        do {
            System.out.printf("第"+(id+1)+"条链表=> id=%d name=%s \t",temp.id,temp.name);
            temp = temp.next;
        }while (temp != null);
        System.out.println();
    }
}
