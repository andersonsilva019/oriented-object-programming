package model.dao;

// import database.DB;
import model.implementations.DepartmentDaoJDBC;
import model.implementations.SellerDaoJDBC;

public class DaoFactory {
  public static ISellerDao createSellerDao() {
    return new SellerDaoJDBC();
  }

  public static IDepartmentDao createDepartmentDao() {
    return new DepartmentDaoJDBC();
  }
}
