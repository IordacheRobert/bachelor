package ro.robert.licentaDemo.comSunJersey;

public class Task {

	private String title;
	private String instructions;
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(String title, String instructions) {
		super();
		this.title = title;
		this.instructions = instructions;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	@Override
	public String toString() {
		return "Task [title=" + title + ", instructions=" + instructions + "]";
	}
	
	
}
