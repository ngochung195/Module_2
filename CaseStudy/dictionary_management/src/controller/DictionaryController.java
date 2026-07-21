package controller;

import entity.Request;
import entity.Word;
import service.DictionaryService;
import util.RequestParser;

public class DictionaryController {
    private final DictionaryService service;
    private final RequestParser parser;

    public DictionaryController() {
        service = DictionaryService.getInstance();
        parser = new RequestParser();
    }

    public void execute(String input) {
        Request request = parser.parser(input);

        switch (request.getCommand()) {
            case "lookup":
                System.out.println(service.lookup(request.getKeyword()));
                break;
            case "define":
                // Tạm thời tạo Word chỉ với keyword
                // Sau này sẽ bổ sung nghĩa, phát âm,...
                service.define(new Word(request.getKeyword(), ""));
                System.out.println("Define success.");
                break;
            case "drop":
                System.out.println(service.drop(request.getKeyword()));
                break;
            case "export":
                service.export();
                break;

            case "load":
                service.load();
                break;

            case "save":
                service.save();
                break;
            default:
                System.out.println("Unknown command.");
        }
    }
}
