import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private static List<User> userList;

    @BeforeAll
    public static void setUp() {
        // Подготовка данных перед запуском всех тестов
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


    @Test
    @DisplayName("Task B: Sorted by Age collection: positive")
    public void testSortedByAge() {
        List<User> sortedList = Main.sortedByAge();
        for (int i = 0; i < sortedList.size() - 1; i++) {
            assertTrue(sortedList.get(i).getAge() <= sortedList.get(i + 1).getAge());
        }
    }

    @Test
    @DisplayName("Task B: Sorted by Age collection: negative")
    public void testSortedByAge_negativeCase() {
        List<User> sortedList = Main.sortedByAge();
        assertNull(sortedList); // Negative case

    }

    @Test
    public void testAverageAge_positiveCase() {
        double averageAge = Main.averageAge();
        // Add assertions for the positive case
        assertTrue(averageAge > 0);
        //...
    }

    @Test
    public void testAverageAge_negativeCase() {
        double averageAge = Main.averageAge();
        // Add assertions for the negative case
        assertFalse(averageAge < 0);
        //...
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public void testSortedByFirstNameAndAge_parameterized(int iteration) {
        List<User> sortedList = Main.sortedByFirstNameAndAge();
        // Add assertions for the parameterized test
        assertNotNull(sortedList);
        //...
    }

    @Test
    @DisplayName("Тест на сортировку по имени и возрасту")
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

    @Test
    public void testUsersOver18_repeated() {
        boolean result = Main.usersOver18();
        // Add assertions for the repeated test
        assertTrue(result);
        //...
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
