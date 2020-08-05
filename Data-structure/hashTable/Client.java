package hashTable;

import java.util.Hashtable;

public class Client {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(5);
        hashTable.add(new Emp(1,"aaa"));
        hashTable.add(new Emp(2,"bbb"));
        hashTable.add(new Emp(3,"ccc"));
        hashTable.add(new Emp(4,"ddd"));
        hashTable.add(new Emp(5,"eee"));
        hashTable.add(new Emp(6,"fff"));
        hashTable.List();
    }
}
