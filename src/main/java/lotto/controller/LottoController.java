package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.service.MoneyService;
import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;

import java.util.List;

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
        List<Lotto> buyLottoLists = getBuyLottoList(count);
        getStatistics(buyLottoLists);
    }

    private int getCount() {
        int purchaseAmount = inputHandler.getPurchaseAmount();
        moneyService.validate(purchaseAmount);

        return moneyService.getCount(purchaseAmount);
    }

    private List<Lotto> getBuyLottoList(int count) {
        List<Lotto> buyLottoLists = lottoService.getLottoNumbers(count);
        outputHandler.printBuyLottoList(buyLottoLists);

        return buyLottoLists;
    }

    private void getStatistics(List<Lotto> buyLottoLists) {
        List<Integer> winningLotto = inputHandler.getWinningLotto();
        int bonusNumber = inputHandler.getBonusNumber();
        List<Integer> countList = lottoService.compareLotto(buyLottoLists, winningLotto, bonusNumber);

        outputHandler.printWinningLottoList(countList, bonusNumber);
    }
}
