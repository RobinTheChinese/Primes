import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

//本版本主要迭代目标是通过优化输出模块的结构加快程序的执行速度

public class prime_number2 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入所需要的最大范围：");
        int num = sc.nextInt();                                         //规定生成质数的范围
        double sqrt_num = Math.sqrt(num);
        int lim = (int) sqrt_num;                                       //生成需计算质数最大值
        System.out.println();
        System.out.println("稍等，计算中······");
        System.out.println(2);

        long stime = System.currentTimeMillis();                        //计时起点

        int[] list = new int[num+1];                                    //建立质数筛

        ArrayList<Integer> prime_use = new ArrayList<>();               //建立待过筛质数集
        prime_use.add(2);                                               //导入初始值：2
        ArrayList<Integer> prime_generated = new ArrayList<>();         //建立承接质数集

        do1:
        do {

            for (int i : prime_use) {
                for (int j = 2; i * j <= num; j++) {
                    list[i * j] = 1;                                    //对prime_unused中质数过筛
                }
            }

            int read_start = prime_use.get(prime_use.size()-1) + 1;     //起点的坐标
            int read_end = prime_use.get(prime_use.size()-1) * prime_use.get(prime_use.size()-1);   //终点的坐标

            for (int k = read_start; k <= read_end; k++) {
                if (list[k] == 0) {
                    if(k >= lim){
                        break do1;
                    }                                                   //进行范围判断，避免无用筛选
                    prime_generated.add(k);                             //遍历新筛部分，读取质数
                    System.out.println(k);                              //同时输出所读取的质数
                }
            }

            //if(prime_generated.get(prime_generated.size()-1) >= lim){
                //break;
            //}                                                           //判断是否已经完成筛选

            prime_use = new ArrayList<>(prime_generated);               //导入新一批质数
            prime_generated.clear();                                    //初始化承接质数集

        }while(true);

        for(int n = lim;n<=num;n++){
            if(list[n] == 0){
                System.out.println(n);                                  //输出质数表剩余部分
            }
        }

        long etime = System.currentTimeMillis();                        //完成时间
        System.out.printf("计算用时: %d 毫秒",etime - stime);

    }
}
