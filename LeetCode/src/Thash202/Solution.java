package Thash202;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：false
 * */


public class Solution {

    private int nextN(int n) {
        int sum = 0;                                // 一个局部变量sum赋初值为0
        while(n > 0){                               //如果n 大于 0 时结束循环
            int d = n%10;                           // 数位分离求平方和
            n = n/10;
            sum = sum + d * d ;
        }
        return sum ;                                //返回平方和
    }

    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();          //new一个hash集合 hs
        while(n != 1 && !hs.contains(n)){               //如果在hs内找到与当前n相同的数就跳出循环 或 当n是1时跳出循环
            hs.add(n);                                  //如果n不是1 且 hs集合内没有与当前n相同的数 就将n添加到hs集合内
            n = nextN(n);                               //调用nextN() 方法找到当前n 的下一个数 并赋值给n
        }
        return n == 1;                                  //如果n是1就返回true 否则返回false
    }


    public boolean isHappy2(int n) {
        int slow = n, fast = nextN(n);                  //慢指针指向n 快指针指向下一个n
        while (slow != fast){                           //如果快指针与慢指针相同就结束循环
            slow = nextN(slow);                         //返回慢指针指向的下一个数
            fast = nextN(nextN(fast));                  //返回快指针指向的下下一个数
        }
        return slow == 1;                               //如果慢指针指向的是1 则返回true 否则返回false
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution st = new Solution();
        int n = sc.nextInt();
        if(st.isHappy2(n)){
            System.out.println("是快乐数");
        }else{
            System.out.println("不快乐");
        }
    }

}
