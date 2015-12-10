package test.NumTest;

/**
 * Created by zhiwei on 2015/12/6.
 */
public class NumSample {
    static int num = 123456;

    public static void main(String[] args) {
        System.out.println(num % 10);
        System.out.println((num / 10) % 10);
        System.out.println(num / 100 % 10);
        System.out.println(num / 1000 % 10);
        System.out.println(num / 10000 % 10);
    }
}
