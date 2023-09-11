package T2845;

import java.util.List;

/**
 * 给你一个下标从 0 开始的整数数组 nums ，以及整数 modulo 和整数 k 。
 *
 * 请你找出并统计数组中 趣味子数组 的数目。
 *
 * 如果 子数组 nums[l..r] 满足下述条件，则称其为 趣味子数组 ：
 *
 * 在范围 [l, r] 内，设 cnt 为满足 nums[i] % modulo == k 的索引 i 的数量。并且 cnt % modulo == k 。
 * 以整数形式表示并返回趣味子数组的数目。
 *
 * 注意：子数组是数组中的一个连续非空的元素序列。
 * */



/**
 * 对于本题，由于需要统计 cnt，我们可以把满足 nums[i] mod modulo=k 的 nums[i]视作 1，不满足则视作 0。
 *
 * 如此转换后，算出 nums 的前缀和数组 s，那么题目中的 cnt mod modulo = k 等价于
 *
 * (s[r+1]−s[l]) mod  modulo=k
 * (s[r+1]−s[l])mod modulo=k
 * 上式等价于（推导过程请看视频）
 *
 * s[l] mod modulo = (s[r+1] -k) mod modulo

 * 根据上式，我们可以一边枚举 r，一边用一个哈希表统计有多少个 s[r+1] mod modulo。这样可以快速知道有多少个 (s[r+1]-k) mod modulo，也就是 s[l] mod modulos[l] 的个数，把个数加到答案中。
 *
 * 代码实现时，前缀和数组可以优化成一个变量 s。
 *
 * 作者：灵茶山艾府
 * 链接：https://leetcode.cn/problems/count-of-interesting-subarrays/solutions/2424063/qian-zhui-he-ha-xi-biao-fu-ti-dan-by-end-74bb/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * */




//本题目只理解了一半剩下一半和hash列表有关
public class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int mod, int k) {
        int n = nums.size();
        int[] cnt = new int[n + 1];
        cnt[0] = 1;
        long ans = 0;
        int s = 0;
        for (int x : nums) {
            if (x % mod == k)
                s = (s + 1) % mod;
            int s2 = (s - k + mod) % mod;
            if (s2 <= n)
                ans += cnt[s2];
            cnt[s]++;
        }
        return ans;
    }
}

