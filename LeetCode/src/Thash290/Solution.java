package Thash290;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 290. 单词规律
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 *
 *
 *
 * 示例1:
 *
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= pattern.length <= 300
 * pattern 只包含小写英文字母
 * 1 <= s.length <= 3000
 * s 只包含小写英文字母和 ' '
 * s 不包含 任何前导或尾随对空格
 * s 中每个单词都被 单个空格 分隔
 * */




public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String [] strings = s.split(" ");       //通过split()方法来分割字符串 s 变成 String[] 数组
        Map<Object,Integer> hashmap = new HashMap<>();      //new 一个HashMap的对象
        for(Integer i = 0; i < strings.length; i++){            //遍历 strings 数组 Integer 是防止输入的数据超出范围
            if(pattern.length() != strings.length){         //判断两个字符串长度是否相等
                return false;           //如果否则返回false
            }

             /**
                如果key不存在，插入成功，返回null；如果key存在，返回之前对应的value。

                以pattern = "abba", str = "dog cat cat dog"为例，
                第1次：map.put('a',0)返回null，map.put("dog",0)返回null，两者相等；
                第2次：map.put('b',1)返回null，map.put("cat",1)返回null，两者相等；
                第3次：map.put('b',2)返回1，map.put("cat",2)返回1，两者相等；
                第4次：map.put('a',3)返回0，map.put("dog",3)返回0，两者相等，
                结果为 true。

                以pattern = "abba", str = "dog cat cat fish"为例，
                第1次：map.put('a',0)返回null，map.put("dog",0)返回null，两者相等；
                第2次：map.put('b',1)返回null，map.put("cat",1)返回null，两者相等；
                第3次：map.put('b',2)返回1，map.put("cat",2)返回1，两者相等；
                第4次：map.put('a',3)返回0，map.put("fish",3)返回null，两者不相等，
                结果为 false。
            **/


            if(hashmap.put(strings[i],i) != hashmap.put(pattern.charAt(i),i)){
                /**
                 *
                 * put()方法 如果插入的 key 对应的 value 已经存在，则执行 value 替换操作，返回旧的 value 值，如果不存在则执行插入，返回 null。
                 * charAt()方法 返回字符串 pattern 内 i 处的字符
                 * 判断这两个的返回值是否相同
                 * 如果不相同则返回false
                 * 相同则进行下一次循环
                 **/

                                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution st = new Solution();
        String  pattern = "abba";
        String s = "dog cat cat dog";
        if(st.wordPattern(pattern,s)){
            System.out.println("1");
        }else{
            System.out.println("0");
        }

    }
}
