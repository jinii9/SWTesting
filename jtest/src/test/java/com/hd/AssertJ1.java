package com.hd;

import com.hd.car.Car;
import com.hd.car.CarStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DisplayName("AssertJ Test")
public class AssertJ1 {
    Car car1;
    Car car2;

    @BeforeEach
    public void beforeEachTest() {
        car1 = Car.builder().name("Car1").size(1000).status(CarStatus.STOP).build();
        car2 = Car.builder().name("Car2").size(2000).status(CarStatus.STOP).build();
    }

    @Test
    @DisplayName("AssertJ_Test_1")
    public void test2() {
        List<Integer> lists = Arrays.asList(1,2,3,4,5);
        assertThat(lists).hasSize(5);
        assertThat(lists).contains(1,2,3);
        assertThat(lists).containsOnly(1,2,3,4,5);
    }
}
