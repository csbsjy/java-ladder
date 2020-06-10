package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BaseUserLineTest {


    @DisplayName("연결된 Point위치의 연결여부를 물어보면 true/false 를 반환한다")
    @Test
    void connect() {
        //given
        Set<Point> points = new HashSet<>();
        points.add(new Point(1));
        points.add(new Point(2));
        ConnectPoints connectPoints = new ConnectPoints(points);
        BaseUserLine userLine = new BaseUserLine(new LadderGameUser("abc"), connectPoints);

        //when
        //then
        assertAll(
                () -> assertThat(userLine.isConnected(new Point(1))).isEqualTo(true),
                () -> assertThat(userLine.isConnected(new Point(2))).isEqualTo(true),
                () -> assertThat(userLine.isConnected(new Point(3))).isEqualTo(false)
        );
    }
}