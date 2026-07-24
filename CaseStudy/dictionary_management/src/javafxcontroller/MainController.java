package javafxcontroller;

import java.io.IOError;
import java.io.IOException;
import java.util.Optional;

import controller.DictionaryController;
import entity.Definition;
import entity.Sentence;
import entity.Word;
import factory.HandlerFactory;
import handler.DefineHandler;
import handler.DropHandler;
import handler.ExportHandler;
import handler.LookupHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
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

    private final DictionaryController controller = new DictionaryController();

    private HandlerFactory handlerFactory;

    // =========================
    // Business Controller
    // =========================
    public DictionaryController getController() {
        return controller;
    }

    // =========================
    // Events
    // =========================

    @FXML
    public void lookup() {
        handlerFactory.getHandler("lookup").execute();
    }

    public void doLookup() {
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

            builder.append("Nghĩa: ");
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
        handlerFactory.getHandler("define").execute();
    }

    public void doDefine() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/resources/fxml/Define.fxml"));

            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Thêm từ mới");

            stage.setScene(new Scene(root));

            stage.initModality(Modality.APPLICATION_MODAL);

            stage.setResizable(false);

            stage.showAndWait();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @FXML
    public void drop() {
        handlerFactory.getHandler("drop").execute();
    }

    public void doDrop() {

        String keyword = lblWord.getText();

        if (keyword == null
                || keyword.isBlank()
                || keyword.equals("...")
                || keyword.equals("Không tìm thấy!")) {

            Alert alert = new Alert(Alert.AlertType.WARNING);

            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng tra cứu từ cần xóa.");

            alert.showAndWait();

            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);

        confirm.setTitle("Xác nhận");
        confirm.setHeaderText(null);
        confirm.setContentText("Bạn có chắc muốn xóa từ \"" + keyword + "\"?");

        Optional<ButtonType> result = confirm.showAndWait();

        if (result.isPresent()
                && result.get() == ButtonType.OK) {

            boolean success = controller.drop(keyword);

            if (success) {

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);

                successAlert.setTitle("Thông báo");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Đã xóa từ thành công.");

                successAlert.showAndWait();

                clearDisplay();

            } else {

                Alert error = new Alert(Alert.AlertType.ERROR);

                error.setTitle("Lỗi");
                error.setHeaderText(null);
                error.setContentText("Không thể xóa từ.");

                error.showAndWait();

            }

        }

    }

    @FXML
    public void export() {
        handlerFactory.getHandler("export").execute();
    }

    public void doExport() {
        controller.export();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText("Xuất dữ liệu thành công!");

        alert.showAndWait();
    }

    private void clearDisplay() {

        txtSearch.clear();

        lblWord.setText("...");
        lblPronunciation.setText("...");

        txtContent.clear();
    }

    @FXML
    public void initialize() {

        handlerFactory = new HandlerFactory();

        handlerFactory.register(
                "lookup",
                new LookupHandler(this));

        handlerFactory.register(
                "define",
                new DefineHandler(this));

        handlerFactory.register(
                "drop",
                new DropHandler(this));

        handlerFactory.register(
                "export",
                new ExportHandler(this));

    }
}