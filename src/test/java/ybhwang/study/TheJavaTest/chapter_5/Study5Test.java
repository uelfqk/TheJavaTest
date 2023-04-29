package ybhwang.study.TheJavaTest.chapter_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import ybhwang.study.TheJavaTest.chapter_1.Study;

import static org.assertj.core.api.Assertions.assertThat;

// TODO : JUnit 5 태깅과 필터링
//  1. 테스트의 조건이나 환경에 따라 태그를 붙일 수 있음
//      1). @Tag
//          -. 실행 할 테스트의 종류에 따라 필터링
//          -. EditConfiguration 에서 class -> tags 로 변경 tag name 입력
class Study5Test {

    @Test
    @DisplayName(value = "느려서 LOCAL 에서 테스트 안함")
    @Tag("slow")
    void tagSlowTest() {
        Study study = new Study(10);
        assertThat(study).isNotNull();
    }

    @Test
    @DisplayName(value = "빠름 LOCAL 에서 테스트 실행")
    @Tag("fast")
    void tagFastTest() {
        Study study = new Study(10);
        assertThat(study).isNotNull();
    }
}