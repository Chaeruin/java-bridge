package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printEnter() {
        System.out.println();
    }

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> bridgeStatus) {
        printLoopMap(bridgeStatus, 0);
        printLoopMap(bridgeStatus, 1);
    }

    public void printLoopMap(List<List<String>> bridgeStatus, int getI) {
        System.out.print("[ ");
        for (int i = 0; i < bridgeStatus.get(getI).size(); i++) {
            System.out.print(bridgeStatus.get(getI).get(i));
            if (i != bridgeStatus.get(getI).size() - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> bridgeResult, int cnt, String result) {
        System.out.println("최종 게임 결과");
        printMap(bridgeResult);
        printEnter();
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + cnt);
    }
}
