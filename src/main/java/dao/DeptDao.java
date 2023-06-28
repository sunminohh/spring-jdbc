package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vo.Dept;

@Repository
public class DeptDao {
	
	@Autowired
	private JdbcTemplate template;
	
	public List<Dept> getAllDepts(){
		String sql = "select department_id, department_name, location_id, manager_id "
				   + "from departments order by department_id asc ";
		return template.query(sql, (rs, rownum)->{
			Dept dept = new Dept();
			dept.setId(rs.getInt("department_id"));
			dept.setName(rs.getString("department_name"));
			dept.setManagerId(rs.getInt("manager_id"));
			dept.setLocationId(rs.getInt("location_id"));
			
			return dept;	
		});
	}
	
	public Dept getDeptById(int departmentId) {
		String sql = "select * from departments where department_id = ?";
		
		return template.queryForObject(sql, (rs, rownum) -> {
			Dept dept = new Dept();
			dept.setId(rs.getInt("department_id"));
			dept.setName(rs.getString("department_name"));
			dept.setManagerId(rs.getInt("manager_id"));
			dept.setLocationId(rs.getInt("location_id"));
			
			return dept;
		}, departmentId); 
	}
	
	public void insertDept(Dept dept) {
		String sql = "insert into departments "
				+ "(department_id, department_name, location_id) "
				+ "values "
				+ "(DEPARTMENTS_SEQ.nextval, ?, ?)";
		
		template.update(sql, dept.getName(), dept.getLocationId());
	} 
}
