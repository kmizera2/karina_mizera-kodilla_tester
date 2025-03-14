import java.util.List;
import java.util.stream.Collectors;

public class UsersManager {
    public static void main(String[] args) {
        processUsersStream();
        processUsersStream2();
        List<String> chemistGroupUsernames = filterChemistGroupUsernames();
        System.out.println(chemistGroupUsernames);
        System.out.println(getUsersOlderThan(40).toString());

    }

    static List<String> filterChemistGroupUsernames() {
        List<String> usernames = UsersRepository.getUsersList()   // [1]
                .stream()
                .filter(user -> user.getGroup().equals("Chemists"))
                .map(UsersManager::getUserName)
                .collect(Collectors.toList());                      // [2]

        return usernames;
    }

    static int countUsersWithNoPosts() {
        List<String> usernames = UsersRepository.getUsersList()
                .stream()
                .filter(user -> user.getNumberOfPost()==0)
                .map(UsersManager::getUserName)
                .collect(Collectors.toList());

        return usernames.size();
    }



    private static void processUsersStream() {
        UsersRepository.getUsersList()
                .stream()
                .map(UsersManager::getUserName)
                //     .map(user -> user.getUsername())// zamiast user mozna uzyc dwa razy np uset dowolnosc nazwy
                .forEach(username -> System.out.println(username));
    }

        private static void processUsersStream2() {
            UsersRepository.getUsersList()
                    .stream()
                    .filter(user -> user.getGroup().equals("Chemists")) // [1]
                    .map(UsersManager::getUserName)
                    .forEach(username -> System.out.println(username));
    }

    static List<User> getUsersOlderThan(int age) {
        return UsersRepository.getUsersList()
                .stream()
                .filter(user -> user.getAge()>age)
                .collect(Collectors.toList());


    }

    public static String getUserName(User user) {
        return user.getUsername();
    }
}
