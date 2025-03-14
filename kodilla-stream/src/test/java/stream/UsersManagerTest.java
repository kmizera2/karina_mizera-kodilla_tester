package stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersManagerTest {

    @Test
    public void filterChemistGroupUsernames(){
        UsersManager userManager = new UsersManager();
        List<String> expectedList=new ArrayList<>();
        expectedList.add("Walter White");
        expectedList.add("Gale Boetticher");
        assertEquals(expectedList, userManager.filterChemistGroupUsernames());
    }

    @Test
    public void processUsersOlderThan_SomeUsersMeetCriteria(){
        UsersManager userManager = new UsersManager();
        List<User> filteredUsers=userManager.getUsersOlderThan(40);
        assertTrue(filteredUsers.stream().allMatch(user -> user.getAge() >40));
    }

    @Test
    void testGetUsersOlderThan_AllUsersMeetCriteria() {
        UsersManager userManager = new UsersManager();
        List<User> filteredUsers=userManager.getUsersOlderThan(24);
        assertTrue(filteredUsers.stream().allMatch(user -> user.getAge() >24));
        }


    @Test
    void testGetUsersOlderThan_NoUsersMeetCriteria() {
        UsersManager userManager = new UsersManager();
        List<User> filteredUsers=userManager.getUsersOlderThan(57);
        assertTrue(filteredUsers.isEmpty());
    }

    @Test
    void testCountUsersWithNoPosts() {
        UsersManager userManager = new UsersManager();
        int numberOfUsers=userManager.countUsersWithNoPosts();
        assertEquals(2, numberOfUsers );
    }

}