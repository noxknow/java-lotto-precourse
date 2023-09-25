package lotto.repository;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class ListRepository implements Repository {

    List<Lotto> results = new ArrayList<>();

    @Override
    public void saveBuyLottoLists(List<Lotto> buyLottoLists) {
        results.addAll(buyLottoLists);
    }

    @Override
    public void showBuyLottoLists() {
        results.stream()
                .map(Lotto::sortLottoNumbers)
                .forEach(System.out::println);
    }

    @Override
    public void showWinningLottoList(List<Integer> countList, int bonusNumber) {
        for (int i = 3; i < 7; i++) {
            int lottoCount = i;
            long matchingCount = countList.stream()
                    .filter(c -> c == lottoCount)
                    .count();

            System.out.println();
        }
    }
}
