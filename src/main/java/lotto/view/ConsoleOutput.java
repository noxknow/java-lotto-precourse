package lotto.view;

import lotto.domain.Money;
import lotto.handler.OutputHandler;
import lotto.repository.Repository;

public class ConsoleOutput implements OutputHandler {

    @Override
    public void printBuyLottoList(Money money, Repository repository) {
        System.out.println();
        System.out.println(money.getCount() + "개를 구매했습니다.");

        repository.showBuyLottoLists();
    }

    @Override
    public void printWinningLottoList(Repository repository) {
        repository.showWinningLottoList();
    }

    @Override
    public void printYield(int count, Repository repository) {
        repository.showProfit(count);
    }
}
