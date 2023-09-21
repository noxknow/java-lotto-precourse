package lotto.handler;

public enum ErrorHandler {

    INVALID_AMOUNT("입력한 금액이 1,000원으로 나누어 떨어지지 않습니다."),
    INVALID_FORMAT("유효하지 않은 입력입니다.");

    private final String errorMessage;
    ErrorHandler(String message) {
        errorMessage = "[ERROR] " + message;
    }

    public RuntimeException getException() {
        return new IllegalArgumentException(errorMessage);
    }
}
