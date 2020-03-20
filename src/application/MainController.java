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
	public static final String ACCOUNT_SID = "ACf00475e29742afc5ce82a2a275871485";
    public static final String AUTH_TOKEN = "a0ec73496ae548ae5c2b4552e59fca16";

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
    	                .creator(new PhoneNumber("+917043255704"), // to
    	                        new PhoneNumber("+12038725652"), // from
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
