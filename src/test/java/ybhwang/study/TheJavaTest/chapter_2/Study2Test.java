package ybhwang.study.TheJavaTest.chapter_2;

import org.junit.jupiter.api.*;
import ybhwang.study.TheJavaTest.chapter_1.Study;

// TODO : JUnit 5 테스트 이름
//  1. 테스트 이름 출력 기본 전략
//      1). 메서드 이름
//  1. @DisplayNameGeneration :
//      1). 테스트 이름을 어떻게 생성할건지에 대한 전략의 구현체를 입력
//      2). 해당 전략에 따라 테스트 이름 생성
//      3). DisplayNameGenerator.ReplaceUnderscores.class -> under score 를 제외하는 전력
//      4). class, method 에 사용 가능
//  2. @DisplayName
//      1). 테스트의 이름 지정 애노테이션
//      2). method 에 선언한 애노테이션으로 override
//      3). method 에 사용 가능
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class Study2Test {

    @Test
    @DisplayName(value = "스터디 생성 테스트")
    void create_new_study() {
        Study study = new Study();
        Assertions.assertNotNull(study);
        System.out.println("create");
    }

    @Test
    @DisplayName(value = "스터디 생성 테스트2")
    void create_new_study_again() {
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