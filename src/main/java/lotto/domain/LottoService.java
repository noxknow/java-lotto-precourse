package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {

    public List<Lotto> getLottoNumbers(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .collect(Collectors.toList());
    }

    public List<Integer> compareLotto(List<Lotto> buyLottoLists, List<Integer> winningLotto) {
        List<Integer> countList = buyLottoLists.stream()
                .map(Lotto::sortLottoNumbers)
                .map(lottoNumbers -> (int) lottoNumbers.stream()
                        .filter(winningLotto::contains)
                        .count())
                .collect(Collectors.toList());

        return countList;
    }
}
