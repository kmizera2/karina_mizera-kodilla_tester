package stream.homework;

import org.junit.jupiter.api.Test;
import stream.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForumStatsTest {
    private final List<User> testUsers = List.of(
            new User("Walter White", 50, 7, "Chemists"),
            new User("Jessie Pinkman", 25, 4648, "Sales"),
            new User("Tuco Salamanca", 34, 116, "Manager"),
            new User("Gus Firing", 49, 0, "Board"),
            new User("Gale Boetticher", 44, 2, "Chemists"),
            new User("Mike Ehrmantraut", 57, 0, "Security")
    );

    @Test
    void testGetAveragePostsForUsersAbove40() {
        double result = ForumStats.getAveragePostsForUsersAbove40(testUsers);
        double expected = (7 + 0 + 2 + 0) / 4.0;
        assertEquals(expected, result, 0.01);
    }

    @Test
    void testGetAveragePostsForUsersBelow40() {
        double result = ForumStats.getAveragePostsForUsersBelow40(testUsers);
        double expected = (4648 + 116) / 2.0;
        assertEquals(expected, result, 0.01);
    }

    @Test
    void testGetAveragePostsForUsersAbove40_NoUsers() {
        double result = ForumStats.getAveragePostsForUsersAbove40(List.of());
        assertEquals(0.0, result);
    }

    @Test
    void testGetAveragePostsForUsersBelow40_NoUsers() {
        double result = ForumStats.getAveragePostsForUsersBelow40(List.of());
        assertEquals(0.0, result);
    }

}