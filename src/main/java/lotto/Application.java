package lotto;

import lotto.controller.LottoController;
import lotto.domain.MoneyService;
import lotto.handler.InputHandler;
import lotto.view.ConsoleInput;

public class Application {
    public static void main(String[] args) {

        final InputHandler inputHandler = new ConsoleInput();
        final MoneyService moneyService = new MoneyService();

        new LottoController(inputHandler, moneyService).run();
    }
}
