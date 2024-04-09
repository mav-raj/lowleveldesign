package NotifyMe.NotificationStrategy;

public class SmsNotification implements NotificationStrategy {
	
	@Override
	public void pushNotification(String mobile, String message) {
		System.out.println("Sms sent to " + mobile + " : " + message);
	}
}
