package javafxcontroller;

import controller.DictionaryController;
import entity.Definition;
import entity.DefinitionType;
import entity.Sentence;
import entity.Word;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class DefineController {
    private final DictionaryController controller = new DictionaryController();

    // =========================
    // Components
    // =========================

    @FXML
    private TextField txtWord;

    @FXML
    private TextField txtPronunciation;

    @FXML
    private ComboBox<DefinitionType> cbType;

    @FXML
    private TextArea txtMeaning;

    @FXML
    private TextArea txtEnglish;

    @FXML
    private TextArea txtVietnamese;

    // =========================
    // Initialize
    // =========================

    @FXML
    public void initialize() {

        cbType.getItems().addAll(DefinitionType.values());

        cbType.setConverter(new StringConverter<DefinitionType>() {

            @Override
            public String toString(DefinitionType type) {

                if (type == null) {
                    return "";
                }

                return switch (type) {

                    case NOUN -> "Danh từ";
                    case VERB -> "Động từ";
                    case ADJECTIVE -> "Tính từ";
                    case ADVERB -> "Trạng từ";

                };

            }

            @Override
            public DefinitionType fromString(String string) {
                return null;
            }

        });

        cbType.getSelectionModel().selectFirst();

    }

    // =========================
    // Events
    // =========================

    @FXML
    public void save() {
        String wordText = txtWord.getText().trim();
        String pronunciation = txtPronunciation.getText().trim();
        String meaning = txtMeaning.getText().trim();
        String english = txtEnglish.getText().trim();
        String vietnamese = txtVietnamese.getText().trim();

        if (wordText.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thiếu thông tin");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập từ tiếng Anh.");
            alert.showAndWait();

            txtWord.requestFocus();
            return;
        }

        if (pronunciation.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thiếu thông tin");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập phiên âm.");
            alert.showAndWait();

            txtPronunciation.requestFocus();
            return;
        }

        if (meaning.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thiếu thông tin");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập nghĩa của từ.");
            alert.showAndWait();

            txtMeaning.requestFocus();
            return;
        }

        Word word = new Word(wordText, pronunciation);

        Definition definition = new Definition();
        definition.setMeaning(meaning);
        definition.setType(cbType.getValue());

        if (!english.isEmpty() || !vietnamese.isEmpty()) {
            Sentence sentence = new Sentence(english, vietnamese);
            definition.addSentence(sentence);
        }

        word.addDefinition(definition);

        boolean success = controller.define(word);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if (success) {

            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Thêm từ thành công!");

            alert.showAndWait();

            cancel();

        } else {

            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Từ đã tồn tại!");

            alert.showAndWait();

        }
    }

    @FXML
    public void cancel() {

        Stage stage = (Stage) txtWord.getScene().getWindow();
        stage.close();

    }

}