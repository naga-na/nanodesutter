package fx;

import java.net.URL;
import java.util.ResourceBundle;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;



import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller implements Initializable{
	@FXML private TextArea tweet;
	@FXML private Button requestTokenButton;
	@FXML private Button tweetButton;
	@FXML private Button nanodesuButton;
	@FXML private Button okButton;
	@FXML private TextField pin;
	@FXML private Label information;
	
	
	private Twitter twitter;
	private RequestToken requestToken;
	private AccessToken accessToken;
	private Status status;
	@FXML
	public void onRequestTokenButtonClicked(){
		
		try {
			requestToken = twitter.getOAuthRequestToken();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		information.setText("認証してきて上にコピーしてよね！");
		tweet.setText(requestToken.getAuthorizationURL());
	}
	
	@FXML
	public void onOkButtonClicked(){
		try {
			accessToken = twitter.getOAuthAccessToken(requestToken, pin.getText());
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		twitter.setOAuthAccessToken(accessToken);
		information.setText("認証に成功したのです！");
		tweet.setText("ついーとできるよ！");
	}
	
	@FXML
	public void onTweetButtonClicked(){
		try {
			status = twitter.updateStatus(tweet.getText());
			information.setText("ついーとしたよ");
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void onNanodesuButtonClicked(){
		StringBuffer sb = new StringBuffer(tweet.getText());
		try {
			status = twitter.updateStatus(sb.reverse().toString());
			information.setText("ほんきをみるのです！");
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		twitter = TwitterFactory.getSingleton();
		//twitter.setOAuthConsumer("RyFfiQhXHVygSRYP0lpJ4A", "GGxt8AB2muTNkbkRwnowINljDp3QyC7jwpqQMkOTg");
	
		information.setText("なのです！");
	}

}
