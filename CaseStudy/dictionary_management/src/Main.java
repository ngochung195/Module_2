import controller.DictionaryController;
import entity.Word;
import service.DictionaryService;

public class Main {
    public static void main(String[] args) {
        DictionaryService service = DictionaryService.getInstance();

        Word apple = new Word("apple", "ˈæpl");
        Word banana = new Word("banana", "bəˈnɑːnə");
        Word cat = new Word("cat", "kæt");

        service.define(apple);
        service.define(banana);
        service.define(cat);

        DictionaryController controller = new DictionaryController();

        controller.execute("lookup apple");

        controller.execute("drop banana");

        controller.execute("lookup banana");

        controller.execute("export");
    }
}