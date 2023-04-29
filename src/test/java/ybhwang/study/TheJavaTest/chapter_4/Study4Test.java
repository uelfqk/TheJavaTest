package ybhwang.study.TheJavaTest.chapter_4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import ybhwang.study.TheJavaTest.StudyStatus;
import ybhwang.study.TheJavaTest.chapter_1.Study;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

// TODO : JUnit 5 조건에 따라 테스트 실행하기
//  1. 테스트를 특정 환경 변수나 OS 등에서만 실행하도록 하는 기능
//  2. 환경에 따른 테스트 실행
//      1). 코드 기반 : Assumptions.assumeTrue, Assumptions.assumeFalse
//      1). 애노테이션 기반 : EnabledIfEnvironmentVariable, DisabledIfEnvironmentVariable
//  3. 환경에 따른 선택적 테스트 실행
//      1). assumingThat
//  4. 애노테이션
//      1). @EnabledOnOs, @DisabledOnOs, @EnabledOnJre, @DisabledOnJre 등...
class Study4Test {

    String testEnv;

    @BeforeEach
    void beforeEach() {
        testEnv = System.getenv("TEST_ENV");
        System.out.println("testEnv = " + testEnv);
    }

    @Test
    @DisplayName(value = "코드 기반 환경에 따른 테스트 실행")
    void assumeTrueTest() {
        Assumptions.assumeTrue("LOCAL".equalsIgnoreCase(testEnv));

        Study study = new Study(10);
        assertThat(study.getLimit()).isGreaterThan(0);
    }

    @Test
    @DisplayName(value = "코드 기반 환경에 따른 선택적 테스트 실행")
    void assumingThatTest() {
        Assumptions.assumingThat("LOCAL".equalsIgnoreCase(testEnv), () -> {
            Study study = new Study(10);
            assertThat(study.getLimit()).isEqualTo(10);
            System.out.println("LOCAL Test 실행");
        });

        Assumptions.assumingThat("PROD".equalsIgnoreCase(testEnv), () -> {
            Study study = new Study(20);
            assertThat(study.getLimit()).isEqualTo(20);
            System.out.println("PROD Test 실행");
        });
    }

    @Test
    @DisplayName(value = "애노테이션 기반 환경 변수가 LOCAL 일때 실행")
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    void enabledIfEnvironmentVariableTest() {
        Study study = new Study(10);
        assertThat(study.getLimit()).isGreaterThan(0);
    }

    @Test
    @DisplayName(value = "애노테이션 기반 환경 변수가 LOCAL 일때 실행 안함")
    @DisabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    void disabledIfEnvironmentVariableTest() {
        System.out.println("애노테이션 기반 환경 변수가 LOCAL 일때 실행");
        Study study = new Study(10);
        assertThat(study.getLimit()).isGreaterThan(0);
    }

    @Test
    @DisplayName(value = "운영체제가 Windows 인 경우 테스트 실행")
    @EnabledOnOs(value = OS.WINDOWS)
    void enabledOnOsTest() {
        Study study = new Study(10);
        assertThat(study).isNotNull();
    }

    @Test
    @DisplayName(value = "운영체제가 Windows 인 경우 테스트 실행 안함")
    @DisabledOnOs(value = OS.WINDOWS)
    void disabledOnOsTest() {
        Study study = new Study(10);
        assertThat(study).isNotNull();
    }
}