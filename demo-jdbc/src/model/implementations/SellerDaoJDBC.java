package model.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import database.DB;
import database.DbException;
import model.dao.ISellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements ISellerDao {

  private Connection connection = null;

  public SellerDaoJDBC(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void insert(Seller obj) {
    // TODO Auto-generated method stub

  }

  @Override
  public void update(Seller obj) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteById(Integer id) {
    // TODO Auto-generated method stub

  }

  @Override
  public Seller findById(Integer id) {
    PreparedStatement st = null;
    ResultSet rs = null;

    try {
      st = connection.prepareStatement(
          "SELECT seller.*, department.name AS DepName "
              + "FROM seller INNER JOIN department "
              + "ON seller.departmentid = department.id "
              + "WHERE seller.id = ?");
      // Primeiro parâmetro é a posição do ? na query
      st.setInt(1, id);
      rs = st.executeQuery();

      if (rs.next()) {
        Department dep = instantiateDepartment(rs);
        Seller seller = instantiateSeller(rs, dep);
        return seller;
      }

      return null;

    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.closeStatement(st);
      DB.closeResultSet(rs);
    }
  }

  private Department instantiateDepartment(ResultSet rs) throws SQLException {
    Department dep = new Department();
    dep.setId(rs.getInt("departmentid"));
    dep.setName(rs.getString("DepName"));
    return dep;
  }

  private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
    Seller seller = new Seller();
    seller.setId(rs.getInt("Id"));
    seller.setName(rs.getString("name"));
    seller.setEmail(rs.getString("email"));
    seller.setBirthDate(rs.getDate("birthdate"));
    seller.setBaseSalary(rs.getDouble("basesalary"));
    seller.setDepartment(dep);
    return seller;
  }

  @Override
  public List<Seller> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Seller> findByDepartment(Department department) {
    // TODO Auto-generated method stub
    return null;
  }

}