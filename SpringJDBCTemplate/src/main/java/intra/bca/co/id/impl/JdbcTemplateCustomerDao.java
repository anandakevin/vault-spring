package intra.bca.co.id.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import intra.bca.co.id.dao.CustomerDao;
import intra.bca.co.id.model.Customer;
import intra.bca.co.id.model.CustomerRowMapper;

public class JdbcTemplateCustomerDao implements CustomerDao {
	
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Customer customer) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO CUSTOMER " + "(cust_id, full_name, address, email) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object [] {
				customer.getCustId(),
				customer.getFullname(),
				customer.getAddress(),
				customer.getEmail()
		});
	}

	public Customer findByCustomerId(int custId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM CUSTOMER WHERE cust_id = ?";

		Customer customer = (Customer) jdbcTemplate.queryForObject(sql, new Object[] {custId}, new CustomerRowMapper());
		return customer;
	}

	public List <Customer> findAllCustomers() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM CUSTOMER";

		List <Customer> custList = new ArrayList<Customer>();
		custList = jdbcTemplate.query(sql, new CustomerRowMapper());
		return custList;
	}
	
}
