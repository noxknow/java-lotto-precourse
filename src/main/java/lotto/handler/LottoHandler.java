package lotto.handler;

import java.util.Arrays;

public enum LottoHandler {

    THREE(3, "5,000원", ""),
    FOUR(4, "50,000원", ""),
    FIVE(5, "1,500,000원", ""),
    BONUS(5, "30,000,000원", "보너스 볼 일치"),
    SIX(6, "2,000,000,000원", "");

    private final int count;
    private final String prize;
    private final String message;

    LottoHandler(int count, String prize, String message) {
        this.count = count;
        this.prize = prize;
        this.message = message;
    }

    public static LottoHandler getLottoHandler(long matchingCount) {
        return Arrays.stream(LottoHandler.values())
                .filter(l -> l.count == matchingCount)
                .findFirst()
                .get();
    }

    public String getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
