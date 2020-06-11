package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameUsersTest {

    @DisplayName("중복된 유저네임을 입력하면 Exception을 던진다")
    @Test
    void duplicate() {
        //given
        String user1 = "abc";
        String user2 = "abc";

        //when
        //then
        assertThatThrownBy(() -> new LadderGameUsers(Arrays.asList(user1, user2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("LadderGameUser는 중복된 이름을 가질 수 없습니다.");

    }

}