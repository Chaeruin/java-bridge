package bridge.utils;

public class InputParser {
    public static int getBridgeSize(String input) {
        int integerInput = 0;
        if (InputValidator.isStringOrNone(input)) {
            integerInput = Integer.parseInt(input);
        }
        if (InputValidator.isInRange(integerInput)) {
            return integerInput;
        }
        return integerInput;
    }

    public static String getMoveStr(String input) {
        if (InputValidator.isUOrD(input)) {
            return input;
        }
        return null;
    }

    public static String getRestartOrNot(String input) {
        if (InputValidator.isROrQ(input)) {
            return input;
        }
        return null;
    }
}
