package LINTCODE4;

import java.util.Arrays;

public class LINTCODE325 {
    /*Description
    *考虑一个包含16支球队的淘汰赛足球赛，表示为0，1，…，15。在每一轮的比赛中，所有仍在比赛中的球队都会按递增的顺序排列在一个名单中。
    * 然后，名单上的第一队与第二队比赛，第三队与第四队比赛，这些比赛的胜者晋级下一轮，输家被淘汰。四轮过后，只有一支球队保持不败，该队被宣布获胜。
    * 给定一个矩阵P= [pij]，即pij是i队在比赛中击败j队的概率，决定哪支球队最有可能赢得锦标赛。
    * Hint：如果多支队伍获胜概率相同，优先返回下标最小的。
    * */

    public int findWinner(double[][] probability) {
        double[] pro1=new double[16];
        for(int i=0;i<16;i+=2){
            pro1[i]=probability[i][i+1];
            pro1[i+1]=probability[i+1][i];
        }
        double[] pro2=new double[16];
        for(int i=0;i<16;i+=4){
            pro2[i]=pro1[i]*(probability[i][i+2]*pro1[i+2]+probability[i][i+3]*pro1[i+3]);
            pro2[i+1]=pro1[i+1]*(probability[i+1][i+2]*pro1[i+2]+probability[i+1][i+3]*pro1[i+3]);
            pro2[i+2]=pro1[i+2]*(probability[i+2][i]*pro1[i]+probability[i+2][i+1]*pro1[i+1]);
            pro2[i+3]=pro1[i+3]*(probability[i+3][i]*pro1[i]+probability[i+3][i+1]*pro1[i+1]);
        }
        double[] pro3=new double[16];
        for(int i=0;i<16;i+=8){
            for(int j=0;j<4;j++){
                pro3[i+j]=pro2[i+j]*(probability[i+j][i+4]*pro2[i+4]+probability[i+j][i+5]*pro2[i+5]+probability[i+j][i+6]*pro2[i+6]+probability[i+j][i+7]*pro2[i+7]);
                pro3[i+j+4]=pro2[i+j+4]*(probability[i+j+4][i]*pro2[i]+probability[i+j+4][i+1]*pro2[i+1]+probability[i+j+4][i+2]*pro2[i+2]+probability[i+j+4][i+3]*pro2[i+3]);
            }
        }
        double[] pro4=new double[16];
        for(int j=0;j<8;j++){
            for(int i=0;i<8;i++){
                pro4[j]+=pro3[j]*probability[j][i+8]*pro3[i+8];
                pro4[j+8]+=pro3[j+8]*probability[j+8][i]*pro3[i];
            }
        }
        double max=pro4[0];
        int result=0;
        for(int i=1;i<16;i++){
            if(pro4[i]>max){
                result=i;
                max=pro4[i];
            }
        }
        return result;
        // write your code here
    }
}
