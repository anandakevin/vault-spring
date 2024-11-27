package intra.bca.co.id.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper <Customer>{

	public CustomerRowMapper() {
		
	}
	
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Customer(
				rs.getInt("cust_id"), 
				rs.getString("full_name"), 
				rs.getString("address"), 
				rs.getString("email")
		);
	}

}
