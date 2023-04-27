package ybhwang.study.TheJavaTest.chapter_1;

import org.junit.jupiter.api.*;

// TODO : JUnit 5 시작하기
//  1. @BeforeAll :
//      1). 테스트가 실행될때 딱 한번 실행
//      2). 반드시 static 키워드를 붙여서 선언
//  2. @AfterAll :
//      1). 테스트가 종료될때 딱 한번 실행
//      2). 반드시 static 키워드를 붙여서 선언
//  3. @BeforeEach :
//      1). 테스트가 실행될때 마다 한번 실행
//  4. @AfterEach :
//      1). 테스트가 종료될때 마다 한번 실행
//  5. @Disabled
//      1). 테스트를 실행하고 싶지 않을때 사용
//      2). Deprecated 된 코드이지만 코드정리가 되지 않아 테스트를 남겨두어야할때 등
class Study1Test {

    @Test
    void create() {
        Study study = new Study();
        Assertions.assertNotNull(study);
        System.out.println("create");
    }

    @Test
    @Disabled
    void create1() {
        System.out.println("create1");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }
}