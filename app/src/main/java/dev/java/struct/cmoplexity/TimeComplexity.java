package dev.java.struct.cmoplexity;

/**
 * @author spider
 * @date 2021/2/25
 */
public class TimeComplexity {
    public static void main(String[] args) {
        cal(10);
        calll(10);
    }

    static int cal(int n) {
        int sum = 0;
        int i = 1; // 1
        for (; i <= n; ++i) {
            sum = sum + 1; // n
        }
        return sum;
        // 2n + 2
    }

    static int call(int n) {
        int sum = 0;
        int i = 0;
        int j; // 1
        for (; i <= n; ++i) {
            j = 1; // n
            for (; j <= n; ++j) {
                sum = sum + i * j; // n^2
            }
        }
        return sum;
        //2n^2 + 2n + 3
    }
    //时间复杂度(渐进时间复杂度) 表示的是算法执行效率(时间)与数据规模增长的变化趋势
    //T(n) = O(f(n)) 执行时间 = 每行代码执行的次数总和，O 表示代码的执行时间 T 和 f(n) 成正比\
    //时间复杂度分析
    //1.只关注循环执行次数最多的一段代码
    //2.加法法则，总复杂度等于量级最大的那段代码的复杂度
    //3.乘法法则，嵌套的复杂度等于嵌套内外复杂度的乘积

    static int calll(int n) {
        int ret = 0;
        int i = 1;
        for (; i < n; ++i) {
            ret = ret + f(i);
        }
        return 1;
    }

    static int f(int n) {
        int sum = 0;
        int i = 1;
        for (; i < n; ++i) {
        }
        sum = sum + i;
        return sum;
    }
    //只要代码执行的时间随 n 增大而增大，这样的代码复杂度计作 O(1)，不存在循环语句、递归语句，即使有成千上完行的代码

    //O(logn)、O(nlogn)
    //log3^n = log3^2 * log 2^n -> o(log3^n) = O(C * log2^n),忽略常量系数 O(Cf(n)) = O(f(n)) -> o(log2^n) = O(log3^n)
    static int log(int n) {
        int i = 1;
        while (i <= n) {
            i = i * 2; // 2^0 2^1 2^2 2^3 ……n  2^x = n ,x = log 2^n
            // O(log2n) ~ O(logn)
        }
        return i;
    }

    //复杂度由两个数据规模决定
    int cal1(int m, int n) {
        int sum_1 = 0;
        int i = 1;
        for (; i < m; ++i) {
            sum_1 = sum_1 + i;
        }
        int sum_2 = 0;
        int j = 1;
        for (; i < n; ++j) {
            sum_2 = sum_2 + j;
        }
        return sum_1 + sum_2;
    }
    //O(m+n)

}
