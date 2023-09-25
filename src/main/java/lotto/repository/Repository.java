package lotto.repository;

import lotto.domain.Lotto;

import java.util.List;

public interface Repository {

    void saveBuyLottoLists(List<Lotto> buyLottoLists);
    void showBuyLottoLists();
}
