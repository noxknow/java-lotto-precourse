package lotto.domain;

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
}
