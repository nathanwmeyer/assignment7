package data;

import java.util.List;

import beans.Order;

public interface DataAccessInterface {
	public List<Order> findAll();//return all orders
	
	public Order findById(int id);//find order by its id
	
	public void create(Order order);//create and insert new order
	
	public void update(Order order, Order update);//update an existing order
	
	public void delete(Order order);//delete an existing order
}
