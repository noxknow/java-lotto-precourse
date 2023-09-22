package lotto.controller;

import lotto.domain.LottoService;
import lotto.domain.MoneyService;
import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;

public class LottoController {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final MoneyService moneyService;
    private final LottoService lottoService;

    public LottoController(InputHandler inputHandler, OutputHandler outputHandler, MoneyService moneyService, LottoService lottoService) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.moneyService = moneyService;
        this.lottoService = lottoService;
    }

    public void run() {

        int count = getCount();
        getBuyLottoList(count);

        inputHandler.getWinningLotto();
        inputHandler.getBonusNumber();
    }

    private int getCount() {
        int purchaseAmount = inputHandler.getPurchaseAmount();
        moneyService.validate(purchaseAmount);

        return moneyService.getCount(purchaseAmount);
    }

    private void getBuyLottoList(int count) {
        outputHandler.printBuyLottoList(lottoService.getLottoNumbers(count));
    }
}
