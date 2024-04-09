package NotifyMe.Products;

import java.util.*;
import NotifyMe.Observable.ProductObservable;
import NotifyMe.User.User;

public class Iphone implements ProductObservable {
	private String id;
	private int stockCount;
	Set<User> observers;

	public Iphone(String id) {
		this.id = id;
		this.stockCount = 0;
		this.observers = new HashSet<>();
	}

	public String getId() {
		return id;
	}
	public int getStockCount() {
		return stockCount;
	}

	@Override
	public void subscribe(User user) {
		observers.add(user);	
	}

	@Override
	public void unSubscribe(User user) {
		observers.remove(user);
	}

	@Override
	public void notifyObservers() {
		for(User u: observers) {
			u.sendNotification("Iphone is back in stock !!! Hurry up.");
		}
	}

	@Override
	public void setStockCount(int count) {
		if(this.stockCount == 0) {
			notifyObservers();
		}
		this.stockCount = count;
		System.out.println("Stock Updated by: " + count + " Total stock : " + this.stockCount);
	}

	
	
}
