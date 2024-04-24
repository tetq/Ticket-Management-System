import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void addUsers(User user) {
        users.add(user);
    }

    public void listUsers() {
        System.out.println("all users: ");
        for (User user : users) {
            System.out.println("user ID: " + user.getUserId() + ", name: " + user.getName() + ", email: " + user.getEmail());
        }
    }

    public User findUserByID (int userID) {
        for (User user : users) {
            if (user.getUserId() == userID) {
                return user;
            }
        }
        return null; // user not found
    }
}