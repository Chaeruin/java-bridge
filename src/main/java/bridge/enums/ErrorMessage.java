package bridge.enums;

public enum ErrorMessage {
    INVALID_ISNOT_INT("[ERROR] 문자는 입력할 수 없습니다."),
    INVALID_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_INPUT_STRING("[ERROR] 유효하지 않은 문자 입력입니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
