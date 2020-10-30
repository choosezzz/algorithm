package main.java.newcoder;

/**
 * @author dingshuangen
 * @date 2020/5/9 22:47
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 递归：2*n的大矩形，小矩形竖着放则为f(n-1)
 * 横着放占用两个空间则为f(n-2)
 * 只有横竖两种选择
 */
public class Offer010 {

    /**
     * 运行时间：494ms
     * 占用内存：9280k
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target <= 0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }

    /**
     * 运行时间：13ms
     * 占用内存：9408k
     * @param target
     * @return
     */
    public int loopRectCover(int target) {
        if (target <= 0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        int f = 1;
        int g = 2;
        while ((target--)>2){
            g+=f;
            f=g-f;
        }
        return g;
    }

}
