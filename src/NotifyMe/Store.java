package NotifyMe;


// import NotifyMe.NotificationStrategy.EmailNotification;
import NotifyMe.NotificationStrategy.SmsNotification;
import NotifyMe.Products.Iphone;
import NotifyMe.User.User;

public class Store {

	public static void setTimeout(Runnable runnable, int delay) {
		new Thread(() -> {
			try {
				Thread.sleep(delay);
				runnable.run();
			} catch (Exception e) {
				System.err.println(e);
			}
		}).start();
	}

	public static void main(String[] args) {
			// Store store = new Store();
			// EmailNotification email = new EmailNotification();
			SmsNotification sms = new SmsNotification();
			User us1 = new User("John", "a@b.com", "999999999");
			User us2 = new User("Sam", "s@b.com", "999999991");
			User us3 = new User("Nick", "n@b.com", "999999992");
			us2.optInNotifications(sms);
			us3.optInNotifications(sms);
			us1.optInNotifications(sms);

			Iphone iphone = new Iphone("145343");
			iphone.subscribe(us1);
			iphone.subscribe(us2);
			// iphone.subscribe(us1);

			setTimeout(() -> {iphone.setStockCount(10);}, 2000);
			setTimeout(() -> {iphone.setStockCount(10);}, 4000);
			setTimeout(() -> {iphone.setStockCount(0);}, 6000);
			setTimeout(() -> {iphone.setStockCount(10);}, 8000);
	}	
}
