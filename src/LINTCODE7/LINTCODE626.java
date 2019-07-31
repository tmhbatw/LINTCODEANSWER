package LINTCODE7;

public class LINTCODE626 {
    /*Description
    * 给定两个矩形，判断这两个矩形是否有重叠。
    * */

      class Point {
      int x;
     int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }

    public boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        if(l1.x>r2.x||l2.x>r1.x)
            return false;
        if(l1.y<r2.y||r1.y>l2.y)
            return false;
        return true;
        // write your code here
    }
}
