package exercise_5;

public class BridgePattern {

	public static void main(String[] args) {
		MessageSender textMessageSender = new TextMessageSender();
		Message textMessage = new TextMessage("Hello", textMessageSender);
		textMessage.send();
		MessageSender emailMessageSender = new EmailMessageSender();
		Message emailMessage = new TextMessage("This is an auto generated email", emailMessageSender);
		emailMessage.send();
	}

}

abstract class Message {
	MessageSender messageSender;
	String message;

	public Message(String message, MessageSender messageSender) {
		this.message = message;
		this.messageSender = messageSender;
	}

	abstract public void send();
}

class TextMessage extends Message {
	public TextMessage(String message, MessageSender messageSender) {
		super(message, messageSender);
	}

	@Override
	public void send() {
		messageSender.sendMessage();
	}
}

class EmailMessage extends Message {
	public EmailMessage(String message, MessageSender messageSender) {
		super(message, messageSender);
	}

	@Override
	public void send() {
		messageSender.sendMessage();
	}
}

interface MessageSender {
	public void sendMessage();
}

class TextMessageSender implements MessageSender {
	@Override
	public void sendMessage() {
		System.out.println("TextMessageSender: Sending text message...");
	}
}

class EmailMessageSender implements MessageSender {
	@Override
	public void sendMessage() {
		System.out.println("EmailMessageSender: Sending email message...");
	}
}
