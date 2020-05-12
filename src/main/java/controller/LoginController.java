package controller;

import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfoenix.controls.JFXSpinner;

import AppClient.service.AppHttpClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

public class LoginController {

	@FXML
	private TextField usernameField;

	@FXML
	private PasswordField passwordField;

	@FXML
	private Button connectButton;
	
	@FXML
	private JFXSpinner spinner;

	@FXML
	protected void handleSubmitButtonAction(ActionEvent event) {

		if (this.usernameField.getText().isEmpty() || this.passwordField.getText().isEmpty()) {
			return;
		}
		
		this.connectButton.setVisible(false);
		this.spinner.setVisible(true);

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			params.put("username", this.usernameField.getText());
			params.put("password", this.passwordField.getText());
			String parse = new ObjectMapper().writeValueAsString(params);
			if((new AppHttpClient().postJson(parse)) == 200)
			{
				System.out.println("Authenticated.");
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}
}
