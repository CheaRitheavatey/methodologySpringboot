package designPattern.behavorial.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImplementation implements ChatMediator{
    private List<User> users;
    public ChatMediatorImplementation() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            // message shouldn't be received by the user who send it
            if (u != user) {
                u.receive(user.name + " : "  +message);
            }
        }

    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}
