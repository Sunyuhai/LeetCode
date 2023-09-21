package algorithm.fifthLevel.bronze;

import java.util.LinkedList;

public class ChainingHashTable {
    private LinkedList<Integer>[] table;
    private int capacity;

    public ChainingHashTable(int capacity) {
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void put(int key) {
        int index = hash(key);
        table[index].add(key);
    }

    public boolean contains(int key) {
        int index = hash(key);
        return table[index].contains(key);
    }

    private int hash(int key) {
        return key % capacity;
    }
}

