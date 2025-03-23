package stream.homework;

import stream.User;
import stream.UsersRepository;

import java.util.List;

public class ForumStats {

    public static double getAveragePostsForUsersAbove40(List<User> users) {
        return users.stream()
                .filter(user -> user.getAge() >= 40)
                .mapToInt(User::getNumberOfPost)
                .average()
                .orElse(0.0);
    }

    public static double getAveragePostsForUsersBelow40(List<User> users) {
        return users.stream()
                .filter(user -> user.getAge() < 40)
                .mapToInt(User::getNumberOfPost)
                .average()
                .orElse(0.0);
    }

    public static void main(String[] args) {
        List<User> users = UsersRepository.getUsersList();

        double avgAbove40 = getAveragePostsForUsersAbove40(users);
        double avgBelow40 = getAveragePostsForUsersBelow40(users);

        System.out.println("Średnia liczba postów dla użytkowników 40+: " + avgAbove40);
        System.out.println("Średnia liczba postów dla użytkowników poniżej 40: " + avgBelow40);
    }
}


