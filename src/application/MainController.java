package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public class MainController 
{
	public static final String ACCOUNT_SID = "XXX"; //visit www.twilio.com
    public static final String AUTH_TOKEN = "XXX";  //visit www.twilio.com

    @FXML
    private JFXTextArea txtMessage;

    @FXML
    private JFXButton btnSend;

    Alert a ;
    
    @FXML
    void sendSMS(ActionEvent event) {
    	try {
    	
    		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    		 Message message = Message
    	                .creator(new PhoneNumber("+91XXXXXXXXXX"), // to
    	                        new PhoneNumber("+1XXXXXXXXXX"), // from
    	                        txtMessage.getText().toString())
    	                .create();
    		
    		
    		a = new Alert(AlertType.CONFIRMATION);
    		a.setTitle("Sucess");
        	a.setHeaderText("");
        	a.setContentText("SMS Send Sucessfully");
        	
			 a.show();
			 //System.out.println(message.getSid());
	    }
	catch(Exception e) 
	{
		a = new Alert(AlertType.ERROR);
		a.setTitle("Failed");
    	a.setHeaderText("");
    	a.setContentText("Something went wrong:"+e.toString());
		e.printStackTrace();
		a.show();
	}
}
}