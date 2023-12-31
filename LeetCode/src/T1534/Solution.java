package T1534;
import static java.lang.Math.abs;

/**
 * 给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
 *
 * 如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
 *
 * 0 <= i < j < k < arr.length
 * |arr[i] - arr[j]| <= a
 * |arr[j] - arr[k]| <= b
 * |arr[i] - arr[k]| <= c
 * 其中 |x| 表示 x 的绝对值。
 *
 * 返回 好三元组的数量 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
 * 输出：4
 * 解释：一共有 4 个好三元组：[(3,0,1), (3,0,1), (3,1,1), (0,1,1)] 。
 * 示例 2：
 *
 * 输入：arr = [1,1,2,2,3], a = 0, b = 0, c = 1
 * 输出：0
 * 解释：不存在满足所有条件的三元组。
 *
 *
 * 提示：
 *
 * 3 <= arr.length <= 100
 * 0 <= arr[i] <= 1000
 * 0 <= a, b, c <= 1000
 * */


public class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {              //第一层遍历 遍历第一个数
            for (int j = i+1; j < arr.length; j++) {            //第二层遍历 遍历第二个数 j=i+1是为了避免重复遍历第一个数
                for (int k = j+1; k < arr.length; k++) {            ///第三层遍历 遍历第三个数 k=j+1是为了避免重复遍历第二个数
                    if ((abs(arr[i] - arr[j]) <= a) &&
                        (abs(arr[j] - arr[k]) <= b) &&          //判断条件
                        (abs(arr[i] - arr[k]) <= c)) {
                            sum++;          //如果满足条件就自增
                        System.out.println("[" + arr[i] + "," + arr[j] + "," + arr[k] + "]");  //测试打印数据
                    }
                }
            }
        }
        return sum;   //返回好三元组的数量
    }

    public static void main(String[] args) {
        Solution st = new Solution();           //new一个类的对象
        int [] arr = {3,0,1,1,9,7};
        int a = 7, b = 2, c = 3;
        int sum = st.countGoodTriplets(arr,a,b,c);          //通过对象名调用方法
                                                            // 是因为static类型的方法(静态方法)里面
                                                                //不能调用非静态的方法
        System.out.println(sum);
    }
}
