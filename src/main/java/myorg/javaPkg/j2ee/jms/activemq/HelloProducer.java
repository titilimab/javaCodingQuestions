package myorg.javaPkg.j2ee.jms.activemq;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloProducer {
	
	public static void main(String args[]) {
		
		try {
			
			//Set the properties for ActiveMQ
			Properties env = new Properties();
			env.put(Context.SECURITY_PRINCIPAL, "admin");
			env.put(Context.SECURITY_CREDENTIALS, "admin");
			env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
			env.put(Context.PROVIDER_URL, "tcp://Name-PC:61616");
			
			//Create the Initial Context object
			InitialContext jndi = new InitialContext(env);
				
			//Create connection Factory
			QueueConnectionFactory connectionFactory =  (QueueConnectionFactory)jndi.lookup("QueueConnectionFactory");
			//ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://Name-PC:61616");
			
			//Create a connection
			Connection connection = connectionFactory.createConnection();
			connection.start();
			
			//Create session
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//Create Destination Topic or Queue
			Destination destination = session.createQueue("HELLOWORLD.TESTQ");
			
			//Create a MessageProducer from the Session to the Topic or Queue
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			
			// Create a Message
			String text = "Hello World from: "+Thread.currentThread().getName();
			TextMessage message = session.createTextMessage(text);
			
			//Tell the producer to send the message
			System.out.println("Sent Message from Producer : "+message.hashCode()+" : "+Thread.currentThread().getName());
			producer.send(message);
			
			//Close the session and connection
			session.close();
			connection.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
