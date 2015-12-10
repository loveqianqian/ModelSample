package test;

/**
 * Created by zhiwei on 2015/12/7.
 */
public class LifeOffUseMethod3 {

    private static int count = 10;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count-->0){
                    System.out.println("id" + count);
                }
            }
        });
        thread.start();
    }
}
