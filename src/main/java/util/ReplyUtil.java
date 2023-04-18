package main.java.util;

public class ReplyUtil {
    private static ReplyUtil replyUtil;

    private final String backString = "0";
    private final int backInt = 0;

    public static ReplyUtil getInstance() {
        if (replyUtil == null) {
            replyUtil = new ReplyUtil();
        }
        return replyUtil;
    }

    public boolean checkIsYes (String string) {
        return string.equals("y") || string.equals("예");
    }

    public boolean checkIsNo (String string) {
        return string.equals("n") || string.equals("아니오");
    }

    public boolean isBack (String value) {
        return value.equals(backString);
    }

    public boolean isBack (int value) {
        return value == backInt;
    }

    public String getBackString () {
        return backString;
    }

    public int getBackInt() {
        return backInt;
    }
}
