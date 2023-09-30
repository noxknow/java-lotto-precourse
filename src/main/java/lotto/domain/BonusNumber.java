package lotto.domain;

import java.util.List;

import static lotto.handler.ErrorHandler.DUPLICATE_NUMBER;
import static lotto.handler.ErrorHandler.INVALID_RANGE;

public class BonusNumber {

    private final List<Integer> winningLotto;
    private final int bonusNumber;

    public BonusNumber(List<Integer> winningLotto, int bonusNumber) {
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
}
