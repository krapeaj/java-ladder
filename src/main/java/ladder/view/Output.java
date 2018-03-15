package ladder.view;

import ladder.domain.LadderDTO;

public class Output {

    public static void askForPlayerNames() {
        System.out.println("참여할 사람 이름을 쉼표(,)를 기준으로 입력하세요:");
    }

    public static void askForPrizes(){
        System.out.println("실행 결과를 입력하세요:");
    }

    public static void askForLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
    }

    public static void printNotEnoughNames() {
        System.out.print("최소 두명의 이름을 입력해주세요. ");
    }

    public static void printOverMaxChars() {
        System.out.print("이름은 최대 다섯 자 이하로 입력해주세요. ");
    }

    public static void printUnderMinHeight() {
        System.out.print("2보다 큰 숫자를 입력해주세요. ");
    }

    public static void printLadder(LadderDTO dto) {
        System.out.println(dto.getBuilder().toString());
    }
}