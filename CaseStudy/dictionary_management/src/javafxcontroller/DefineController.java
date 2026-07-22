package javafxcontroller;

import controller.DictionaryController;
import entity.Word;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DefineController {

    @FXML
    private TextField txtWord;

    @FXML
    private TextField txtPronunciation;

    @FXML
    private TextField txtType;

    @FXML
    private TextArea txtMeaning;

    @FXML
    private TextArea txtExample;

    private DictionaryController controller;

    public void setController(DictionaryController controller) {
        this.controller = controller;
    }

    @FXML
    public void save() {

        Word word = new Word();

        word.setWord(txtWord.getText().trim());
        word.setPronunciation(txtPronunciation.getText().trim());

        // Phần Definition sẽ bổ sung sau
        // controller.define(word);

        close();
    }

    @FXML
    public void cancel() {
        close();
    }

    private void close() {
        Stage stage = (Stage) txtWord.getScene().getWindow();
        stage.close();
    }
}