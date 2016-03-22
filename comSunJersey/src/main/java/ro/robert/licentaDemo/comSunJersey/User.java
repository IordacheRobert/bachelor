package ro.robert.licentaDemo.comSunJersey;

import java.util.ArrayList;

public class User {

	private String username;
	private ArrayList<String> toDo=new ArrayList<String>();
	private Task task;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, ArrayList<String> toDo, Task task) {
		super();
		this.username = username;
		this.toDo = toDo;
		this.task = task;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ArrayList<String> getToDo() {
		return toDo;
	}
	public void setToDo(ArrayList<String> toDo) {
		this.toDo = toDo;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", toDo=" + toDo + ", task="
				+ task + "]";
	}
	
	
	
}
