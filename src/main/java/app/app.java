package app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DeptDao;
import vo.Dept;

public class app {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-context.xml");
		
		DeptDao deptDao = context.getBean(DeptDao.class);
		
//		Dept dept1 = new Dept();
//		dept1.setName("개발부");
//		dept1.setLocationId(1700);
//		
//		deptDao.insertDept(dept1);
		
//		Dept dept = deptDao.getDeptById(10);
//		System.out.println("부서아이디: " +dept.getId());
//		System.out.println("부서이름: " +dept.getName());
//		System.out.println("부서소재지아이디: " +dept.getLocationId());
		
		List<Dept> depts = deptDao.getAllDepts();
		for (Dept dept : depts) {
			System.out.println(dept.getId() + "\t" + dept.getName() + "\t" + dept.getLocationId());
		}
	}
}
