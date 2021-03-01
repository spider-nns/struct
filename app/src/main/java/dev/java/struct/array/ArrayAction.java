package dev.java.struct.array;

import java.util.Arrays;

/**
 * @author spider
 * @date 2021/2/28
 */
public class ArrayAction {
    public static void main(String[] args) {
        arr();
    }

    //数组是一种线性表数据结构(linear list)，用一组连续的内存空间，存储一组具有相同类型的数据
    //线性表 就是数据排成像一条线一样的结构,每个线性表上的数据最多只有前和后两个方向，数组、链表、队列、栈也是线性表结构
    //任意访问
    //低效的插入和删除 O(n)
    //避免大规模数据搬移
    //insert 插入到某个位置，直接将该点被的元素移动的末尾，将新的元素放入
    //delete 记录删除记录，批量删除，删除操作不搬移数据，只做记录，空间不足触发真正的删除 ，JVM 标记清除垃圾回收算法


    //警惕数组的访问越界
    //架构大小端模式不同
    //ArrayList 替代数组
    //ArrayList 无法存储基本类型，Autoboxing,Unboxing 有一定的性能消耗，关注性能、确定大小、不需要arrayList的方法就可以选择数组

    //为什么数组要从0开始编号 0 偏移量就是数组首地址
    //从 1 开始 a[i] = base_addr + (i-1) * data_type_size  CPU 多做一次减法指令，从C语言开始，其他语言效仿
    //连续存储 a[i] = base_addr + i * data_type_size，准确的说数组支持随机访问，根据下标随机访问的时间复杂度是O(1)


    //堆栈保护技术 https://www.ibm.com/developerworks/cn/linux/l-cn-gccstack/index.html


    static void arr() {
        String[] strings = {"a", "b", "c"};
        String[] cop = Arrays.copyOf(strings, 3);
        System.out.println("strings" + Arrays.toString(strings));
        System.out.println("cop" + Arrays.toString(cop));
        String[][] arr = new String[2][2];
        arr[0][0] = "a";
        arr[0][1] = "b";
        arr[1][0] = "c";
        arr[1][1] = "d";
        System.out.println(Arrays.deepToString(arr));
        System.out.println("array equals addr: " + strings.equals(arr));
        System.out.println("array equals addr: " + strings.equals(cop));

        int[] ints = new int[3];
        Arrays.fill(ints, 5);
        System.out.println("arrays fill:" + Arrays.toString(ints));

        int[] ints1 = {5, 0, 2, 3};
        Arrays.sort(ints1, 0, 2);
        System.out.println("arrays sort:" + Arrays.toString(ints1));
        System.out.println("----二维数组----");
        //二维数组
        int[][] ar = new int[2][]; // 第二维长度动态申请
        for (int i = 0; i < ar.length; i++) {
            int[] ar2 = new int[i + 1];
            Arrays.fill(ar2, i+1);
            ar[i] = ar2;
        }
        System.out.println("二维动态数组" + Arrays.deepToString(ar));
    }
}
