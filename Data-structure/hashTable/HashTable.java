package hashTable;

public class HashTable {
    private EmpList[] empLists;
    private int size;//链表的条数

    public HashTable(int size){
        this.size = size;
        empLists = new EmpList[size];
        for (int i=0; i<size; i++){
            empLists[i] = new EmpList();
        }
    }

    public void add(Emp emp){
        //决定添加进哪条链表
        int target = hashFun(emp.id);
        empLists[target].add(emp);
    }

    //遍历所有链表
    public void List(){
        for (int i=0; i<size; i++){
            empLists[i].List(i);
        }
    }

    //散列函数
    public int hashFun(int id){
        return id % size;
    }
}
