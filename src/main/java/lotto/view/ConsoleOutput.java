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
    public void printWinningLottoList(List<Integer> countList, int bonusNumber) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (int i = 3; i < 7; i++) {
            int lottoCount = i;
            long matchingCount = countList.stream()
                    .filter(c -> c == lottoCount)
                    .count();

            System.out.println();
        }
    }

    @Override
    public void printYield() {

    }
}
