package lotto.handler;

import lotto.domain.Lotto;

import java.util.List;

public interface OutputHandler {

    public void printBuyLottoList(List<Lotto> buyLottoLists);
    public void printWinningLottoList(List<Integer> countList, int bonusNumber);
    public void printYield();
}
