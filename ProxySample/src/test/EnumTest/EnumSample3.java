package test.EnumTest;

import com.myloverqian.implement.EnumBean.Sample;

/**
 * Created by zhiwei on 2015/12/4.
 */
public class EnumSample3 {
    private Sample sample;

    public EnumSample3(Sample sample) {
        this.sample = sample;
    }

    public void design() {
        System.out.println("this is burrito:");
        switch (sample) {
            case NOT:
                System.out.println("not");
                break;
            case MILD:
                System.out.println("mild");
                break;
            case MEDIUM:
                System.out.println("medium");
                break;
            case HOT:
                System.out.println("hot");
                break;
            case FLAMING:
                System.out.println("flaming");
                break;
            default:
                System.out.println("do not worry");
                break;
        }
    }

    public static void main(String[] args) {
        EnumSample3 test1 = new EnumSample3(Sample.HOT);
        EnumSample3 test2 = new EnumSample3(Sample.MEDIUM);
        EnumSample3 test3 = new EnumSample3(Sample.FLAMING);
        test1.design();
        test2.design();
        test3.design();
    }
}
