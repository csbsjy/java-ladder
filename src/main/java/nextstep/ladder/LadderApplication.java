package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.RandomLadderConnection;
import nextstep.ladder.domain.game.LadderGame;
import nextstep.ladder.domain.game.LadderGamePrize;
import nextstep.ladder.domain.game.LadderGameResult;
import nextstep.ladder.domain.user.LadderGameUserStorage;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        LadderGameUserStorage ladderGameUserStorage = InputView.askParticipantsName();
        int maxPoint = InputView.askMaximumLadderHeight();

        LadderGame ladderGame = new LadderGame(new RandomLadderConnection());
        LadderGamePrize ladderGamePrize = InputView.askLadderGamePrize();
        Ladder ladder = ladderGame.createLadder(ladderGameUserStorage, maxPoint);
        OutputView.drawLadder(ladder, ladderGamePrize);

        LadderGameResult ladderGameResult = ladderGame.execute(ladder, ladderGamePrize);
        String resultUser = InputView.askResultUser();
        OutputView.printPrize(ladderGameUserStorage, resultUser, ladderGameResult);
    }
}
