package com.hd;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

@Slf4j
@DisplayName("Test Sequence")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // order로 순서를 정하게 해주는
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.Random.class)
public class JUnit_Seq {
    @AfterAll
    public static void afterAll() {
        log.info("afterAll");
    }
    @BeforeAll
    public static void beforeAll() {
        log.info("beforeAll");
    }
    @BeforeEach
    public void beforeEach(){
        log.info("beforeEach");
    }
    @AfterEach
    public void afterEach(){
        log.info("afterEach");
    }

    @Test
    @DisplayName("Test2 정상케이스")
    @Order(1)
    public void test2(){
        log.info("Test2");
    }
    @Test
    @Order(3)
    @DisplayName("Test1 정상케이스")
    public void test1(){
        log.info("Test1");
    }
    @Test
    @Order(2)
    @DisplayName("Test3 정상케이스")
    public void test3(){
        log.info("Test3");
    }
}
