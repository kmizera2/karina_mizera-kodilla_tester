public class Application {

    public String name;
    double age;
    double height;

    public Application(String name, double age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public static void main(String[] args) {
        Application user = new Application("Adam", 40.5, 178);
        user.checkAgeAndHeight(user);
    }

    public void checkAgeAndHeight(Application application) {
        if (application.name != null) {
            if (application.age > 30 && application.height > 160) {
                System.out.println("User is older than 30 and taller than 160cm");
            } else {
                System.out.println("User is 30 (or younger) or 160cm (or shorter)");
            }
        }
    }
}
