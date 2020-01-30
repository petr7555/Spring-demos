import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Petr Janik 485122
 * @since 07/10/2019
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        System.out.println(list);

        addToList(list);

        System.out.println(list);
    }

    private static void addToList(List<String> list) {
        list.remove("b");
        list.add(0,"b");
    }
}
