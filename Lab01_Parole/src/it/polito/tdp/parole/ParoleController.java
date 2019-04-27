package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco ;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtPerformance"
    private TextArea txtPerformance; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnDelete"
    private Button btnDelete; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML
    void doInsert(ActionEvent event) {
    	txtResult.clear();
    	
    	String parola = txtParola.getText().toLowerCase().trim();
    	
    	if(txtParola.getText().length()==0) {
    		txtResult.appendText("Inserire una parola \n");
    		return;
    		}else {
    			
    			double start = System.nanoTime();
		    	elenco.addParola(parola);
		    	double stop = System.nanoTime();
		    	
		    	for (String p : elenco.getElenco()) {
					this.txtResult.appendText(p+"\n");
					}
		    	
		    	this.txtPerformance.setText("[INSERT]: "+(stop-start)/(1000*1000) + " secondi");

		    	}
    	
    	this.txtParola.clear();
    }
    
    @FXML
    void doDelete(ActionEvent event) {

    	txtResult.clear();
    	
    	String parola = txtParola.getText().toLowerCase().trim();

    	if(txtParola.getText().length()==0) {
    		txtResult.appendText("Inserire una parola \n");
    		return;
    		}else {
    	elenco.addParola(parola);
    	
		double start = System.nanoTime();
    	boolean isDeleted = elenco.delete(parola);
    	double stop = System.nanoTime();
    	

    	if(isDeleted==true) {
    	
	    	for (String p : elenco.getElenco()) {
				this.txtResult.appendText(p+"\n");
			}
	    	this.txtPerformance.setText("[REMOVE]: "+(stop-start)/(1000*1000) + " secondi");
    	
    	}
    	
    	if(isDeleted==false)
				txtResult.setText("parola non eliminata perchè non presente");
	    	
    	
	    	this.txtParola.clear();
    	}
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	this.txtResult.clear();
    	this.txtParola.clear();
    	txtPerformance.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtPerformance != null : "fx:id=\"txtPerformance\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Parole.fxml'.";


        elenco = new Parole() ;
        
    }
}
