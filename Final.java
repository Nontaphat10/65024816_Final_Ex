import java.util.ArrayList;

interface Person {
    String getName();
    void setName(String name);
    int getAge();
    void setAge(int age);
}

interface Job {
    String getPosition();
    void setPosition(String position);
    String getEmpID();
    void setEmpID(String empID);
}

class Project {
    private String projectName;
    private String description;

    public Project(String projectName, String description) {
        this.projectName = projectName;
        this.description = description;
    }

    public String getProjectInfo() {
        return projectName + ": " + description;
    }
}

class Employee implements Person, Job {
    private String name;
    private int age;
    private String position;
    private String empID;
    private ArrayList<Project> myProjects;

    public Employee(String name, int age, String position, String empID) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.empID = empID;
        this.myProjects = new ArrayList<>();
    }

    public void addProject(Project project) {
        myProjects.add(project);
    }

    public String getProjects() {
        StringBuilder projectDetails = new StringBuilder();
        for (Project project : myProjects) {
            projectDetails.append(project.getProjectInfo()).append("\n");
        }
        return projectDetails.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String getEmpID() {
        return empID;
    }

    @Override
    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String showDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Name: ").append(name).append("\n");
        details.append("Position: ").append(position).append("\n");
        details.append("EmpID: ").append(empID).append("\n");
        details.append("Projects:\n").append(getProjects());
        return details.toString();
    }
}

public class Final {
    public static void main(String[] args) {
        Employee tom = new Employee("Tom", 25, "UX/UI", "0001");
        Employee tim = new Employee("Tim", 30, "Frontend", "0002");

        Project webProjectTom = new Project("Web A", "Developing a web application");
        Project mobileProjectTom = new Project("Mobile app A", "Developing a mobile app");

        Project webProjectTim = new Project("Web A", "Developing a web application");

        tom.addProject(webProjectTom);
        tom.addProject(mobileProjectTom);

        tim.addProject(webProjectTim);

        System.out.println(tom.showDetails());
        System.out.println("*****************************************");
        System.out.println(tim.showDetails());
    }
}
