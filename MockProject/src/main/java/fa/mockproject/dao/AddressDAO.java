	package fa.mockproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import fa.mockproject.model.Address;

@Repository
public class AddressDAO implements DAOInterface<Address>{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(Address t) {
		try {
			String sql = "INSERT INTO [Address] "
					+ "(province, district, ward, street, deliveredInformationId) "
					+ "VALUES (?, ?, ?, ?, ?)";

			return jdbcTemplate.update(sql, t.getProvince(), t.getDistrict(), t.getWard(), t.getStreet(),
					t.getDeliveredInformationId());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Address t) {
		try {
			String sql = "UPDATE [Address] " + "SET province = ?, district = ?, ward = ?, street = ?" + "WHERE deliveredInformationId = ?";
			return jdbcTemplate.update(sql,t.getProvince(), t.getDistrict(), t.getWard(), t.getStreet(), t.getDeliveredInformationId());
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(Address t) {
		try {
			String sql = "DELETE FROM [Adress] WHERE deliveredInformationId = ?";
			return jdbcTemplate.update(sql, t.getDeliveredInformationId());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public ArrayList<Address> findAll() {
		try {
			String sql = "SELECT * FROM [Address]";
			return (ArrayList<Address>) jdbcTemplate.query(sql, new RowMapper<Address>() {
				@Override
				public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
					Address address = new Address();
					address.setProvince(rs.getString("province"));
					address.setDistrict(rs.getString("district"));
					address.setWard(rs.getString("ward"));
					address.setStreet(rs.getString("street"));
					address.setDeliveredInformationId(UUID.fromString(String.valueOf(rs.getString("deliveredInformationId"))));
					
					return address;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public Address findById(Address t) {
		try {
			String sql = "SELECT * FROM [Address] WHERE deliveredInformationId = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] { t.getDeliveredInformationId() }, new RowMapper<Address>() {
				@Override
				public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
					Address address = new Address();
					address.setProvince(rs.getString("province"));
					address.setDistrict(rs.getString("district"));
					address.setWard(rs.getString("ward"));
					address.setStreet(rs.getString("street"));
					address.setDeliveredInformationId(UUID.fromString(String.valueOf(rs.getString("deliveredInformationId"))));
					return address;
				}

			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Address> getAllAddressByUserId(UUID userId) {
        try {
            String sql = "SELECT a.* FROM Address a " +
                         "JOIN Delivery_information di ON a.delivered_informationId = di.delivered_informationId " +
                         "WHERE di.userId = ?";

            return (ArrayList<Address>) jdbcTemplate.query(sql, new Object[]{userId.toString()}, new RowMapper<Address>() {
                @Override
                public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Address address = new Address();
                    address.setProvince(rs.getString("province"));
                    address.setDistrict(rs.getString("district"));
                    address.setWard(rs.getString("ward"));
                    address.setStreet(rs.getString("street"));
                    address.setDeliveredInformationId(UUID.fromString(rs.getString("delivered_informationId")));
                    address.setAddressID(UUID.fromString(rs.getString("addressId")));
                    return address;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
	
	public int addAddressByUserId(UUID userId, String province, String district, String ward, String street) {
        try {
        	
            String findDeliveryInfoSql = "SELECT delivered_informationId FROM Delivery_information WHERE userId = ?";
            UUID deliveredInformationId = null;

            try {
                deliveredInformationId = jdbcTemplate.queryForObject(findDeliveryInfoSql, UUID.class, userId);
            } catch (Exception e) {
                // Không tìm thấy delivered_informationId, cần tạo mới
                System.out.println("User chưa có delivered_informationId, tạo mới...");
            }
            if (deliveredInformationId == null) {
            	System.out.println("null lôp");
                String insertDeliveryInfoSql = "INSERT INTO Delivery_information (userId) VALUES (?)";
                jdbcTemplate.update(insertDeliveryInfoSql, userId);

                deliveredInformationId = jdbcTemplate.queryForObject(findDeliveryInfoSql, UUID.class, userId);

                if(deliveredInformationId == null){
                    return 0; 
                }
            }
            String insertAddressSql = "INSERT INTO Address (province, district, ward, street, delivered_informationId) VALUES (?, ?, ?, ?, ?)";
            return jdbcTemplate.update(insertAddressSql, province, district, ward, street, deliveredInformationId);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
	
	public int deleteAddressById(UUID addressId) {
		try {
			String sql = "DELETE FROM [Address] WHERE addressId = ?";
			return jdbcTemplate.update(sql, addressId);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public Address findById(UUID addressId) {
		try {
			String sql = "SELECT * FROM [Address] WHERE addressId = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] { addressId }, new RowMapper<Address>() {
				@Override
				public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
					Address address = new Address();
					address.setProvince(rs.getString("province"));
					address.setDistrict(rs.getString("district"));
					address.setWard(rs.getString("ward"));
					address.setStreet(rs.getString("street"));
					address.setDeliveredInformationId(UUID.fromString(String.valueOf(rs.getString("delivered_informationId"))));
					address.setAddressID(UUID.fromString(rs.getString("addressId")));
					return address;
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int updateAddressById(UUID addressid, String city, String district, String ward, String street) {
		try {
			String sql = "UPDATE [Address] " + "SET province = ?, district = ?, ward = ?, street = ?" + " WHERE addressId = ?";
			return jdbcTemplate.update(sql, city, district, ward, street, addressid);
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
