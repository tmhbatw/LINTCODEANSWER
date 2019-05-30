package LINTCODE1;

public class LINTCODE24 {
    /*Description
    *LFU是一个著名的缓存算法对于容量为k的缓存，如果缓存已满，并且需要逐出其中的密钥，则最少使用的密钥将被踢出。实现LFU中的set 和 get
    * */

    /*Solution
    * LFU缓存算法为：当缓存满时弹出使用最少的密钥，使用次数相同则弹出最近不使用的页面
    * 用temp值判断缓存是否已满，用last表示上一次使用/插入的时间
    * 创建一个大小为4*capacity的数组用来存储所有的key、value、key使用的次数、key最近使用的时间；
    * */
    int[] cache;
    int temp=0;//表示下一插入的数据起始位置为cache[0];
    int last=0;
    public LINTCODE24(int capacity) {
        cache=new int[capacity*4];
        // do intialization if necessary
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        //当缓存中已有key值时的处理
        for(int i=0;i<temp;i+=4){
            if(cache[i]==key){
                cache[i+1]=value;
                cache[i+2]++;
                cache[i+3]=++last;
                return;
            }
        }
        //当缓存未满时的处理
        if(temp<cache.length){
            cache[temp]=key;
            cache[temp+1]=value;
            cache[temp+2]=1;
            cache[temp+3]=++last;
            temp+=4;
            return;
        }
        //当缓存已满踢出一个值时的处理
        int out=2;
        int min=cache[2];
        for(int i=2+4;i<temp;i+=4){
            //out=min>cache[i]?i:min==cache[i]?(cache[out+1]<cache[i+1]?out:i):out;
            out=(min<cache[i]||(min==cache[i]&&cache[out+1]<cache[i+1]))?out:i;
            min=Math.min(min,cache[i]);
        }
        //踢掉原来的，更换新的
        cache[out-2]=key;
        cache[out-1]=value;
        cache[out]=1;
        cache[out+1]=++last;

    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        for(int i=0;i<temp;i+=4){
            if(cache[i]==key){
                cache[i+2]++;
                cache[i+3]=++last;
                return cache[i+1];
            }
        }
        return -1;
    }
}
