package lotto.handler;

import lotto.domain.Lotto;
import lotto.repository.Repository;

import java.util.List;

public interface OutputHandler {

    public void printBuyLottoList(int count, Repository repository);
    public void printWinningLottoList(Repository repository);
    public void printYield(int count, Repository repository);
}
