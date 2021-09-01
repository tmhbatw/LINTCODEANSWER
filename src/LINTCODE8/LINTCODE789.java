package LINTCODE8;

import java.util.*;

public class LINTCODE789 {
    /*Description
    * 在迷宫中有一个球，里面有空的空间和墙壁。球可以通过滚up (u)、down (d)、
    * left (l)或右right (r)来穿过空的空间，但它不会停止滚动直到撞到墙上。当球停止时，它可以选择下一个方向。
    * 在这个迷宫里还有一个洞。如果球滚到洞里，球就会掉进洞里。给定球的位置、洞的位置和迷宫，
    * 找出球如何通过移动最短距离落入洞内。距离是由球从起始位置(被排除)到洞(包括)所走过的空空间的数量来定义的。
    * 用“u”、“d”、“l”和“r”来输出移动的方向。由于可能有几种不同的最短路径，所以你应该输出字母顺序中
    * （移动顺序中）最短的方法。如果球打不进洞，输出“impossible”。迷宫由二维数组表示。
    * 1表示墙和0表示空的空间。你可以假设迷宫的边界都是墙。球和孔坐标用行和列的坐标表示。
    * */

    String impossible="impossible";
    int m;
    int n;

    class Node{
        String path;
        int val;
        int x;
        int y;
        public Node(String path, int time,int x,int y){
            this.path=path;
            this.val=time;
            this.x=x;
            this.y=y;
        }

        public String toString(){
            return this.path+" "+this.val+" "+this.x+" "+this.y;
        }
    }

    int[][] nextPos=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    String[] nextPath=new String[]{"r","l","d","u"};

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        this.m=maze.length;
        this.n=maze[0].length;
        if(maze[ball[0]][ball[1]]==1||maze[hole[0]][hole[1]]==1)
            return impossible;
        Queue<Node> q=new PriorityQueue<Node>((o1, o2) -> {
            if(o1.val==o2.val)
                return o1.path.compareTo(o2.path);
            return o1.val-o2.val;
        });
        q.add(new Node("",0,ball[0],ball[1]));

        int[][] exist=new int[m][n];
        for(int[] cur:exist){
            Arrays.fill(cur,Integer.MAX_VALUE);
        }
        exist[ball[0]][ball[1]]=0;

        maze[hole[0]][hole[1]]=-1;
        while(!q.isEmpty()){
            Node cur=q.poll();
            if(cur.x==hole[0]&&cur.y==hole[1])
                return cur.path;
            for(Node next:getNextNode(cur,maze)){
                if(exist[next.x][next.y]>=next.val){
                    exist[next.x][next.y]=next.val;
                    q.add(next);
                }
            }
        }
        return impossible;
        // write your code here
    }

    private List<Node> getNextNode(Node node, int[][] maze){
        List<Node> result=new ArrayList<>();
        for(int i=0;i<4;i++){
            int[] next=nextPos[i];
            int ii=node.x,jj=node.y;
            int time=0;
            while(ii+next[0]<m&&ii+next[0]>=0&&jj+next[1]<n&&jj+next[1]>=0&&maze[ii+next[0]][jj+next[1]]<=0){
                time++;
                ii+=next[0];
                jj+=next[1];
                if(maze[ii][jj]==-1)
                    break;
            }
            if(time==0)
                continue;
            Node nextNode=new Node(node.path+nextPath[i],node.val+time,ii,jj);
            result.add(nextNode);
        }
        return result;
    }
}
