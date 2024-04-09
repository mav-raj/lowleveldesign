package NotifyMe.User;

import java.util.ArrayList;
import java.util.List;

import NotifyMe.NotificationStrategy.EmailNotification;
import NotifyMe.NotificationStrategy.NotificationStrategy;
import NotifyMe.NotificationStrategy.SmsNotification;

public class User {
	private String name;
	private String email;
	private String mobile;
	private List<NotificationStrategy> notificationStrategies;

	public User(String name, String email, String mobile) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.notificationStrategies = new ArrayList<>();
		this.notificationStrategies.add(new EmailNotification());
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public String getName() {
		return name;
	}
	
	public void optInNotifications(NotificationStrategy strategy) {
		if(!notificationStrategies.contains(strategy)) {
			notificationStrategies.add(strategy);
		}
	}

	public void sendNotification(String message) {
		for(NotificationStrategy strategy: notificationStrategies) {
			if(strategy instanceof EmailNotification) {
				strategy.pushNotification(this.email, message);
			}
			if(strategy instanceof SmsNotification) {
				strategy.pushNotification(this.mobile, message);
			}
		}
	}
	

}
