package MovieBookingSystem.Controller;

import java.util.List;

public abstract class Controller<T> {

	public abstract List<T> getAll();

	public abstract T setItem(T t);

	public abstract T updateItem(T t);
}
