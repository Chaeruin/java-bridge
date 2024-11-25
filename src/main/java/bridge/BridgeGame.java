package bridge;

import java.util.LinkedList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(List<String> madeBridge, String upOrDown, int idx) {
        String order = madeBridge.get(idx);
        if (order.equals(upOrDown)) {
            return "O";
        }
        return "X";
    }

    /**
     * @param upOrDown - 이동 하려고 했던 방향 U/D
     * @param move     - 이동 결과 O인지 X인지
     * @return 결과 브릿지 [0][] - 위 / [1][] - 아래
     */
    public List<List<String>> movingResult(List<List<String>> movingStatus, String upOrDown, String move) {
        if (upOrDown.equals("U")) {
            movingStatus.get(0).add(move);
            movingStatus.get(1).add(" ");
        } else if (upOrDown.equals("D")) {
            movingStatus.get(0).add(" ");
            movingStatus.get(1).add(move);
        }
        return movingStatus;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry(List<List<String>> movingStatus, int cnt) {
        // 빈 status 배열로 초기화
        movingStatus = new LinkedList<>();
        return cnt++;
    }

    public String isSucessOrFail(List<List<String>> movingStatus) {
        if (movingStatus.get(0).contains("X") || movingStatus.get(1).contains("X")) {
            return "실패";
        }
        return "성공";
    }

}
