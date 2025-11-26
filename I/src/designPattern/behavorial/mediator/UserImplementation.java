package designPattern.behavorial.mediator;

public class UserImplementation extends User{
    public UserImplementation(ChatMediator chatMediator, String name) {
        super(chatMediator,name);
    }
    @Override
    public void send(String message) {
        System.out.println(this.name + " sent: " + message);
        chatMediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + " Received from " + message);
    }
}
