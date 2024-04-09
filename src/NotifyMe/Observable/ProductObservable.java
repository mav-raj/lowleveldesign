package NotifyMe.Observable;

import NotifyMe.User.User;

public interface ProductObservable {
	void subscribe(User user);
	void unSubscribe(User user);
	void notifyObservers();
	void setStockCount(int count);
}
