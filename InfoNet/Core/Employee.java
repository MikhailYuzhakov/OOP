package Core;

public class Employee{
    private Integer id;
    public String name;
    public String surName;
    public String phonenumber;
    public String salary;

    public Employee(Integer id,String name, String surName, String phonenumber,String salary){
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.phonenumber = phonenumber;
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id+" ").append(name+" ").append(surName+": ").append(phonenumber+": ").append(salary+": ");
        return sb.toString();
    }


    public Integer getId() {
        return id;
    }

}
