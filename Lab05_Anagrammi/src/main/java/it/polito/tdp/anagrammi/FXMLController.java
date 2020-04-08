package it.polito.tdp.anagrammi;

import java.util.*;
import java.net.URL;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Model model;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button bttCalcola;

    @FXML
    private TextArea txtCorrette;

    @FXML
    private TextArea txtErrate;

    @FXML
    private Button bttReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	
    	this.txtCorrette.clear();
    	this.txtErrate.clear();
    	String parola = this.txtParola.getText();
    	
    	List<String> soluzione= this.model.anagrammi(parola); 

    	for(String s: soluzione) {
    		if(this.model.esisteNelDizionario(s))
    		txtCorrette.appendText(s+"\n");
    		else 
    			txtErrate.appendText(s+"\n");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtParola.clear();
    	this.txtCorrette.clear();
    	this.txtErrate.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert bttCalcola != null : "fx:id=\"bttCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorrette != null : "fx:id=\"txtCorrette\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrate != null : "fx:id=\"txtErrate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert bttReset != null : "fx:id=\"bttReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
		this.model = model;
	}
}
