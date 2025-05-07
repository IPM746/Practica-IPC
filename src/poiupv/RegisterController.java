/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package poiupv;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author ikeru
 */
public class RegisterController implements Initializable {

    @FXML
    private Hyperlink Hyperselection;
    @FXML
    private ImageView imageView;
    @FXML
    private Button BotonAnterior;
    @FXML
    private Button BotonSiguiente;

    /**
     * Initializes the controller class.
     */
    private int currentIndex = 0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateAvatar();
    }    
    private final List<String> avatarPaths = List.of(
        "/avatars/avatar1.png",
        "/avatars/avatar2.png",
        "/avatars/avatar3.png"
    );
    private void updateAvatar() {
        Image image = new Image(getClass().getResourceAsStream(avatarPaths.get(currentIndex)));
        imageView.setImage(image);
    }
    @FXML
    private void Selectioncomputer(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Selecciona una imagen");
    fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg", "*.gif")
    );

    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }
}

    @FXML
    private void Anterioravatar(ActionEvent event) {
        currentIndex = (currentIndex - 1 + avatarPaths.size()) % avatarPaths.size();
        updateAvatar();
    }

    @FXML
    private void Siguienteavatar(ActionEvent event) {
        currentIndex = (currentIndex + 1) % avatarPaths.size();
        updateAvatar();
    }
    }
    

