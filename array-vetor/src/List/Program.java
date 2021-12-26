package List;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    
    list.add("Anderson");
    list.add("Silva");
    list.add("Souza");
    list.add("Hello");

    list.add(2, "José");

    System.out.println(list.size());
    
    for(String name: list){
      System.out.println(name);
    }
    
    System.out.println("--------------------------");
    
    list.removeIf(x -> x.charAt(0) == 'S');
    
    for(String name: list){
      System.out.println(name);
    }
    System.out.println("--------------------------");
    System.out.println("Index of Souza: "+list.indexOf("Hello"));
    System.out.println("--------------------------");

    // Realizando filtro
    List<String> filteredResults = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());
    System.out.println(filteredResults);  

    System.out.println("---------------------------");
    String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);
    System.out.println(name);
    
  }
}
