package com.rt.rt;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * tutaj bedzie crud dla encji Emp
 * @author rafal
 *
 */
@SessionAttributes("sesyjna2")
@Controller
public class EmpController {
	
	//wstrzukuj obiekt dao
    @Autowired
    private EmpDAO empDao;
	private static final Logger log = LoggerFactory.getLogger(EmpController.class);
	
@RequestMapping	(value = "/empList")
public String empList(Map<String, Object> model , HttpServletRequest request){
	log.info("kontoler emp");
	Employee emp=empDao.find(666);
	log.info(emp.toString());
	model.put("666", emp);
	request.getSession().setAttribute("sesyjna", "Zmienna sesyjna");
	model.put("sesyjna2", "sesyjna2");
	log.info("dodalem do sesji obiejkt sesyjna2");
	return "lista";
}


/**
 * na razie statycznie
 * dodac z forms
 * @return
 */
@RequestMapping (value="/empAdd")
public String empAdd(){
	
	////test dodawania
	Employee emp= new Employee();
	emp.setEmployeeId(666);
	emp.setFirstName("test");
	emp.setLastName("test");
	emp.setEmail("mail@mail.pl");
	emp.setHireDate(new Date());
	emp.setJobId("FI_MGR");
	/////
	
	empDao.create(emp);
	return "home";
}

/**
 * na razie statycznie
 * dodac z forms
 * @return
 */
@RequestMapping (value="/empRemove")
public String empRemove(){
	empDao.deteleById(666);
	return "home";
}


}
