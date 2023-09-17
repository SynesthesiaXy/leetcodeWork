package dp_lcp63;

import java.util.ArrayList;


/**
 *欢迎各位来到「力扣嘉年华」，接下来将为各位介绍在活动中广受好评的弹珠游戏。
 *
 * N*M 大小的弹珠盘的初始状态信息记录于一维字符串型数组 plate 中，数组中的每个元素为仅由 "O"、"W"、"E"、"." 组成的字符串。其中：
 *
 * "O" 表示弹珠洞（弹珠到达后会落入洞中，并停止前进）；
 * "W" 表示逆时针转向器（弹珠经过时方向将逆时针旋转 90 度）；
 * "E" 表示顺时针转向器（弹珠经过时方向将顺时针旋转 90 度）；
 * "." 表示空白区域（弹珠可通行）。
 * 游戏规则要求仅能在边缘位置的 空白区域 处（弹珠盘的四角除外）沿 与边缘垂直 的方向打入弹珠，并且打入后的每颗弹珠最多能 前进 num 步。请返回符合上述要求且可以使弹珠最终入洞的所有打入位置。你可以 按任意顺序 返回答案。
 *
 * 注意：
 *
 * 若弹珠已到达弹珠盘边缘并且仍沿着出界方向继续前进，则将直接出界。
 * 示例 1：
 *
 * 输入： num = 4 plate = ["..E.",".EOW","..W."]
 *
 * 输出：[[2,1]]
 **/
public class Solution {
    String[] plate;
    int m;
    int n;
    static final int UP = 0;
    static final int DOWN = 1;
    static final int RIGHT = 2;
    static final int LEFT = 3;

    /**num = 4 plate = ["..E.",".EOW","..W."]**/
    public int[][] ballGame(int num, String[] plate) {
        this.plate = plate;
        //m 是行的长度    n 是列的长度
         m = plate.length;
         n = plate[0].length();
        ArrayList<int[]> arrayList = new ArrayList<>();
        //遍历入口和方向
        /**
         * 边缘位置
         * 空白区域处
         * （弹珠盘的四角除外）
         * */
        //遍历顶层入口 j 是列
        for(int j = 1; j < n-1; j++){
            if(plate[0].charAt(j) == '.' && dfs(0,j,num,DOWN)){
                arrayList.add(new int[]{0,j});
            }
        }

        //遍历底层入口  j 是列
        for(int j = 1; j < n-1; j++){
            if(plate[m-1].charAt(j) == '.' && dfs(m-1,j,num,UP)){
                arrayList.add(new int[]{m-1,j});
            }
        }

        //遍历左侧入口 i 是行
        for(int i = 1; i < m-1; i++){
            if(plate[i].charAt(0) == '.' && dfs(i,0,num,RIGHT)){
                arrayList.add(new int[]{i,0});
            }
        }

        //遍历右侧入口 i 是行
        for(int i = 1; i < m-1; i++){
            if(plate[i].charAt(n-1) == '.' && dfs(i,n-1,num,LEFT)){
                arrayList.add(new int[]{i,n-1});
            }
        }

        int [][] res = new int [arrayList.size()][2];
        for(int i = 0; i < arrayList.size(); i++){
            res[i][0] = arrayList.get(i)[0];
            res[i][1] = arrayList.get(i)[1];
        }
        return res;
    }

    //x 是行 y 是列
    private boolean dfs(int x,int y,int num,int direction){
        if(x < 0 || num < 0 || x >= m || y >= n || y < 0){
            return false;
        }
        if(plate[x].charAt(y) == 'O'){
            return true;
        }

        if(plate[x].charAt(y) == '.'){
            if(direction == UP){
                return dfs(x-1,y,num-1,UP);
            }else if(direction == DOWN){
                return dfs(x+1,y,num-1,DOWN);
            }else if(direction == RIGHT){
                return dfs(x,y+1,num-1,RIGHT);
            }else if(direction == LEFT){
                return dfs(x,y-1,num-1,LEFT);
            }
        }else if(plate[x].charAt(y) == 'E'){
            if(direction == UP){
                return dfs(x,y+1,num-1,RIGHT);
            }else if(direction == DOWN){
                return dfs(x,y-1,num-1,LEFT);
            }else if(direction == RIGHT){
                return dfs(x+1,y,num-1,DOWN);
            }else if(direction == LEFT){
                return dfs(x-1,y,num-1,UP);
            }
        }else if(plate[x].charAt(y) == 'W'){
            if(direction == UP){
                return dfs(x,y-1,num-1,LEFT);
            }else if(direction == DOWN){
                return dfs(x,y+1,num-1,RIGHT);
            }else if(direction == RIGHT){
                return dfs(x-1,y,num-1,UP);
            }else if(direction == LEFT){
                return dfs(x+1,y,num-1,DOWN);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 5;
        String[] plate = {".....","..E..",".WO..","....."};

        Solution st = new Solution();
        st.ballGame(num,plate);
        int[][] arr = new int[st.ballGame(num,plate).length][2];
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i][0] + "," + arr[i][1]);
        }
    }
}
