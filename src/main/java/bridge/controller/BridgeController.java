package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.utils.InputParser;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.LinkedList;
import java.util.List;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    public BridgeController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker,
                            BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
        this.bridgeGame = bridgeGame;
    }

    static int cnt = 1, idx = 0, size;
    static List<List<String>> movingStatus;

    public void run() {
        outputView.printStart();
        // restart 해도 유지
        List<String> madeBridge = bridgeMaker.makeBridge(size = inputSizeHandler());

        movingStatus = initMovingStatus();

        while (true) {
            String upOrDown = inputUpDownHandler();
            movingStatus = bridgeGame.movingResult(movingStatus, upOrDown,
                    bridgeGame.move(madeBridge, upOrDown, idx++));

            // 출력
            outputView.printMap(movingStatus);
            outputView.printEnter();

            if (restartOrQuitNow()) {
                break;
            } else if (idx == size && bridgeGame.isSucessOrFail(movingStatus).equals("성공")) {
                break;
            }
        }

        outputView.printResult(movingStatus, cnt, bridgeGame.isSucessOrFail(movingStatus));
    }

    public boolean restartOrQuitNow() {
        if (bridgeGame.isSucessOrFail(movingStatus).equals("실패")) {
            String restartOrQuit = inputRestartOrQuitHandler();
            if (restartOrQuit.equals("R")) {
                cnt = bridgeGame.retry(cnt);
                idx = 0;
                movingStatus = initMovingStatus();
                return false;
            } else if (restartOrQuit.equals("Q")) {
                return true;
            }
        }
        return false;
    }

    public List<List<String>> initMovingStatus() {
        List<List<String>> movingStatus = new LinkedList<>();
        movingStatus.add(new LinkedList<>());
        movingStatus.add(new LinkedList<>());
        return movingStatus;
    }

    public int inputSizeHandler() {
        int size = 0;
        while (size == 0) {
            try {
                size = InputParser.getBridgeSize(inputView.readBridgeSize());
                return size;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return size;
    }

    public String inputUpDownHandler() {
        String upDown = null;
        while (upDown == null) {
            try {
                upDown = InputParser.getMoveStr(inputView.readMoving());
                return upDown;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return upDown;
    }

    public String inputRestartOrQuitHandler() {
        String restartQuit = null;
        while (restartQuit == null) {
            try {
                restartQuit = InputParser.getRestartOrNot(inputView.readGameCommand());
                return restartQuit;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return restartQuit;
    }
}


