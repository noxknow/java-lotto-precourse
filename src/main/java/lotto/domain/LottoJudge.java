package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.handler.ErrorHandler.DUPLICATE_NUMBER;
import static lotto.handler.ErrorHandler.INVALID_RANGE;

public class LottoJudge {

    private final List<Lotto> buyLottoLists;
    private final List<Integer> winningLotto;
    private final int bonusNumber;

    public LottoJudge(List<Lotto> buyLottoLists, List<Integer> winningLotto, int bonusNumber) {
        Lotto lotto = new Lotto(winningLotto);
        validateDuplicate(bonusNumber);
        validateRange(bonusNumber);

        this.buyLottoLists = buyLottoLists;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw DUPLICATE_NUMBER.getException();
        }
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw INVALID_RANGE.getException();
        }
    }
}
