import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) {
    List<String> firstList = new ArrayList<>();
    firstList.add("pavan");
    firstList.add("an");
    LinkedList<String> filtered = new LinkedList<>();
    filtered = (LinkedList<String>) firstList.stream().filter(t -> firstList.contains("p"))
        .collect(Collectors.toList());
    System.out.println(filtered);
  }
}
