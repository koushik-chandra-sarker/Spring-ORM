package com.springORM;

import com.springORM.One_UsingXml.DAO.StudentDAO;
import com.springORM.One_UsingXml.Entity.SpringORMStudent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        StudentDAO studentDAO = context.getBean("StudentDAO", StudentDAO.class);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        boolean go = true;
       while (go){
           System.out.println("Press 1 for add new Student");
           System.out.println("Press 2 for display all Student");
           System.out.println("Press 3 for get a Student");
           System.out.println("Press 4 for delete a Student");
           System.out.println("Press 5 for update a Student");
           System.out.println("Press 6 for Exit");
           try {
                int choice = Integer.parseInt(bufferedReader.readLine());
                switch (choice){
                    case 1:
//                        add Student
                        System.out.println("Enter student id:");
                        int sId = Integer.parseInt(bufferedReader.readLine());
                        System.out.println("\nEnter student name:");
                        String sName = bufferedReader.readLine();
                        System.out.println("\nEnter student City:");
                        String sCity = bufferedReader.readLine();

                        SpringORMStudent springORMStudent = new SpringORMStudent(sId,sName,sCity);
                        int i = studentDAO.insert(springORMStudent);
                        System.out.println(i + " Student added");

                        break;
                    case 2:
//                        display all student
                        System.out.println("Please wait...");
                        System.out.println("\n"+studentDAO.getAllStudent()+"\n");

                        break;
                    case 3:
//                        display one student
                        System.out.println("\nEnter student Id:");
                        int sid = Integer.parseInt(bufferedReader.readLine());
                        System.out.println("\n"+studentDAO.getStudent(sid)+"\n");

                        break;

                    case 4:
//                        delete a student
                        System.out.println("\nEnter student Id:");
                        int siid = Integer.parseInt(bufferedReader.readLine());
                        studentDAO.deleteStudent(siid);
                        System.out.println("\nOne Student deleted\n");
                        break;

                    case 5:
//                        update a student
                        System.out.println("Enter student id:");
                        int Id = Integer.parseInt(bufferedReader.readLine());
                        System.out.println("\nEnter student updated name:");
                        String Name = bufferedReader.readLine();
                        System.out.println("\nEnter student updated City:");
                        String City = bufferedReader.readLine();
                        SpringORMStudent springORMStudent1 = new SpringORMStudent(Id,Name,City);
                        studentDAO.updateStudent(springORMStudent1);
                        System.out.println("\nStudent updated successful..\n");
                        break;

                    case 6:
//                        Exit
                        go=false;
                        break;
                    default:
                        System.out.println("Invalid input try with another one...");
                        break;

                }

           }
           catch (Exception e){
               System.out.println("Invalid input try with another one...");
               System.out.println(e.getMessage());
           }

       }
    }
}
