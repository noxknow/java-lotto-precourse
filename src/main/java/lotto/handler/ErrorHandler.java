package lotto.handler;

public enum ErrorHandler {

    INCONVERTIBLE_TYPE("유효하지 않은 입력입니다."),
    INVALID_PARSING_INPUT("각 숫자는 쉼표로 구분되어야 합니다."),
    INVALID_NEGATIVE_INPUT("입력은 음수가 될 수 없습니다."),
    INVALID_AMOUNT("입력한 금액이 1,000원으로 나누어 떨어지지 않습니다.");

    private final String errorMessage;

    ErrorHandler(String message) {
        errorMessage = "[ERROR] " + message;
    }

    public RuntimeException getException() {
        return new IllegalArgumentException(errorMessage);
    }
}
