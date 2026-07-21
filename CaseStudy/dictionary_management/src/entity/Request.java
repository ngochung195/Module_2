package entity;

public class Request {

    private String command;

    private String keyword;

    public Request() {
    }

    public Request(String command, String keyword) {
        this.command = command;
        this.keyword = keyword;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return command + " " + keyword;
    }
}