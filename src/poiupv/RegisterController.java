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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
    @FXML
    private PasswordField contrasena;
    @FXML
    private PasswordField contrasenaRepetida;
    @FXML
    private DatePicker selectionFecha;
    @FXML
    private Label Nombrexiste;
    @FXML
    private Label ErrContrasenaNoIguales;
    @FXML
    private Label ContrasenErr;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateAvatar();
        contrasena.textProperty().addListener((observable, oldValue, newValue) -> validarContrasenas());
        contrasenaRepetida.textProperty().addListener((observable, oldValue, newValue) -> validarContrasenas());
}    
    private final List<String> avatarPaths = List.of(
        "/poiupv/avatars/avatar1.jpg",
        "/poiupv/avatars/avatar2.jpg",
        "/poiupv/avatars/avatar3.jpg"
        );
    private void updateAvatar() {
        
        String path = avatarPaths.get(currentIndex);
        var stream = getClass().getResourceAsStream(path);
        if (stream == null) {
            
            System.err.println("No se pudo cargar el avatar: " + path);
            return;
            
        }
        Image image = new Image(stream);
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
   

    @FXML
    private void onSelectionFecha(ActionEvent event) {
    }
    
    
    private void validarContrasenas() {
    String password = contrasena.getText();

    // Verificar si las contraseñas coinciden
    if (!password.equals(contrasenaRepetida.getText())) {
        ErrContrasenaNoIguales.setVisible(true);
    } else {
        ErrContrasenaNoIguales.setVisible(false); 
    }

    // Validar longitud de la contraseña (entre 8 y 20 caracteres)
    if (password.length() < 8 || password.length() > 20) {
        ContrasenErr.setVisible(true);
        ContrasenErr.setText("Debe ser entre 8 y 20 caracteres");
    }
    // Validar que tenga al menos una mayúscula
    else if (!password.matches(".*[A-Z].*")) {
        ContrasenErr.setVisible(true);
        ContrasenErr.setText("Debe contener al menos una mayúscula.");
    }
    // Validar que tenga al menos una minúscula
    else if (!password.matches(".*[a-z].*")) {
        ContrasenErr.setVisible(true);
        ContrasenErr.setText("Debe contener al menos una minúscula.");
    }
    // Validar que tenga al menos un carácter especial
    else if (!password.matches(".*[!@#$%&*()\\-+=].*")) {
        ContrasenErr.setVisible(true);
        ContrasenErr.setText("Debe incluir un carácter especial.");
    } 
    else {
        ContrasenErr.setVisible(false);
    }
    }
}

    

