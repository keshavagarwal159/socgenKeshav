import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
class Users implements Comparable<Users>{
	
	private int id;
	private String name;
	private String email;
	private int salary;
	
	Users(int id, String name, String email, int salary){
		this.id = id;
		this.name = name;
		this.setEmail(email);
		this.setSalary(salary);

	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override	
	public int compareTo(Users o) {
		//sort by id
		//return this.getId()-o.getId();
	
		//sort by name
		
		return o.getSalary() - this.getSalary();
	
	}
	
	@Override
	public String toString() {
		return String.format(this.id +" "+this.getName()+" "+ this.getSalary());
				
	}
}
public class Problem4 {
	public static void main(String [] args) {
		
		Users user1 = new Users(89,"Harry","Harry@jsjdfkj.com",40000);
		Users user2 = new Users(46,"Amit","fedvr@jsjdfkj.com",7000);
		Users user3 = new Users(14,"Bob","bgfb@jsjdfkj.com",4000);
		Users user4 = new Users(16,"Amit","dvdvs@jsjdfkj.com",409000);
		
		List<Users> user = new ArrayList<Users>();
		user.add(user1);
		user.add(user2);
		user.add(user3);
		user.add(user4);
		
		Collections.sort(user);
		
//		for(Users u:user) {
//			System.out.println(u);
//		}
		
		Map<Integer,Users> map = new LinkedHashMap<Integer,Users>();
		
		for (Users u : user) {
			map.put(u.getId(), u);
		}
		
		for (Map.Entry<Integer,Users> m: map.entrySet()) {
			
			System.out.println(String.format(m.getKey()+": "+m.getValue()));
			
		}
	}
}
