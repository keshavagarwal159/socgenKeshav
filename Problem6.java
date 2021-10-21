import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;




class User1 implements Comparable<User1>{
	private int id;
	private String name;
	private int Salary;
	private Project project;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	User1(){};
	
	@Override
	
	public String toString() {
		return String.format("id: "+this.getId()+"name: "+this.getName()+"salary: "+this.getSalary());
		
	}
	
}
class Project{
	
	private String pid;
	private String name;
	private int budget;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	
	Project(){};
}




public class Problem6 {
	
	public static void main(String [] args) {
		
		Project pr1 = new Project();
		Project pr2 = new Project();
		Project pr3 = new Project();
		
		pr1.setPid("pr1");
		pr2.setPid("pr2");
		pr3.setPid("pr1");
		
		pr1.setName("ATT");
		pr2.setName("Google");
		pr3.setName("ATT");
		
		pr1.setBudget(1000);
		pr2.setBudget(320);
		pr3.setBudget(1000);
		
		User1 u1 = new User1();
		User1 u2 = new User1();
		User1 u3 = new User1();
		
		u1.setId(1);
		u1.setName("User1");
		u1.setSalary(100);
		u1.setProject(pr1);
		
		u2.setId(2);
		u2.setName("User2");
		u2.setSalary(360);
		u2.setProject(pr2);
		
		u3.setId(3);
		u3.setName("User3");
		u3.setSalary(500);
		u3.setProject(pr3);
		
		List<User1> l =  new ArrayList<User1>();
		
		l.add(u1);
		l.add(u2);
		l.add(u3);
		
		Map<String,List<User1>> m = new LinkedHashMap<String,List<User1>>();
		
		
		
		for(int i = 0;i<l.size();i++) {
			if(m.get(l.get(i).getProject().getPid())==null) {
				
				List<User1> li = new ArrayList<User1>();
				li.add(l.get(i));
				m.put(l.get(i).getProject().getPid(),li );
			}else {
				List<User1> lis = new ArrayList<User1>();
				lis = m.get(l.get(i).getProject().getPid());
				lis.add(l.get(i));
				m.put(l.get(i).getProject().getPid(),lis);
			}
		}
		
		
		
		
		for(Map.Entry<String, List<User1>> mp: m.entrySet()) {
			
			
			System.out.println(mp.getKey());
			for(int i = 0;i<mp.getValue().size();i++) {
				if(mp.getValue().get(i).getSalary()<=(mp.getValue().get(i).getProject().getBudget()+(0.1*mp.getValue().get(i).getProject().getBudget()))) {
					System.out.println(mp.getValue().get(i));
					
				}else {
					System.out.println("OutOfBudget: ");
					System.out.println(mp.getValue().get(i)+" name: "+mp.getValue().get(i).getProject().getName()+" Budget: "+ +mp.getValue().get(i).getProject().getBudget());
				}	
				
				}
				
			}
			
			
		}
		
		
		
	}
	

