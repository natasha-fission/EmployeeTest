package com.fisson.cont;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fission.model.Employee;
import com.fission.model.User;
import com.fission.service.EmpService;
import com.fission.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmpService empService;
	
	/**/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("");
		model.addAttribute("person", new User());
		model.addAttribute("emp", new Employee());
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("person") User p, Model model)
	{
		
		boolean c=this.userService.checkUser(p);
		if(c)
		{	
			return "redirect:/getList";
			/*//System.out.println(this.empService.listEmployees());
			model.addAttribute("listEmp",listEmployees(model));
			return "loggedin";*/
		}
			else 
			return "home";
		
	}
	
	@RequestMapping(value="/getList")
	public String listEmployees(Model model)
	{
		System.out.println(this.empService.listEmployees());
		model.addAttribute("listEmp", this.empService.listEmployees());
		return "loggedin";
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model model )
	{
		model.addAttribute("emp", new Employee());
		return "addEmployee";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addEmp(@ModelAttribute("emp")Employee e,Model model)
	{
		this.empService.addEmployee(e);
		return "redirect:/getList";
	}
	
	
	@RequestMapping(value="/delete/{empl}", method=RequestMethod.GET)
    public String removePerson(@PathVariable("empl") int id,Model model){
		
        this.empService.removeEmployee(id);
        return "redirect:/getList";
    }

	@RequestMapping(value="/update/{empl}",method=RequestMethod.GET)
    public String edit(@PathVariable("empl") int id, Model model){
    	
        model.addAttribute("emp2", this.empService.getEmployeeByEmpId(id));
        return "update";
    }
    
    
    @RequestMapping(value="/update",method=RequestMethod.POST)
    public String update(@ModelAttribute("emp2")Employee e, Model model){
    	//System.out.println("in update employee.......");
    	//System.out.println(e);
    	empService.updateEmployee(e);
    	return "redirect:/getList";
    }
	
}
