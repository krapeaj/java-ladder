package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.UserPrompt;

import java.util.Map;

public class Output {

    public static void askForPlayerNames() {
        System.out.println("참여할 사람 이름을 쉼표(,)를 기준으로 입력하세요:");
    }

    public static void askForPrizes() {
        System.out.println("실행 결과를 입력하세요:");
    }

    public static void askForLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
    }

    public static void printNotEnoughNames() {
        System.out.print("최소 두명의 이름을 입력해주세요. ");
    }

    public static void printNotEqualNumbers() {
        System.out.print("참여자 수와 결과 수가 맞지 않습니다. ");
    }

    public static void printOverMaxChars() {
        System.out.print("이름은 최대 다섯 자 이하로 입력해주세요. ");
    }

    public static void printUnderMinHeight() {
        System.out.print("2보다 큰 숫자를 입력해주세요. ");
    }

    public static void printLadder(LadderGame game) {
        String ladder = game.startConversion();
        System.out.println(ladder);
    }

    public static void askForResultName() {
        System.out.println("결과를 보고 싶은 사람의 이름을 입력해주세요 (모두 보고 싶으면 'all'을 입력):");
    }

    public static void printMoreThanOneName() {
        System.out.println("한명의 이름만 입력해주세요.");
    }

    public static void printNameDoesNotExist(String name) {
        System.out.println(name + " 이란 이름은 게임에 참여하지 않았습니다.");
    }

    public static void printSelectedResult(Map<String, String> result, String name) {
        if (!UserPrompt.isExit(name)){
            System.out.println(name + ": " + result.get(name));
        }
    }

    public static void printAllResult(Map<String, String> result) {
        for (Map.Entry<String, String> set : result.entrySet()) {
            System.out.println(set.getKey() + ": " + set.getValue());
        }
    }
}