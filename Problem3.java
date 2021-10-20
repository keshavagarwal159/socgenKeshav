package Java101;
import java.util.*;
public class User implements Comparator<User {
    public User() {

    }

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    private int id;
    private String name;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
    @Override
    public int compareTo(User o){
        return this.getName().compareTo(o.getName());
    @Override
    public String toString() {
        return this.id +" ,"+ this.name + this.email;
    }



    public static void main(String[] args) {
        User user1 = new User(1,"Harry, ","Harr@gg.com");
        User user2 = new User(2,"Ajay, ","ajay2@email.com");
        User user3 = new User(1,"Amir, ","amir@tt.co.uk");
        User user4 = new User(4,"Rohan, ","rohan1@tt.co.uk");
        User user5 = new User(5,"Bob, ","bob@tt.co.uk");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

        Collections.sort(userList);

        for(User uu:userList){
            System.out.println(uu);
        }


    }

}

