package NotifyMe.NotificationStrategy;

public class EmailNotification implements NotificationStrategy {

	@Override
	public void pushNotification(String email, String message) {
		System.out.println("Email sent to " + email + " : " + message);
	}
	
}
