package T1544;

/**
 * 给你一个由大小写英文字母组成的字符串 s 。
 *
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
 *
 * 若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
 * 若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 *
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 * */

public class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();         //new 一个 StringBulid 类的对象 sb  StringBulid与栈的操作相同 StringBulid 类里面有可以直接进行删除元素的方法
        int top = -1;                                  //top 来标记sb内当前正被匹配的字符
        int i = 0;                                      //i 是字符串 s 的下标
        while (i < s.length()){                         //遍历字符串 s
            if (top < 0){                               //如果 top < 0 说明sb内当前没有字符
                sb.append(s.charAt(i));                  //对 sb 进行插入字符的操作 chartAt() 函数是指 找到字符串 s 下标为i的字符 将其插入到sb内
                top++;                                   //因为 sb 内插入了字符 所以 top 需要自增
                i++;                                     //同理i自增
            }
            if(i < s.length()){
                if(Math.abs(sb.charAt(top) - s.charAt(i))!= 32){   //判断是否是不相同的大小写字符 charAt()函数意思同上
                    sb.append(s.charAt(i));                        //如果不相同 就将字符串 s 下标为 i 的字符 添加到 sb 内
                    top++;                                          //同理上面的top自增
                }else{
                    sb.deleteCharAt(top);                           //如果相同 就将sb内的下标为 top 的字符删掉
                    top--;                                          //top 自减 因为sb内删掉了字符
                }
            }
            i++;                                                    //运行下一个字符
        }
        return sb.toString();                                       //将sb转换成字符串并返回
    }

    public static void main(String[] args) {
        Solution st = new Solution();
        String s = "leEeetcode";
        System.out.println(st.makeGood(s));;

    }


}


