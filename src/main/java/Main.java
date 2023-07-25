import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static List<User> userList = new ArrayList<>();

    public static void main(String[] args) {
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

        sortedByAge();
        averageAge();
        sortedByFirstNameAndAge();
        usersWithSOrA();
        usersOver18();
    }

    // Sort by age method, record to new collection
    public static List<User> sortedByAge() {

        List<User> byAgeList = userList.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());

        System.out.println("--- Sorted by age ---");
        for (User item : byAgeList) {
            System.out.println(item.getAge() + " " + item.getFirstName() + " " + item.getSecondName());
        }
        return byAgeList;
    }

    // Average users age method
    public static double averageAge() {
        double userAverage = userList.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0.0);
        System.out.println("\n--- Average age ---\n" + userAverage);
        return userAverage;
    }

    // Sort by first name and age method
    public static List<User> sortedByFirstNameAndAge() {
        List<User> byFirstNameAndAge = userList.stream()
                .sorted(Comparator.comparing(User::getFirstName).thenComparingInt(User::getAge))
                .collect(Collectors.toList());
        System.out.println("\n--- Sorted by first name and age ---");
        for (User item : byFirstNameAndAge) {
            System.out.println(item.getFirstName() + " " + item.getAge());
        }
        return byFirstNameAndAge;
    }

    // Users with S or A method
    public static boolean usersWithSOrA() {
        boolean sOrA = userList.stream()
                .anyMatch(user -> user.getSecondName().startsWith("S") || user.getSecondName().startsWith("A"));
        System.out.println("\n--- Users with S or A ---\n" + sOrA);
        return sOrA;
    }
    // Users over 18 method
    public static boolean usersOver18() {
        boolean over18 = userList.stream()
                .allMatch(user -> user.getAge() > 18);
        System.out.println("\n--- Users over 18 ---\n" + over18);
        return over18;
    }
}