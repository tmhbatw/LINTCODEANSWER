package LINTCODE17;

public class LINTCODE1626 {
    /*Description
    *给一个薪水的列表, 要求一个cap使得调整过后的薪水总和至少为target.
    * cap的定义是：当前薪水小于cap, 则用cap当作新的薪水，否则保持原本的薪水。
    * */

    public int getCap(int[] a, int target) {
        if(target==0)
            return 0;
        int[] time=new int[10001];
        int[] salary=new int[10001];
        for(int cur:a) {
            time[cur]++;
            salary[cur]+=cur;
        }
        for(int i=1;i<10001;i++) {
            time[i]+=time[i-1];
        }
        for(int i=9999;i>=0;i--){
            salary[i]+=salary[i+1];
        }
        int peopleNumber=a.length;
        if(target/peopleNumber>100000)
            return (target-1)/peopleNumber+1;
        int left=0,right=10000;
        while(left<=right){
            int mid=left+(right-left)/2;
            int curSalary=getSalary(mid,time,salary);
            if(curSalary==target)
                return mid;
            if(curSalary>target&&getSalary(mid-1,time,salary)<target)
                return mid;
            if(curSalary>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return left;
        // Write your code here.
    }

    private int getSalary(int mid,int[] time,int[] salary){
        return salary[mid]+time[mid-1]*mid;
    }
}
