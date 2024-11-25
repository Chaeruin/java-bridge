package bridge.utils;

import bridge.enums.ErrorMessage;

public class InputValidator {
    public static boolean isStringOrNone(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ISNOT_INT.getErrorMessage());
        }
        return true;
    }

    public static boolean isInRange(int input) {
        if (input < 3 || input > 20) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getErrorMessage());
        }
        return true;
    }

    public static boolean isUOrD(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_STRING.getErrorMessage());
        }
        return true;
    }

    public static boolean isROrQ(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_STRING.getErrorMessage());
        }
        return true;
    }

}
