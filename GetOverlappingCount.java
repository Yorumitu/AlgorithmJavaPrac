import java.util.Collections;

/**
 *  给定多个可能重叠的区间，找出重叠区间的个数的最大值。
 *  思路： 将区间边界转换成点，对所有点进行排序，扫描排序结果。
 *  当遇到起点时，重叠个数加一，并且记录重叠个数的最大值；
 *  当遇到止点时，重叠个数减一。
 */
public class GetOverlappingCount {
    //区间定义如下：
    public class Interval{
        int start; //起点
        int end; //止点
        Interval(int a,int b){
            start=a;
            end=b;
        }
    }
    class Point implements Comparable<Point>{
        int value;
        int type; //0：起点； 1：终点
        Point(int v,int t){
            value=v;
            type=t;
        }
        public int compareTo(Point p){
            if(this.value==p.value){
                return 0;
            }
            else if(this.value>p.value){
                return 1;
            }
            else{
                return -1;
            }
        }
    }

    int getOverlappingCount(Interval[] A){
        int max=0,count=1;
        if(A==null||A.length==0)
            return max;
        Point[] points=new Point[A.length*2];
        for(int i=0;i<A.length;i++){
            points[2*i]=new Point(A[i].start,0);
            points[2*i+1]=new Point(A[i].end,1);
        }
        Collections.sort(points); //将坐标从小到大排序
        for(int i=0;i<points.length;i++){
            if(points[i].type==0){ //起点
                count++;
                max=Math.max(max,count); //更新最大值
            }
            else{
                count--; //遇到了区间终点
            }
        }
        return max;
    }
}
