package lotto.domain;

import lotto.handler.LottoHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.handler.ErrorHandler.DUPLICATE_NUMBER;
import static lotto.handler.ErrorHandler.INVALID_RANGE;

public class LottoJudge {

    private final List<Integer> sortedNumbers;
    private final List<Integer> winningLotto;
    private final int bonusNumber;

    public LottoJudge(List<Integer> sortedNumbers, List<Integer> winningLotto, int bonusNumber) {
        this.sortedNumbers = sortedNumbers;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;

        validateDuplicate(bonusNumber);
        validateRange(bonusNumber);
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

    public LottoHandler matchLottoHandler(int count) {
        if (count == 5 && sortedNumbers.contains(bonusNumber)) {
            return LottoHandler.BONUS;
        } else if (count == 5 && !sortedNumbers.contains(bonusNumber)) {
            return LottoHandler.FIVE;
        }

        LottoHandler lottoHandler = LottoHandler.getLottoHandler(count);

        return lottoHandler;
    }
}
