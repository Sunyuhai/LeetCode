package algorithm.fifthLevel.bronze;

public class OpenAddressingHashTable {
    private int[] table;
    private int capacity;
    private int size;

    public OpenAddressingHashTable(int capacity) {
        this.capacity = capacity;
        this.table = new int[capacity];
        this.size = 0;
    }

    public void put(int key) {
        if (size == capacity) {
            // 哈希表已满
            throw new IllegalStateException("HashTable is full");
        }

        int index = hash(key);

        while (table[index] != 0) {
            // 冲突，尝试下一个位置
            index = (index + 1) % capacity;
        }

        // 找到空槽，将键存储在这里
        table[index] = key;
        size++;
    }

    public boolean contains(int key) {
        int index = hash(key);

        while (table[index] != 0) {
            if (table[index] == key) {
                return true;
            }
            // 冲突，尝试下一个位置
            index = (index + 1) % capacity;
        }

        return false;
    }

    private int hash(int key) {
        return key % capacity;
    }
}

