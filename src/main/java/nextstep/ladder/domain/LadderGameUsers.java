package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameUsers {
    private final List<LadderGameUser> ladderGameUsers;

    public LadderGameUsers(final List<String> ladderGameUsers) {
        this.ladderGameUsers = ladderGameUsers.stream()
                .map(String::trim)
                .map(LadderGameUser::new)
                .collect(Collectors.toList());
        checkDuplication(this.ladderGameUsers);
    }

    private void checkDuplication(List<LadderGameUser> ladderGameUsers) {
        List<LadderGameUser> uniqueUsers = ladderGameUsers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (uniqueUsers.size() != ladderGameUsers.size()) {
            throw new IllegalArgumentException("LadderGameUser는 중복된 이름을 가질 수 없습니다.");
        }
    }

    public List<LadderGameUser> getLadderGameUsers() {
        return Collections.unmodifiableList(ladderGameUsers);
    }
}
