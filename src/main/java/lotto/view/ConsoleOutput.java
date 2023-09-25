package lotto.view;

import lotto.domain.Lotto;
import lotto.handler.OutputHandler;
import lotto.repository.Repository;

import java.util.List;

public class ConsoleOutput implements OutputHandler {

    @Override
    public void printBuyLottoList(int count, Repository repository) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");

        repository.showBuyLottoLists();
    }

    @Override
    public void printWinningLottoList() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");


    }

    @Override
    public void printYield() {

    }
}
