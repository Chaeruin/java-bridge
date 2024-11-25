package bridge.controller;

import bridge.BridgeMaker;
import bridge.utils.InputParser;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        outputView.printStart();

        // restart 해도 유지
        List<String> madeBridge = bridgeMaker.makeBridge(inputSizeHandler());

        while (true) {
            String upOrDown = inputUpDownHandler();

            if (inputRestartOrQuitHandler().equals("Q")) { // 조건 :: 이동칸이 X 나타난거 추가
                break;
            }
        }
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


