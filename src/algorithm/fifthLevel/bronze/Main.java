package algorithm.fifthLevel.bronze;

public class Main {
    public static void main(String[] args) {
        OpenAddressingHashTable openAddressingHashTable = new OpenAddressingHashTable(10);
        openAddressingHashTable.put(1);
        openAddressingHashTable.put(2);
        openAddressingHashTable.put(12);
        openAddressingHashTable.contains(2);
    }
}
