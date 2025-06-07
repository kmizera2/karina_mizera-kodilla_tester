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

        System.out.println("Użytkownicy z co najmniej 2 postami PRZED dodaniem nowych danych:");
        printUsersWithAtLeastTwoPosts(statement);

        int beforeCount = getUsersWithAtLeastTwoPostsCount(statement);

        ResultSet rsMax = statement.executeQuery("SELECT COALESCE(MAX(ID), 0) AS MAX_ID FROM USERS");
        rsMax.next();
        int baseId = rsMax.getInt("MAX_ID") + 1;
        rsMax.close();

        insertUsersWithBaseId(statement, baseId);
        insertPostsWithBaseId(statement, baseId);

        System.out.println("\nUżytkownicy z co najmniej 2 postami PO dodaniu nowych danych:");
        printUsersWithAtLeastTwoPosts(statement);

        int afterCount = getUsersWithAtLeastTwoPostsCount(statement);

        int expectedIncrease = 2; // Wiemy, że 2 z nowych użytkowników ma >= 2 posty

        Assertions.assertEquals(beforeCount + expectedIncrease, afterCount);

        statement.close();
    }

    private int getUsersWithAtLeastTwoPostsCount(Statement statement) throws SQLException {
        String countQuery = """
        SELECT COUNT(*) AS USER_COUNT
        FROM (
            SELECT U.ID
            FROM USERS U
            JOIN POSTS P ON U.ID = P.USER_ID
            GROUP BY U.ID
            HAVING COUNT(*) >= 2
        ) AS subquery
    """;
        ResultSet rs = statement.executeQuery(countQuery);
        rs.next();
        int count = rs.getInt("USER_COUNT");
        rs.close();
        return count;
    }

    private void printUsersWithAtLeastTwoPosts(Statement statement) throws SQLException {
        String query = """
        SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POST_COUNT
        FROM USERS U
        JOIN POSTS P ON U.ID = P.USER_ID
        GROUP BY U.ID, U.FIRSTNAME, U.LASTNAME
        HAVING COUNT(*) >= 2
        ORDER BY U.ID
    """;

        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            System.out.printf("%s %s - Liczba postów: %d%n",
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"),
                    rs.getInt("POST_COUNT"));
        }
        rs.close();
    }

    private void insertUsersWithBaseId(Statement statement, int baseId) throws SQLException {
        statement.executeUpdate(String.format("INSERT INTO USERS(ID, FIRSTNAME, LASTNAME) VALUES (%d, 'Test4', 'User4')", baseId));
        statement.executeUpdate(String.format("INSERT INTO USERS(ID, FIRSTNAME, LASTNAME) VALUES (%d, 'Test5', 'User5')", baseId + 1));
        statement.executeUpdate(String.format("INSERT INTO USERS(ID, FIRSTNAME, LASTNAME) VALUES (%d, 'Test6', 'User6')", baseId + 2));
    }

    private void insertPostsWithBaseId(Statement statement, int baseId) throws SQLException {
        statement.executeUpdate(String.format("INSERT INTO POSTS(USER_ID, BODY) VALUES (%d, 'Post d1')", baseId));
        statement.executeUpdate(String.format("INSERT INTO POSTS(USER_ID, BODY) VALUES (%d, 'Post d2')", baseId));
        statement.executeUpdate(String.format("INSERT INTO POSTS(USER_ID, BODY) VALUES (%d, 'Post e1')", baseId + 1));
        statement.executeUpdate(String.format("INSERT INTO POSTS(USER_ID, BODY) VALUES (%d, 'Post e2')", baseId + 1));
        statement.executeUpdate(String.format("INSERT INTO POSTS(USER_ID, BODY) VALUES (%d, 'Post e3')", baseId + 1));
        statement.executeUpdate(String.format("INSERT INTO POSTS(USER_ID, BODY) VALUES (%d, 'Post f1')", baseId + 2));
    }
}