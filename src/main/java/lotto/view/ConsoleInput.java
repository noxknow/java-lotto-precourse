package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.handler.InputHandler;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleInput implements InputHandler {

    @Override
    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return stringToInt(readLine());
    }

    @Override
    public String getWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLine();
    }

    @Override
    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return stringToInt(readLine());
    }

    private int stringToInt(String input) {
        return Integer.parseInt(input);
    }
}
