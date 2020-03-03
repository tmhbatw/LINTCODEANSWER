package LINTCODE16;

public class LINTCODE1518 {
    /*Description
    * 你和你的朋友都是园丁，你们要照顾好你们的植物。这些植物是连续种植的，而且每种植物都需要一定量的水。你们要用水罐给它们浇水。为了避免错误，比如浇水太多，或者根本不给植物浇水，你们决定：
    * 按植物出现的顺序浇水：你要从左到右浇水，你的朋友要从右到左浇水；
    * 如果你有足够的水来浇灌每一棵植物，否则请重新装满你的水壶；
    * 一次浇灌每株植物，即在给一株植物浇灌的过程中，不需要休息一下就可以重新灌满浇灌罐。这意味需要在浇灌植物之前或之后重新灌满浇水罐，即使浇水罐不是完全空的。
    * 你从浇灌第一株植物开始，你的朋友从浇灌最后一株植物开始，你和你的朋友同时浇灌植物（当你浇灌第一株植物时，你的朋友浇灌最后一株；当你浇灌第二株植物时，你的朋友浇灌倒数第二株植物；
    * 等等）这意味着你们将在一排植物中间相遇。如果那里有一棵没有浇水的植物，而且你和你的朋友一起有足够的水来浇水，你可以不用再装满你的水罐来浇水；否则，你们中只有一个人需要再重灌
    * 一开始你们的浇水罐都是空的，你和你的朋友需要给你的浇水罐重灌多少次水才能浇灌整排的植物？
    * 给定一个包含n个整数（表示每株植物所需的水量）的数组和变量capacity1和capacity2（表示你和你朋友的浇水罐的容量），则返回你和你朋友需要重新装满浇水罐来浇灌所有植物的次数。
    * */

    public int waterPlants(int[] plants, int capacity1, int capacity2) {
        int can1=capacity1;
        int can2=capacity2;
        int left=0;
        int right=plants.length-1;
        int result=0;
        while(left<right){
            if(plants[left]>can1) {
                can1 = capacity1;
                result++;
            }
            if(plants[right]>can2){
                can2=capacity2;
                result++;
            }
            can1-=plants[left];
            can2-=plants[right];
            left++;
            right--;
        }
        if(left==right){
            return can1+can2>=plants[left]?result:result+1;
        }
        return result;

    }
}
