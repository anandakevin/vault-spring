package intra.bca.co.id.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import intra.bca.co.id.dao.CustomerDao;
import intra.bca.co.id.model.Customer;

public class JdbcCustomerDao implements CustomerDao {

	private DataSource dataSource;
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Customer customer) {
		String sql = "INSERT INTO CUSTOMER " + " (cust_id, full_name, address, email) VALUES (?, ?, ?, ?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer.getCustId());
			ps.setString(2, customer.getFullname());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getEmail());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					
				}
			}
		}
	}

	public Customer findByCustomerId(int custId) {
		String sql = "SELECT * FROM CUSTOMER WHERE cust_id = ?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			Customer cs = null;
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				cs = new Customer(
						rs.getInt("cust_id"), 
						rs.getString("full_name"),
						rs.getString("address"),
						rs.getString("email")
						);
			}
			rs.close();
			ps.close();
			return cs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					
				}
			}
		}
	}

}
