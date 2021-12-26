import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.ISellerDao;
import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ISellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("---------------Seller (findById)----------------");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("---------------Seller (findByDepartment)----------------");
        Department department = new Department(2, "Electronics");
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("---------------Seller (findAll)----------------");
        List<Seller> list2 = sellerDao.findAll();
        for (Seller obj : list2) {
            System.out.println(obj);
        }

        System.out.println("---------------Seller (insert)----------------");
        Seller seller3 = new Seller(null, "Maria Green", "greg@greg.com", new Date(),
                3000.0, department);
        sellerDao.insert(seller3);
        System.out.println("Inserted! New id = " + seller3.getId());

        System.out.println("---------------Seller (update)----------------");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("---------------Seller (deleteById)----------------");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
    }
}
