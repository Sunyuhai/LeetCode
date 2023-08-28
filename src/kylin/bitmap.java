package kylin;

import java.util.BitSet;

class bitmap {
    public static void main(String[] args) {
        // 创建一个包含 100 个位的 bitmap
        BitSet bitmap = new BitSet(100);

        // 将第 1 位、第 3 位和第 5 位设为 1
        bitmap.set(1);
        bitmap.set(3);
        bitmap.set(5);

        // 检查第 2 位是否为 1
        System.out.println(bitmap.get(2));  // 输出：false

        // 检查第 3 位是否为 1
        System.out.println(bitmap.get(3));  // 输出：true
    }
}

