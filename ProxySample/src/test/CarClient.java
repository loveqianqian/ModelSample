package test;

import com.myloverqian.implement.MoveAble;
import com.myloverqian.implement.achieve.Car;
import com.myloverqian.implement.achieve.CarLogProxy;
import com.myloverqian.implement.achieve.CarTimeProxy;

/**
 * Created by zhiwei on 2015/12/3.
 */
public class CarClient {
    public static void main(String[] args) {
        Car car = new Car();
        MoveAble time = new CarTimeProxy(car);
        MoveAble log = new CarLogProxy(time);
        log.move();
    }
}
