package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoJudge;
import lotto.handler.LottoHandler;
import lotto.repository.ListRepository;
import lotto.repository.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {

    public List<Lotto> getLottoNumbers(int count, Repository repository) {
        List<Lotto> buyLottoLists = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .collect(Collectors.toList());

        repository.saveBuyLottoLists(buyLottoLists);

        return buyLottoLists;
    }

    private List<Integer> compareLotto(List<Lotto> buyLottoLists, List<Integer> winningLotto) {
        List<Integer> countList = buyLottoLists.stream()
                .map(Lotto::sortLottoNumbers)
                .map(lottoNumbers -> (int) lottoNumbers.stream()
                        .filter(winningLotto::contains)
                        .count())
                .collect(Collectors.toList());

        return countList;
    }

    public void calculateMatchingCount(Repository repository, List<Lotto> buyLottoLists, List<Integer> winningLotto, int bonusNumber) {
        List<Integer> countList = compareLotto(buyLottoLists, winningLotto);

        for (int i = 0; i < countList.size(); i++) {
            List<Integer> sortedNumbers = buyLottoLists.get(i).sortLottoNumbers();
            LottoJudge lottoJudge = new LottoJudge(sortedNumbers, winningLotto, bonusNumber);

            LottoHandler lottoHandler = lottoJudge.matchLottoHandler(countList.get(i));
            repository.saveWinningLottoList(lottoHandler);
        }
    }
}
