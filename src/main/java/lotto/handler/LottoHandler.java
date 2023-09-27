package lotto.handler;

import java.util.Arrays;
import java.util.Optional;

public enum LottoHandler {

    THREE(3, "5,000원", ""),
    FOUR(4, "50,000원", ""),
    FIVE(5, "1,500,000원", ""),
    BONUS(5, "30,000,000원", ", 보너스 볼 일치"),
    SIX(6, "2,000,000,000원", ""),
    NOPE(0, "0", "");

    private final int count;
    private final String prize;
    private final String message;

    LottoHandler(int count, String prize, String message) {
        this.count = count;
        this.prize = prize;
        this.message = message;
    }

    public static LottoHandler getLottoHandler(long matchingCount) {
        for (LottoHandler lottoHandler : LottoHandler.values()) {
            if (lottoHandler.getCount() == matchingCount) {
                return lottoHandler;
            }
        }

        return NOPE;
    }

    public int getCount() {
        return count;
    }

    public String getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
