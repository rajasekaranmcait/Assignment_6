package com.example.client;
import java.util.Scanner;
import com.example.publisher.PublisherImpl;
import com.example.subscriber.Subscriber;
import com.example.subscriber.SubscriberImpl;
public class PublisherClient
{
	public static void main(String[] args) throws InterruptedException
	{
		// create publisher 
		PublisherImpl publisherImpl = new PublisherImpl();
        // create subscribers
		Subscriber Rajasekaran = new SubscriberImpl("Rajasekaran");
		Subscriber Ramadhas = new SubscriberImpl("Ramadhas");
		Subscriber Manoj = new SubscriberImpl("Manoj");
        // register subscribers to the publisher
		publisherImpl.registerSubscriber(Rajasekaran);
		publisherImpl.registerSubscriber(Ramadhas);
		publisherImpl.registerSubscriber(Manoj);
        // set subscriber to publisher
		Rajasekaran.setPublisher(publisherImpl);
		Ramadhas.setPublisher(publisherImpl);
		Manoj.setPublisher(publisherImpl);
        /*publisherImpl.unRegisterSubscriber(Manoj);
		  publisherImpl.unRegisterSubscriber(Ramadhas);*/
		
		// check if any update is available
		Rajasekaran.update();
		// Ramadhas.update();
		// Manoj.update();

		// Read message from the console
		System.out.println("Please enter the message to send: ");
		Scanner scanner = new Scanner(System.in);
		String message = scanner.nextLine();
		// now send message to subject
		publisherImpl.postMessage(message);
		scanner.close();
	}
}
