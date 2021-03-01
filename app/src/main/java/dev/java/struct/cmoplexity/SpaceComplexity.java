package dev.java.struct.cmoplexity;

/**
 * asymptotic space complexity 算法的存储空间与数据规模之间的增长关系
 *
 * @author spider
 * @date 2021/2/28
 */
public class SpaceComplexity {
    public static void main(String[] args) {

    }

    static void print(int n) {
        int i = 0;
        int[] a = new int[n]; //O(n)
        for (; i < n; i++) {
            a[i] = i * i;
        }
        for (i = n - 1; i >= 0; --i) {
            System.out.println(a[i]);
        }

    }

    //最好时间复杂度、最坏时间复杂度、平均时间复杂度(均摊时间复杂度、加权时间复杂度)
    int find(int[] array, int n, int x) {
        int i = 0;
        int pos = -1;
        for (; i < n; ++i) {
            if (array[i] == x) pos = i; //O(n)
        }
        return pos;
    }

    /**
     * 查找数组中是否存在 x
     * 极端情况 O(1)
     * @param array
     * @param n
     * @param x
     * @return
     */
    int find1(int[] array, int n, int x) {
        int i = 0;
        int pos = -1;
        for (; i < n; ++i) {
            if (array[i] == x) {
                pos = i; //O(1) O(n) O(n)
                // 0 - n-1
                //1+2+3+……n+n/n+1 = n(n+3)/2(n+1)
                break;
            }
        }
        return pos;
    }

    //均摊时间复杂度

    /**
     * 往数组中插入数据，当数组满了，循环计算数组中的值求和赋值到index_0,数组不满就直接插入
     * 大部分情况 O(1) 极端情况 O(n)
     * 每一次O(n) 后跟着 n-1 次 O(1) 插入操作
     * 耗时多的均摊到 n-1 次傻姑娘，一组连续的操作均摊时间复杂度就是 O(1)
     * @param val
     */
    void insert(int val) {
        int n =10;
        int[] array = new int[n];
        int count = 0;
        if (count == array.length) {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            array[0] = sum;
            count = 1;
        }
        array[count]=val;
        ++count;
    }

}
