package fxfinalq2;

public class Employee {
    
    private int ID;
    private String Name,Job;
    private double Salary;

    public Employee(int ID, String Name, String Job, double Salary) {
        this.ID = ID;
        this.Name = Name;
        this.Job = Job;
        this.Salary = Salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String Job) {
        this.Job = Job;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }
    
    
}
