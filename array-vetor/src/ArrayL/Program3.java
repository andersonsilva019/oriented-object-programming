package ArrayL;

import java.util.ArrayList;

public class Program3 {
  public static void main(String[] args) {
    ArrayList<Integer> vec = new ArrayList<Integer>(20);

    vec.add(23);
    vec.add(24);
    vec.add(25);
    vec.add(30);
    System.out.println(vec);
    vec.add(0, 22);
    System.out.println(vec);
    
    // Removendo o elemento 25
    vec.remove(Integer.valueOf(25));
    System.out.println(vec);
    
    // removendo o elemento do index 0
    vec.remove(0);
    System.out.println(vec);
  }
}
