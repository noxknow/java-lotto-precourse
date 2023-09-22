package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<Lotto> getLottoNumbers(int count) {

        List<Lotto> buyLottoLists = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> buyLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            buyLottoLists.add(new Lotto(buyLottoNumbers));
        }

        return buyLottoLists;
    }
}
