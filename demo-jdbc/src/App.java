import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
        Department dep = new Department(1, "D1");
        System.out.println(dep);
        Seller seller = new Seller(1, "Seller1", "seller@seller.com", new Date(), 1000.0, dep);
        System.out.println(seller);
    }
}
