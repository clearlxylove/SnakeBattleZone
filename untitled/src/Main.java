class PersonClass {
    private int id;
    private String name;
    private String gender;
    private String birthDate;

    public PersonClass(int id, String name, String gender, String birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }
}

class TercharClass extends PersonClass {
    private String department;
    private String title;
    private double salary;

    public TercharClass(int id, String name, String gender, String birthDate, String department, String title, double salary) {
        super(id, name, gender, birthDate);
        this.department = department;
        this.title = title;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getTitle() {
        return title;
    }

    public double getSalary() {
        return salary;
    }
}

class StudentClass extends PersonClass {
    private int entranceScore;
    private String major;

    public StudentClass(int id, String name, String gender, String birthDate, int entranceScore, String major) {
        super(id, name, gender, birthDate);
        this.entranceScore = entranceScore;
        this.major = major;
    }

    public int getEntranceScore() {
        return entranceScore;
    }

    public String getMajor() {
        return major;
    }
}

public class Main {
    public static void main(String[] args) {
        TercharClass teacher = new TercharClass(1, "Teacher Name", "Male", "1990-01-01", "Department A", "Professor", 8000);
        System.out.println("Teacher Information:");
        System.out.println("ID: " + teacher.getId());
        System.out.println("Name: " + teacher.getName());
        System.out.println("Gender: " + teacher.getGender());
        System.out.println("Birth Date: " + teacher.getBirthDate());
        System.out.println("Department: " + teacher.getDepartment());
        System.out.println("Title: " + teacher.getTitle());
        System.out.println("Salary: " + teacher.getSalary());

        StudentClass student = new StudentClass(2, "Student Name", "Female", "2005-05-05", 650, "Computer Science");
        System.out.println("\nStudent Information:");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Gender: " + student.getGender());
        System.out.println("Birth Date: " + student.getBirthDate());
        System.out.println("Entrance Score: " + student.getEntranceScore());
        System.out.println("Major: " + student.getMajor());
    }
}