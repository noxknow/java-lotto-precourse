package lotto.view;

import lotto.domain.Lotto;
import lotto.handler.OutputHandler;

import java.util.List;

public class ConsoleOutput implements OutputHandler {

    @Override
    public void printBuyLottoList(List<Lotto> buyLottoLists) {
        System.out.println();
        System.out.println(buyLottoLists.size() + "개를 구매했습니다.");

        buyLottoLists.stream()
                .map(Lotto::sortLottoNumbers)
                .forEach(System.out::println);
    }

    @Override
    public void printWinningLottoList() {

    }

    @Override
    public void printYield() {

    }
}
