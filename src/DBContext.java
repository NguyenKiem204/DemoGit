import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;





/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NguyenGiap
 */


public class DBContext {
    protected FileInputStream fis = null;
    protected ObjectInputStream ois = null;

    protected FileOutputStream fos = null;
    protected ObjectOutputStream oos = null;
    protected List<Student> studentList = new ArrayList<>();
    protected File directory = new File("data");
    
    
    

    public void saveStudentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            oos.writeObject(studentList);
            System.out.println("Student data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public void addTag(Student record) throws IOException {
//        FileWriter fw = new FileWriter("data\\index.txt");
//        PrintWriter pw = new PrintWriter(fw);
//        
//        pw.println(record.getMssv() + " " + record.getName());
//        pw.close();
//    }

    public void insert(Student record) {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter("data\\" + record.getId() + ".txt"))) {
        // Ghi dữ liệu vào file
       
            writer.write(record.toString());
            writer.newLine(); // Thêm dòng mới sau mỗi bản ghi
            studentList.add(record);
            System.out.println("Student data saved successfully.");
        } catch (IOException ex) {
            System.out.println("Failed to save student data.");
            ex.printStackTrace();
        }
    }
    
    
    public void deleteContent(String id) {
       
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
        File file = new File("data\\" + id + ".txt");
        if (file.exists() && file.delete()) {
        } else {
            System.out.println("Failed to delete file " + id + ".txt.");
        }
    }
 
    
    
   public void displayAllStudent() throws FileNotFoundException, IOException, ClassNotFoundException {
        File directory = new File("data");
        File[] listFiles = directory.listFiles();

        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && !file.getName().equals("IdNumber.txt")) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            // Hiển thị thông tin sinh viên từ mỗi dòng trong tệp tin
                            System.out.println(line);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
   
   }
   
   
   
   public void updateStudent(String id, String newName, String newId) {
       boolean found = false;
       for (Student student : studentList) {
            // Kiểm tra nếu sinh viên có ID trùng khớp
            if (student.getId().equals(id)) {
                // Kiểm tra xem ID mới có trùng với ID của sinh viên khác không
                boolean duplicateId = studentList.stream()
                        .anyMatch(s -> !s.equals(student) && s.getId().equals(newId));
                if (duplicateId) {
                    System.out.println("Failed to update student. ID '" + newId + "' is already used by another student.");
                    return;
                }else{
                        student.setName(newName);
                        student.setId(newId);
                        insert(student);
                }
                // Sửa thông tin của sinh viên
                System.out.println("Student with ID " + id + " updated successfully.");
                break;
            }
        }

        // Nếu không tìm thấy sinh viên trong danh sách, hiển thị thông báo tương ứng
        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        } else {
            // Ghi lại danh sách sinh viên vào tệp tin sau khi sửa đổi
            saveStudentsToFile();
        }
    }

  public void printStudentList(){
      for (Student student : studentList) {
          System.out.println(student);
      }
  }
    
       
}
   
   
  


