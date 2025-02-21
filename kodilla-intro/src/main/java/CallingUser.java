public class CallingUser {
    public static void main(String[] args) {

        int counter = 0;

        User user1 = new User("Anna", 12);
        User user2 = new User("Alina", 19);
        User user3 = new User("Adam", 50);
        User user4 = new User("Bartosz", 29);
        User user5 = new User("Kamil", 19);

        User[] users = new User[]{user1, user2, user3, user4, user5};

        for (int i = 0; i < users.length; i++) {
            counter = counter + users[i].age;
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i].age < (double) counter / users.length) System.out.println(users[i].name);
        }
    }
}
