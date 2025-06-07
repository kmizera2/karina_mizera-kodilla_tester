package com.kodilla.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.sql.SQLException;

class DbManagerTestSuite {
    private static DbManager dbManager;

    @BeforeAll
    public static void setup() throws SQLException {
        dbManager = DbManager.getInstance();
    }

    @Test
    void testConnect() {
        //Given
        //When
        //Then
        Assertions.assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //Given
        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assertions.assertEquals(5, counter);
    }

    @Test
    void testSelectUsers2() throws SQLException {
        //Given
        String countQuery = "SELECT COUNT(*) FROM USERS";
        Statement statement = createStatement();
        ResultSet rs = statement.executeQuery(countQuery);
        int count = getRowsCount(rs);
        insertUsers(statement);

        //When
        String sqlQuery = "SELECT * FROM USERS";
        statement = createStatement();
        rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = getResultsCount(rs);
        int expected = count + 5;
        Assertions.assertEquals(expected, counter);

        rs.close();
        statement.close();
    }

    private Statement createStatement() throws SQLException {
        return dbManager.getConnection().createStatement();
    }

    private static final List<AbstractMap.SimpleEntry<String, String>> USERS = List.of(
            new AbstractMap.SimpleEntry<>("Zara", "Ali"),
            new AbstractMap.SimpleEntry<>("Otman", "Use"),
            new AbstractMap.SimpleEntry<>("Mark", "Boq"),
            new AbstractMap.SimpleEntry<>("Uli", "Wimer"),
            new AbstractMap.SimpleEntry<>("Oli", "Kosiw")
    );

    private void insertUsers(Statement statement) throws SQLException {
        for (AbstractMap.SimpleEntry<String, String> user : USERS) {
            statement.executeUpdate(
                    String.format("INSERT INTO USERS(FIRSTNAME, LASTNAME) VALUES ('%s', '%s')",
                            user.getKey(),
                            user.getValue()
                    )
            );
        }
    }

    private static int getResultsCount(ResultSet rs) throws SQLException {
        int counter = 0;
        while(rs.next()) {
            System.out.printf("%d, %s, %s%n",
                    rs.getInt("ID"),
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"));
            counter++;
        }
        return counter;
    }

    private static int getRowsCount(ResultSet rs) throws SQLException {
        int count = 0;
        while (rs.next()) {
            count = rs.getInt("COUNT(*)");
        }
        return count;
    }


    @Test
    void testSelectUsersAndPosts() throws SQLException {
        Statement statement = createStatement();

        // Znajdź maksymalne ID użytkownika w tabeli USERS
        ResultSet rsMax = statement.executeQuery("SELECT COALESCE(MAX(ID), 0) AS MAX_ID FROM USERS");
        rsMax.next();
        int maxUserId = rsMax.getInt("MAX_ID");
        rsMax.close();

        int baseId = maxUserId + 1;

        // Wstaw nowych użytkowników z ID od baseId wzwyż
        insertUsersWithBaseId(statement, baseId);
        insertPostsWithBaseId(statement, baseId);

        // Zapytanie odfiltrowujące tylko użytkowników z ID od baseId wzwyż
        String sqlQuery = String.format("""
        SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POST_COUNT
        FROM USERS U
        JOIN POSTS P ON U.ID = P.USER_ID
        WHERE U.ID >= %d
        GROUP BY U.ID
        HAVING COUNT(*) >= 2
    """, baseId);

        ResultSet rs = statement.executeQuery(sqlQuery);

        int counter = getPostResultsCount(rs);
        Assertions.assertEquals(2, counter);

        rs.close();
        statement.close();
    }

    private void insertUsersWithBaseId(Statement statement, int baseId) throws SQLException {
        statement.executeUpdate(String.format("INSERT INTO USERS(ID, FIRSTNAME, LASTNAME) VALUES (%d, 'Test1', 'User1')", baseId));
        statement.executeUpdate(String.format("INSERT INTO USERS(ID, FIRSTNAME, LASTNAME) VALUES (%d, 'Test2', 'User2')", baseId + 1));
        statement.executeUpdate(String.format("INSERT INTO USERS(ID, FIRSTNAME, LASTNAME) VALUES (%d, 'Test3', 'User3')", baseId + 2));
    }

    private void insertPostsWithBaseId(Statement statement, int baseId) throws SQLException {
        statement.executeUpdate(String.format("INSERT INTO POSTS(USER_ID, BODY) VALUES (%d, 'Post A1')", baseId));
        statement.executeUpdate(String.format("INSERT INTO POSTS(USER_ID, BODY) VALUES (%d, 'Post A2')", baseId));
        statement.executeUpdate(String.format("INSERT INTO POSTS(USER_ID, BODY) VALUES (%d, 'Post B1')", baseId + 1));
        statement.executeUpdate(String.format("INSERT INTO POSTS(USER_ID, BODY) VALUES (%d, 'Post B2')", baseId + 1));
        statement.executeUpdate(String.format("INSERT INTO POSTS(USER_ID, BODY) VALUES (%d, 'Post B3')", baseId + 1));
        statement.executeUpdate(String.format("INSERT INTO POSTS(USER_ID, BODY) VALUES (%d, 'Post C1')", baseId + 2));
    }

    private static int getPostResultsCount(ResultSet rs) throws SQLException {
        int counter = 0;
        while (rs.next()) {
            System.out.printf("%s %s - Posts: %d%n",
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"),
                    rs.getInt("POST_COUNT"));
            counter++;
        }
        return counter;
    }

}