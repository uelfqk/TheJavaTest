package ybhwang.study.TheJavaTest.chapter_1;

import lombok.Getter;
import lombok.Setter;
import ybhwang.study.TheJavaTest.StudyStatus;

@Getter @Setter
public class Study {

    private StudyStatus status;

    private int limit;

    public Study() {
        this.status = StudyStatus.DRAFT;
    }

    public Study(int limit) {
        this();
        if(limit < 0) {
            throw new IllegalArgumentException("limit 값은 0보다 커야한다.");
        }

        this.limit = limit;
    }
}
