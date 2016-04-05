package com.example.publisher;
import com.example.subscriber.Subscriber;
//Interface for Publisher
public interface Publisher
{
    //Method used to send message to subscribers
	public void notifySubscribers() throws InterruptedException;
    // Method to register new subscribers
	public void registerSubscriber(Subscriber subscriber);
    // Method to un-register the subscriber
	public void unRegisterSubscriber(Subscriber subscriber);
    // Method to get notifications from Subscribers
	public Object getNotification(Subscriber subscriber);
}
