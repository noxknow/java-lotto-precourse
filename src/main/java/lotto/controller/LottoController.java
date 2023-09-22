package lotto.controller;

import lotto.domain.MoneyService;
import lotto.handler.InputHandler;

public class LottoController {

    private final InputHandler inputHandler;
    private final MoneyService moneyService;

    public LottoController(InputHandler inputHandler, MoneyService moneyService) {
        this.inputHandler = inputHandler;
        this.moneyService = moneyService;
    }

    public void run() {
        int count = getCount();
        inputHandler.getWinningLotto();
        inputHandler.getBonusNumber();
    }

    private int getCount() {
        int purchaseAmount = inputHandler.getPurchaseAmount();
        moneyService.validate(purchaseAmount);

        return moneyService.getCount(purchaseAmount);
    }
}
