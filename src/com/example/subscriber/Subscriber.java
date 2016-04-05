package com.example.subscriber;
import com.example.publisher.Publisher;
//Interface for Subscriber
public interface Subscriber 
{
    // Send notification to Publisher
	public void update();
    // set publisher
	public void setPublisher(Publisher publisher);
}
