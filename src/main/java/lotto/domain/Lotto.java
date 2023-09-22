package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.handler.ErrorHandler.INVALID_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw INVALID_COUNT.getException();
        }
    }

    public List<Integer> sortLottoNumbers() {

        List<Integer> sortNumbers = new ArrayList<>();
        sortNumbers.addAll(numbers);
        Collections.sort(sortNumbers);

        return sortNumbers;
    }
}
