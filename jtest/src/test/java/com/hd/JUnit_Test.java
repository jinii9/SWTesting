package com.hd;

import com.hd.car.Car;
import com.hd.car.CarStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
@DisplayName("Assert API Test")
public class JUnit_Test {
    Car car1;
    Car car2;

    @BeforeEach
    public void beforeEachTest() {
        car1 = Car.builder().name("Car1").size(1000).status(CarStatus.STOP).build();
        car2 = Car.builder().name("Car2").size(2000).status(CarStatus.STOP).build();
    }

    @Test
    @DisplayName("Test1 정상")
    public void test1() {
        Assertions.assertNotEquals(car1, car2);// 출력하는게 아니라 검증하면서 진행을 한다.
        Assertions.assertNotNull(car2);
//        Assertions.assertEquals(car1.getName(), car2.getName());
        Assertions.assertNotEquals(car1.getName(), car2.getName());
    }

    @Test
    @DisplayName("Test2 정상")
    public void test2() {
        Assertions.assertAll( // 3개의 행위를 하나의 단위로 진행할 때 assertAll을 사용한다
                () -> Assertions.assertNotEquals(car1, car2),
                () -> Assertions.assertNotNull(car2),
                () -> Assertions.assertNotEquals(car1.getName(), car2.getName())
        );
    }

    @Test
    @DisplayName("Test3 정상")
    public void test3() {
        Assertions.assertEquals(car1, car2, "Not Equals");
//        Assertions.assertSame(car1, car2, "Not Same");
        Assertions.assertNotSame(car1, car2, "Not Same");
    }

}
