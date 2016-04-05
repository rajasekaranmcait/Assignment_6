package com.example.subscriber;
import java.util.Date;
import com.example.publisher.Publisher;
// Implementation class for Subscriber
public class SubscriberImpl implements Subscriber 
{
	private String name;
	private Publisher publisher;
	public SubscriberImpl(String name) 
	{
		this.name = name;
	}
	@Override
	public void update() 
	{
		String msg = (String) publisher.getNotification(this);
		if (msg != null) 
		{
			System.out.println(name + ": Received message : " + msg);
			System.out.println(name + ": Message received at : " + new Date());
		} 
	}
	@Override
	public void setPublisher(Publisher publisher)
	{
		this.publisher = publisher;
	}
}
