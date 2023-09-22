package lotto.view;

import lotto.handler.InputHandler;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.handler.ErrorHandler.INCONVERTIBLE_TYPE;
import static lotto.handler.ErrorHandler.INVALID_PARSING_INPUT;

public class ConsoleInput implements InputHandler {

    @Override
    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return stringToInt(readLine());
    }

    @Override
    public List<Integer> getWinningLotto() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        return stringToList(readLine());
    }

    @Override
    public int getBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        return stringToInt(readLine());
    }

    private List<Integer> stringToList(String inputs) {

        List<Integer> winningNumbers = new ArrayList<>();

        try {
            String[] inputNumbers = inputs.split(",");
            for (String number : inputNumbers) {
                try {
                    winningNumbers.add(Integer.valueOf(number));
                } catch (IllegalArgumentException e) {
                    throw INCONVERTIBLE_TYPE.getException();
                }
            }
        } catch (Exception e) {
            throw INVALID_PARSING_INPUT.getException();
        }

        return winningNumbers;
    }

    private int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw INCONVERTIBLE_TYPE.getException();
        }
    }
}
