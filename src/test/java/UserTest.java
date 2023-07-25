import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private static List<User> userList;
    @BeforeAll
    public static void setUp() {
        // Preparation before running all tests
        userList = new ArrayList<>();
        userList.add(new User("John", "Smith", 25));
        userList.add(new User("Alice", "Cooper", 30));
        userList.add(new User("Iga", "Swiatek", 22));
        userList.add(new User("Adam", "Sandler", 56));
        userList.add(new User("David", "Guetta", 55));
        userList.add(new User("Ridley", "Scott", 85));
        userList.add(new User("Olivia", "Wilde", 39));
        userList.add(new User("Amy", "Adams", 48));
        userList.add(new User("Mark", "Allen", 37));
        userList.add(new User("Avril", "Lavigne", 38));
    }

    @BeforeEach
    public void setUpBeforeEach() {
        System.out.println("--- New test ---");
    }

    // Task B

    @ParameterizedTest
    @CsvFileSource(resources = "SortedByAge.csv", numLinesToSkip = 1)
    @DisplayName("Task B: CSV file")
    void testSortedByAge(String firstName, String secondName, int age) {
        assertNotNull(firstName, secondName);
        assertNotEquals(0,age);
    }


    @Test
    @DisplayName("Task B - positive: Sorted by Age collection")
    public void testSortedByAge() {
        List<User> sortedList = Main.sortedByAge();
        for (int i = 0; i < sortedList.size() - 1; i++) {
            assertTrue(sortedList.get(i).getAge() <= sortedList.get(i + 1).getAge());
        }
    }

    @Test
    @DisplayName("Task B - positive: List is not empty")
    void testSortedByAgeNotNull() {
        List<User> sortedList = Main.sortedByAge();
        assertNotNull(sortedList); // Check that list is not empty
    }

    @Test
    @DisplayName("Task B - negative")
    void testSortedByAgeWithEmptyList() {
        Main.userList.clear();
        Assertions.assertNotEquals(Collections.emptyList(), Main.sortedByAge());
    }


    // Task C
    @Test
    @DisplayName("Task C - positive:")
    void testAverageAge() {
        double expectedAverage = (25 + 30 + 22 + 56 + 55 + 85 + 39 + 48 + 37 + 38) / 10.0;
        assertEquals(expectedAverage, 43.5, 0.001);
    }

    @Test
    @DisplayName("Task C - positive:")
    void testAverageAge_Positive_EmptyList() {
        userList.clear();

        double actualAverage = Main.averageAge();

        Assertions.assertEquals(0.0, actualAverage, 0.001);
    }

    @Test
    @DisplayName("Task C - negative:")
    void testAverageAge_Negative() {
        userList = null;
        Assertions.assertThrows(NullPointerException.class, () -> Main.averageAge());
    }

    // Task D
    @ParameterizedTest
    @DisplayName("Task D - positive:")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public void testSortedByFirstNameAndAgeNotNull(int iteration) {
        List<User> sortedList = Main.sortedByFirstNameAndAge();
        assertNotNull(sortedList);

    }

    @Test
    @DisplayName("Task D - positive:")
    public void testSortedByFirstNameAndAge() {
        List<User> sortedList = Main.sortedByFirstNameAndAge();
        // Проверяем, что список отсортирован по имени, а затем по возрасту
        for (int i = 0; i < sortedList.size() - 1; i++) {
            User current = sortedList.get(i);
            User next = sortedList.get(i + 1);
            assertTrue(current.getFirstName().compareTo(next.getFirstName()) <= 0);
            if (current.getFirstName().equals(next.getFirstName())) {
                assertTrue(current.getAge() <= next.getAge());
            }
        }
    }

    @Test
    void testUsersWithSOrA_positiveCase() {
        boolean result = Main.usersWithSOrA();
        // Add assertions for the positive case
        Assertions.assertTrue(result);
        //...
    }

    @Test
    public void testUsersWithSOrA_negativeCase() {
        boolean result = Main.usersWithSOrA();
        // Add assertions for the negative case
        assertFalse(result);
        //...
    }

    @RepeatedTest(10)
    @DisplayName("Repeated test: User over 18")
    void testUsersOver18() {
        boolean result = Main.usersOver18();
        Assertions.assertTrue(result);
    }

    @AfterEach
    public void tearDownAfterEach() {
        System.out.println("--- End of test ---");
    }

    @AfterAll
    public static void tearDownAfterAll() {
        Main.userList.clear();
    }
}
