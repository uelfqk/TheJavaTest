package ybhwang.study.TheJavaTest.chapter_3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ybhwang.study.TheJavaTest.StudyStatus;
import ybhwang.study.TheJavaTest.chapter_1.Study;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

// TODO : JUnit 5 Assertion
//  1.Assertions (org.junit.jupiter.api.Assertions) Junit 테스트를 편리하게 도와주는 메소드 제공
//  2.Assertions (org.assertj.core.api.Assertions) Junit 테스트를 편리하게 도와주는 메소드 제공
//  3. 테스트 메소드
//      1). assertThat(atual)
//          -. isNotNull(expected) : null 이 아닌지 검증
//          -. isNull(expected) : null 인지 검증
//          -. isEqualTo(expected) : 동등성 검증
//          -. withFailMessage(Supplier) : 오류 메시지
//  4. 메시지 생성을에 Supplier 를 사용하는
//      1). 메시지(문자열) 연산을 실패할때만 연산하기떄문.
//      2). 비용을 적재적소에 사용
//  5.assertAll (org.junit.jupiter.api.Assertions)
//      1). 테스트를 성공 실패 여부에 관계 없이 모두 실행해 결과 도출
//  6. Assertions.assertTimeout
//      1). 객체 생성 시간 등 타임아웃이 발생하는 경우에 대한 테스트 가능
//      2). 테스트 시간을 모두 기다린다.
//  7. org.junit.jupiter.api.Assertions.assertTimeoutPreemptively
//      1). 테스트 시간을 모두 기다리지 않고 즉각적으로 확인 할 수 있는 메소드
//      2). ThreadLoadl 을 사용하는 코드가 있을 경우 예쌍치 못할 상황이 발생할 수 있음
//      3). @Transactional 의 경우는 ThreadLocal 을 기본 전략으로 가져가는데 공유가 되지 않기 떄문에 정상 동작하지 않을 수 있음
//          *. 가령 롤백이 되어야하는데 DB에 반영되는 경우가 있다.
class Study3Test {

    @Test
    @DisplayName(value = "스터디 생성 테스트")
    void createNewStudySuccessTest() {
        Study study = new Study(10);
        assertAll(
                () -> assertThat(study).isNotNull(),
                () -> assertThat(study.getStatus()).isEqualTo(StudyStatus.DRAFT)
                        .withFailMessage(() -> "스터디를 처음 만들면 상태값이 " + StudyStatus.DRAFT + " 여야 한다."),
                () -> assertThat(study.getLimit()).isEqualTo(10)
        );
    }
    
    @Test
    @DisplayName(value = "스터디 생성 실패 (예외발생) 테스트")
    void createNewStudyFailTest() {
        Assertions.assertThatThrownBy(() -> new Study(-10))
                .isInstanceOf(IllegalArgumentException.class);
//                .hasMessage("limit 값은 0보다 커야한다.");
    }

    @Test
    @DisplayName(value = "timeout 테스트")
    void timeoutTest() throws InterruptedException {
        org.junit.jupiter.api.Assertions.assertTimeout(Duration.ofMillis(100), () -> {
            Study study = new Study(10);
            Thread.sleep(90);
        });
    }
}