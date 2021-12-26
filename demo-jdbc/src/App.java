import java.util.List;

import model.dao.DaoFactory;
import model.dao.ISellerDao;
import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
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

    }
}
