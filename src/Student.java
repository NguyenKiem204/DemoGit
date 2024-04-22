/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NguyenGiap
 */
public abstract class Student implements DataEntry{
    public String id;
    public String name;
    public int age;
    public String gender;
    private static final long serialVersionUID = 1233263669671069845L;

    public Student() {
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
    

    

    public String student(String nextLine) {
      return "Name:" + this.name + "," + "id: " + this.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    
    
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
   
    
}
