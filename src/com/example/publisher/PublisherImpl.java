package com.example.publisher;
import java.util.ArrayList;
import java.util.List;
import com.example.subscriber.Subscriber;
//Implementaion class for publisher interface 
public class PublisherImpl implements Publisher
{
	private List<Subscriber> subscribers;
	private String message;
	private boolean changed;
	private final Object MUTEX = new Object();
    // Public constructor
	public PublisherImpl() 
	{
		this.subscribers = new ArrayList<Subscriber>();
	}
	@Override
	public void registerSubscriber(Subscriber subscriber) 
	{
		if (subscriber == null)
			throw new NullPointerException("Not a valid Subcriber. Please provide a valid name");
		synchronized (MUTEX)
		{
			if (!subscribers.contains(subscriber))
				subscribers.add(subscriber);
		}
	}
	@Override
	public void unRegisterSubscriber(Subscriber subscriber)
	{
		synchronized (MUTEX) 
		{
			subscribers.remove(subscriber);
		}
	}
	@Override
	public void notifySubscribers() throws InterruptedException 
	{
		List<Subscriber> subscriberLocal = null;
		// synchronization is used to make sure any observer registered after
		// message is received is not notified
		synchronized (MUTEX) 
		{
			if (!changed)
				return;
			subscriberLocal = new ArrayList<>(this.subscribers);
			this.changed = false;
		}
		for (Subscriber subscriber : subscriberLocal)
		{
			Thread.sleep(3000);
			subscriber.update();
		}
	}
	@Override
	public Object getNotification(Subscriber subscriber)
	{
		return this.message;
	}
    //Method to post message to Subscribers
	public void postMessage(String message) throws InterruptedException
    {
		System.out.println("Message sent to Subscrbers: " + message);
		this.message = message;
		this.changed = true;
		notifySubscribers();
	}
}
