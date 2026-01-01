package sujon.com;


public class Student {
	protected String name = "Unknown";
	protected int age = 18;
	protected double mark = 40.0;
	protected String grade = "Pass";
	
	public Student(String name, int age, double mark, String grade) {
		super();
		this.name = name;
		this.age = age;
		this.mark = mark;
		this.grade = grade;
	}
	
	public static void main(String[] args) {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
	    return name + ", " + age + ", " + mark + ", " + grade;
	}
	
	public void speak() {
		System.out.println("Hello my name is " + name);
	}
	
	

}
