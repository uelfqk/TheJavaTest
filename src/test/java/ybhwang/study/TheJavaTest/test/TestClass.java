package ybhwang.study.TheJavaTest.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import ybhwang.study.TheJavaTest.chapter_1.Study;

public class TestClass {

    @Test
    void test() {
        System.out.println("Test");
    }

    @Test
    void test2() {
        System.out.println("푸시");
    }

    @Test
    void 실패_테스트() {
        Study study = new Study(10);

        Assertions.assertThat(study).isNotNull();
    }
}
