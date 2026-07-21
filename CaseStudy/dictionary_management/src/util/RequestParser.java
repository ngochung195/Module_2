package util;

import entity.Request;

public class RequestParser {
    public Request parser(String input) {
        input = input.trim();

        String[] data = input.split("\\s+");

        Request request = new Request();

        if (data.length > 0) {
            request.setCommand(data[0]);
        }

        if (data.length > 1) {
            request.setKeyword(data[1]);
        }

        return request;
    }
}
