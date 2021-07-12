package LINTCODE16;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE1514 {
    /*Description
    * 给定一个清洁机器人，其处于一个模型化为网格地图的房间内。
    * 网格中的每个格子可能是空空的或者阻塞的。这个拥有4个给定的API的清洁机器人可以向前，向左，向右移动。每次转向是90度的。
    * 当它尽力去移动进入一个阻塞的格子中，它的保险传感器探测到障碍并且它会待在合适的格子中。
    * 设计一个算法去清理整个房间利用仅有的4个如下给定的API。
    * */


      // This is the robot's control interface.
      // You should not implement it, or speculate about its implementation
      class Robot {
          // Returns true if the cell in front is open and robot moves into the cell.
          // Returns false if the cell in front is blocked and robot stays in the current cell.
          boolean move(){
            return true;
          };

          // Robot will stay in the same cell after calling turnLeft/turnRight.
          // Each turn will be 90 degrees.
          void turnLeft(){

          };
          void turnRight(){

          };

          // Clean the current cell.
          void clean(){

          };
      };

    int[][] pos=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    Set<String> reached=new HashSet<>();
    int index=0;

    public void cleanRoom(Robot robot) {
        dfs(0,0,robot);
        // write tour code here
    }

    private void dfs(int x, int y, Robot robot){
        String p=x+" "+y;
        if(reached.contains(p))
            return;
        reached.add(p);
        robot.clean();

        for(int i=0;i<4;i++){
            if(robot.move()){
                dfs(x+pos[index][0],y+pos[index][1],robot);
                back(robot);
            }
            index++;
            if(index==4)
                index=0;
            robot.turnRight();
        }
    }

    private void back(Robot robot){
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }
}
