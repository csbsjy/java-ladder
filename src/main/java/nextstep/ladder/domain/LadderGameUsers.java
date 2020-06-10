package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameUsers {
    private final List<LadderGameUser> ladderGameUsers;

    public LadderGameUsers(final List<LadderGameUser> ladderGameUsers) {
        this.ladderGameUsers = ladderGameUsers;
        checkDuplication(ladderGameUsers);
    }

    private void checkDuplication(List<LadderGameUser> ladderGameUsers) {
        List<LadderGameUser> uniqueUsers = ladderGameUsers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (uniqueUsers.size() != ladderGameUsers.size()) {
            throw new IllegalArgumentException("LadderGameUser는 중복된 이름을 가질 수 없습니다.");
        }
    }
}
