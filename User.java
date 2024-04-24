public class User {
    private int userId;
    private String name;
    private String email;

    public User(int userID, String name, String email) {
        this.userId = userID;
        this.name = name;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        if (userId == 0)
            this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty())
            this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.isEmpty())
            this.email = email;
    }
}