package javafxcontroller;

import java.io.IOError;
import java.io.IOException;

import controller.DictionaryController;
import entity.Definition;
import entity.Sentence;
import entity.Word;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {

    // =========================
    // Components
    // =========================

    @FXML
    private TextField txtSearch;

    @FXML
    private Label lblWord;

    @FXML
    private Label lblPronunciation;

    @FXML
    private TextArea txtContent;

    // =========================
    // Business Controller
    // =========================

    private final DictionaryController controller = new DictionaryController();

    public DictionaryController getController() {
        return controller;
    }

    // =========================
    // Events
    // =========================

    @FXML
    public void lookup() {
        String keyword = txtSearch.getText().trim();

        if (keyword.isEmpty()) {
            return;
        }

        Word word = controller.lookup(keyword);

        if (word == null) {
            lblWord.setText("Không tìm thấy!");
            lblPronunciation.setText("");
            txtContent.clear();
            return;
        }

        lblWord.setText(word.getWord());
        lblPronunciation.setText(word.getPronunciation());

        StringBuilder builder = new StringBuilder();

        for (Definition definition : word.getDefinitions()) {
            builder.append(definition.getType()).append("\n\n");

            builder.append("Nghĩa: \n");
            builder.append(definition.getMeaning()).append("\n\n");

            if (!definition.getSentences().isEmpty()) {
                builder.append("Ví dụ: \n");
                for (Sentence sentence : definition.getSentences()) {
                    builder.append(("• ")).append(sentence.getEnglish()).append("\n");

                    builder.append("  ").append(sentence.getVietnamese()).append("\n\n");
                }
            }
            builder.append("----------------------------------------\n\n");
        }

        txtContent.setText(builder.toString());
    }

    @FXML
    public void define() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/Define.fxml"));

            Parent root = loader.load();

            DefineController defineController = loader.getController();
            defineController.setController(controller);

            Stage stage = new Stage();
            stage.setTitle("Define");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void drop() {

    }

    @FXML
    public void export() {

    }

}