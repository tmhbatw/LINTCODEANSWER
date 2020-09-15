package LINTCODE3;

import java.util.List;

public class LINTCODE267 {
    /*Description
    * 由于业绩优秀，公司给小Q放了 n 天的假，身为工作狂的小Q打算在假期中工作、锻炼或者休息。
    * 他有个奇怪的习惯：不会连续两天工作或锻炼。只有当公司营业时，小Q才能去工作，只有当健身房营业时，小Q才能去健身，小Q一天只能干一件事。
    * 给出假期中公司，健身房的营业情况，求小Q最少需要休息几天
    * */

    public int minimumRestDays(List<Integer> company, List<Integer> gym) {
        if(company==null||company.isEmpty())
            return 0;
        int days=company.size();
        int[] dpCompany=new int[days+1];
        int[] dpGym=new int[days+1];
        for(int i=0;i<days;i++){
            if(company.get(i)==0)
                dpCompany[i+1]=Math.min(dpCompany[i],dpGym[i])+1;
            else
                dpCompany[i+1]=dpGym[i];
            if(gym.get(i)==0)
                dpGym[i+1]=Math.min(dpCompany[i],dpGym[i])+1;
            else
                dpGym[i+1]=dpCompany[i];
        }
        return Math.min(dpCompany[days],dpGym[days]);
        // write your code here
    }
}
