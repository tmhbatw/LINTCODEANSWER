package LINTCODE8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE717 {
    /*Description
    *
    * */

    int[] a;
    Map<Integer, List<Integer>> map=new HashMap<>();
    int result=0;

    public int LongestPathWithSameValue(int[] A, int[] E) {
        this.a=A;
        int n=A.length;

        for(int i=0;i<E.length;i+=2){
            int min=E[i]-1;
            int max=E[i+1]-1;
            map.putIfAbsent(min,new ArrayList<>());
            map.putIfAbsent(max,new ArrayList<>());
            map.get(min).add(max);
            map.get(max).add(min);
        }
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        //以这个数为开头的最大的值
        for(int i=0;i<n;i++) {
            dfs(i,i);
        }
        return result-1;
        // write your code here
    }

    private int dfs(int cur, int father){
        List<Integer> nextArray=map.getOrDefault(cur,new ArrayList<>());
        int first=0;
        int second=0;
        for(int next:nextArray){
            if(next==father)
                continue;
            if(a[cur]==a[next]) {
                int nextLength = dfs(next, cur);
                if (nextLength >= first) {
                    second = first;
                    first = nextLength;
                } else if (nextLength > second) {
                    second = nextLength;
                }
            }
        }
        result=Math.max(first+second+1,result);
        return first+1;
    }

    public static void main(String[] args){
        int[] A=new int[]{255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,254,255,255,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,254,255,255,255,255,255,254,255,255,255,255,255,254,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,254,255,255,255,255,255,255,254,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,254,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,254,255,255,255,255,255,255,255,255,254,254,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,254,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,253,255,254,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,252,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,254,255,255,255,255,255,255,255,255,254,255,255,254,255,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,254,255,255,255,254,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,254,255,255,255,255,255,255,255,255,255,255};
        int[] E=new int[]{329,756,883,624,225,548,863,465,121,615,119,224,340,317,952,672,5,295,209,755,462,170,17,193,43,975,821,862,766,581,311,736,487,837,776,844,510,177,69,618,663,236,720,813,920,223,553,182,1000,911,931,507,213,2,158,105,816,757,740,866,79,898,486,318,13,893,626,684,116,977,942,829,324,541,328,227,828,507,144,43,243,565,357,779,669,461,693,602,316,838,895,994,269,771,455,620,423,456,561,705,959,519,825,569,320,422,826,355,45,911,143,795,655,68,945,141,784,538,425,654,520,650,418,98,433,962,447,231,994,669,981,684,119,615,673,419,254,593,14,221,610,498,337,742,197,855,616,909,297,427,400,979,598,11,426,208,954,393,61,89,363,971,149,801,966,190,557,242,205,530,35,888,130,99,20,502,758,176,137,947,544,361,681,814,403,691,286,530,72,366,44,433,772,980,207,894,212,796,290,579,534,697,885,692,214,361,129,293,103,659,271,58,824,280,864,914,875,403,205,61,508,84,50,960,572,490,267,472,135,80,108,41,755,978,145,295,947,282,450,424,125,360,890,377,305,35,3,551,645,19,735,665,156,940,362,816,502,802,215,764,206,491,763,522,451,75,490,260,177,193,807,611,501,302,238,638,896,104,224,916,632,143,874,325,195,750,342,198,957,432,585,293,545,182,235,624,542,123,211,535,609,952,181,158,161,184,994,239,279,232,326,112,15,279,216,539,643,996,51,494,482,611,452,287,36,797,657,349,407,590,452,261,482,648,770,668,145,982,484,792,127,366,195,276,962,498,905,351,115,724,404,741,110,573,418,685,911,952,569,251,945,563,255,321,386,180,614,440,407,172,642,764,139,292,871,587,304,582,538,100,266,762,99,455,48,546,270,961,644,402,806,189,413,181,228,699,926,196,323,826,115,694,117,629,165,677,647,164,810,237,873,315,354,928,539,34,180,964,950,396,849,904,300,500,215,488,240,39,435,290,93,480,701,887,435,908,77,511,850,441,92,515,541,821,580,263,930,148,489,28,510,566,926,275,117,712,929,514,352,948,73,668,601,286,526,540,653,938,374,7,860,106,522,700,144,415,720,868,735,594,171,52,892,536,444,933,159,596,128,78,744,381,125,38,335,254,76,822,908,920,524,143,264,565,68,722,28,327,960,317,52,346,231,556,319,730,781,73,534,937,163,16,113,448,767,988,781,622,963,568,685,392,146,518,112,607,476,219,522,636,345,839,823,841,907,281,370,809,114,214,111,834,729,780,778,731,921,144,329,463,201,586,382,658,164,824,620,422,760,733,623,288,336,584,878,873,102,933,988,503,958,879,21,660,86,981,788,904,858,622,941,384,185,973,36,899,150,363,289,932,867,482,835,344,234,936,597,621,573,663,859,808,738,652,505,876,936,118,717,108,925,739,514,94,592,404,734,732,644,935,355,979,272,894,701,291,74,380,633,805,460,517,868,27,458,3,503,88,773,614,636,227,815,557,441,53,916,861,438,311,282,253,205,183,186,799,347,499,104,436,459,252,83,906,406,439,162,728,716,484,95,638,242,635,839,784,694,711,670,868,831,840,356,153,990,851,405,952,175,707,25,369,64,666,6,777,250,55,969,84,159,591,97,299,167,199,865,787,665,661,899,827,656,719,642,471,613,436,565,313,388,485,703,773,903,930,54,882,497,723,583,918,313,73,906,833,451,382,12,326,67,492,727,705,492,446,220,725,162,758,437,603,10,687,945,368,641,993,285,828,107,427,728,360,743,175,743,619,229,187,155,748,948,635,825,532,251,448,385,399,411,440,11,813,179,1,301,475,87,697,830,233,447,995,861,385,259,767,24,946,987,280,983,4,592,403,616,192,689,882,470,949,708,129,995,188,633,881,173,521,609,108,702,109,671,926,152,79,50,31,703,468,769,686,586,402,394,564,923,408,248,238,259,799,870,751,268,533,120,974,55,416,630,692,453,165,352,109,160,225,59,267,209,49,66,879,378,292,646,942,715,875,829,914,551,200,22,216,793,723,731,487,796,553,517,516,558,85,739,866,249,791,421,854,398,853,463,54,965,811,97,727,274,378,229,173,701,390,51,509,325,356,331,75,955,250,910,387,878,663,444,148,854,909,939,191,537,593,547,860,749,207,847,243,577,60,163,97,40,26,847,47,71,870,230,58,442,851,74,57,863,128,160,963,828,70,928,658,915,722,294,610,796,497,438,287,634,597,956,696,669,575,185,253,554,874,371,48,400,982,501,414,867,93,474,577,189,71,777,106,199,917,654,22,132,786,481,464,927,612,274,972,543,772,817,478,140,761,578,582,309,855,391,240,343,600,296,126,65,940,479,248,687,495,156,751,412,862,712,138,468,786,233,171,826,270,859,56,49,897,142,149,477,39,359,309,726,990,91,976,23,804,245,322,711,456,194,574,265,261,602,738,511,639,833,307,114,81,528,997,14,446,696,987,802,31,979,523,844,353,386,220,188,959,752,582,985,258,154,986,277,706,182,474,134,885,631,970,147,561,102,919,336,707,372,368,174,753,202,760,521,512,478,718,40,969,151,812,277,462,915,457,443,603,25,655,851,69,74,997,408,131,818,525,656,235,185,901,420,252,989,520,738,803,607,650,785,284,273,409,968,406,912,349,902,494,714,448,130,708,537,989,938,262,958,801,815,397,116,367,312,747,985,147,35,737,134,221,122,249,662,174,771,560,980,765,746,838,317,695,491,859,365,385,465,677,713,932,941,276,765,101,384,757,830,168,702,533,940,900,783,843,993,18,338,472,799,719,892,628,559,759,721,855,30,842,542,555,643,623,410,51,479,279,675,124,376,798,646,111,46,7,376,332,62,175,605,745,364,131,689,281,678,190,203,950,185,884,564,37,995,691,965,346,215,589,44,846,876,587,486,812,122,493,391,142,327,388,302,125,631,438,337,160,992,682,107,845,371,138,651,668,872,337,726,411,883,266,986,790,872,589,329,314,943,488,680,833,321,529,672,780,397,426,699,683,717,21,60,260,1000,585,103,704,490,201,13,334,666,330,835,278,235,506,782,304,322,23,608,754,166,59,203,365,218,761,478,754,836,289,516,90,877,79,951,429,848,431,554,151,753,641,630,178,999,909,790,588,837,167,113,649,430,571,640,944,688,640,639,748,805,135,618,785,794,18,172,261,934,303,869,379,779,730,9,161,375,887,439,8,794,191,924,550,137,752,401,653,377,834,434,41,6,816,819,75,20,300,642,136,984,310,852,460,797,127,76,42,99,88,740,373,543,319,210,918,872,922,888,283,541,955,445,464,798,893,611,92,341,249,483,358,680,595,667,471,998,326,968,204,919,749,2,848,781,910,244,811,268,96,332,273,783,342,21,256,307,79,17,420,944,898,194,475,718,466,53,843,198,146,954,263,153,485,431,624,213,657,226,480,619,120,395,145,809,789,582,466,971,894,849,580,566,856,935,32,591,123,679,564,885,306,842,57,339,483,372,395,571,18,594,540,732,458,347,379,846,710,891,345,469,197,315,630,258,693,960,880,900,931,686,308,570,81,827,476,698,78,760,83,875,814,470,937,314,838,496,662,570,634,871,33,709,576,432,77,576,710,493,725,323,556,902,486,244,4,966,716,766,967,671,141,996,210,331,808,806,574,298,905,562,907,383,428,544,461,999,286,246,970,637,788,457,841,823,333,394,555,848,389,437,840,535,896,852,305,181,984,583,734,338,237,96,713,892,8,401,232,911,774,927,513,848,800,709,822,467,452,599,482,820,72,599,647,296,670,30,737,262,359,201,775,647,600,133,659,913,678,223,308,98,588,90,339,517,835,552,152,26,211,169,567,276,640,974,375,354,312,951,505,43,33,191,421,763,621,335,374,500,976,297,445,187,86,421,889,905,157,778,24,348,513,217,369,857,673,670,664,605,917,396,492,333,983,473,5,787,565,116,155,428,593,810,946,632,16,862,768,527,164,443,706,64,481,284,414,196,733,87,469,450,288,209,449,531,512,477,417,832,682,831,222,738,529,886,239,390,246,364,398,758,792,212,525,690,913,312,613,32,416,496,133,348,604,392,627,651,93,179,334,489,850,328,257,617,581,310,978,271,746,745,723,454,140,393,853,23,683,912,744,105,891,336,257,562,432,200,890,373,424,660,29,78,204,531,536,590,777,118,66,42,820,367,10,615,964,89,504,972,795,579,425,383,136,637,222,567,548,100,157,949,255,184,627,934,992,857,612,91,550,912,921,674,85,472,789,341,661,89,166,626,70,674,923,967,303,417,459,404,559,607,549,690,953,301,423,650,598,124,453,924,412,817,825,132,9,695,353,606,776,629,864,208,518,845,953,80,330,206,645,169,761,662,63,168,546,126,483,280,704,699,140,617,499,37,526,58,239,836,95,29,625,517,991,84,350,419,34,350,687,409,217,219,769,357,832,528,113,292,596,294,170,997,241,869,234,269,291,82,266,604,101,606,759,447,247,973,865,925,856,19,897,154,724,809,94,298,110,150,558,509,881,23,951,675,903,676,120};
        System.out.println(new LINTCODE717().LongestPathWithSameValue(A,E));
    }
}