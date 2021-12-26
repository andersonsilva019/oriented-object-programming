package model.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    PreparedStatement st = null;
    try {
      st = connection.prepareStatement(
          "INSERT INTO seller "
              + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
              + "VALUES (?, ?, ?, ?, ?)",
          Statement.RETURN_GENERATED_KEYS);

      st.setString(1, obj.getName());
      st.setString(2, obj.getEmail());
      st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
      st.setDouble(4, obj.getBaseSalary());
      st.setInt(5, obj.getDepartment().getId());

      int rowsAffected = st.executeUpdate();

      if (rowsAffected > 0) {
        ResultSet rs = st.getGeneratedKeys();
        if (rs.next()) {
          int id = rs.getInt(1);
          obj.setId(id);
        }
        DB.closeResultSet(rs);
      } else {
        throw new DbException("Unexpected error! No rows affected!");
      }

    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.closeStatement(st);
    }
  }

  @Override
  public void update(Seller obj) {
    PreparedStatement st = null;
    try {
      st = connection.prepareStatement(
          "UPDATE seller "
              + "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
              + "WHERE Id = ?");

      st.setString(1, obj.getName());
      st.setString(2, obj.getEmail());
      st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
      st.setDouble(4, obj.getBaseSalary());
      st.setInt(5, obj.getDepartment().getId());
      st.setInt(6, obj.getId());

      st.executeUpdate();

    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.closeStatement(st);
    }

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
    PreparedStatement st = null;
    ResultSet rs = null;

    try {
      st = connection.prepareStatement(
          "SELECT seller.*,department.Name as DepName "
              + "FROM seller INNER JOIN department "
              + "ON seller.DepartmentId = department.Id "
              + "ORDER BY Name ");
      rs = st.executeQuery();

      List<Seller> listOfSeller = new ArrayList<>();
      Map<Integer, Department> map = new HashMap<>();

      while (rs.next()) {

        Department dep = map.get(rs.getInt("DepartmentId"));

        if (dep == null) {
          dep = instantiateDepartment(rs);
          map.put(rs.getInt("DepartmentId"), dep);
        }

        Seller seller = instantiateSeller(rs, dep);
        listOfSeller.add(seller);
      }
      return listOfSeller;
    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.closeStatement(st);
      DB.closeResultSet(rs);
    }
  }

  @Override
  public List<Seller> findByDepartment(Department department) {
    PreparedStatement st = null;
    ResultSet rs = null;

    try {
      st = connection.prepareStatement(
          "SELECT seller.*,department.Name as DepName "
              + "FROM seller INNER JOIN department "
              + "ON seller.DepartmentId = department.Id "
              + "WHERE DepartmentId = ? "
              + "ORDER BY Name ");

      st.setInt(1, department.getId());
      rs = st.executeQuery();

      List<Seller> listOfSeller = new ArrayList<>();
      Map<Integer, Department> map = new HashMap<>();

      while (rs.next()) {

        Department dep = map.get(rs.getInt("DepartmentId"));

        if (dep == null) {
          dep = instantiateDepartment(rs);
          map.put(rs.getInt("DepartmentId"), dep);
        }

        Seller seller = instantiateSeller(rs, dep);
        listOfSeller.add(seller);
      }
      return listOfSeller;
    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.closeStatement(st);
      DB.closeResultSet(rs);
    }
  }

}