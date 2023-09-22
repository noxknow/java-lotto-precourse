package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.handler.ErrorHandler.DUPLICATE_NUMBER;
import static lotto.handler.ErrorHandler.INVALID_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw INVALID_COUNT.getException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw DUPLICATE_NUMBER.getException();
        }
    }

    public List<Integer> sortLottoNumbers() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
