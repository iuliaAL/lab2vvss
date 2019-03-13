package lab2vvss;

import static org.junit.Assert.assertTrue;

import Domain.Student;
import Repository.StudentRepo;
import Service.ServiceStudent;
import Validator.StudentValidator;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Random;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    private Random random;

    @Test
    public void addStudentTestHappyCase()
    {
        String id = String.valueOf(random.nextInt());
        String nume = "Ana";
        int gr = 934;
        String em = nume + "@yahoo.com";
        String prof = "Dan";
        Student stud = new Student(id, nume, gr, em, prof);

        StudentRepo rep=new StudentRepo(new StudentValidator(),"/Users/IuliaLazar/Downloads/LabAssiAsseProjectV04/studenti.txt");
        ServiceStudent srv = new ServiceStudent(rep);

        srv.add(stud);

        Assert.assertTrue(srv.find(id).equals(stud));
    }

    @Test
    public void addInvalidStudent()
    {
        String id = String.valueOf(random.nextInt());
        String nume = "Ana";
        int gr = 4;
        String em = nume + "@yahoo.com";
        String prof = "Dan";
        Student stud = new Student(id, nume, gr, em, prof);

        StudentRepo rep=new StudentRepo((Validator.Validator<Student>) new StudentValidator(),"C:\\Users\\Alexandra\\Desktop\\LabAssiAsseProjectV04\\src\\studenti.xml");
        ServiceStudent srv = new ServiceStudent(rep);

        srv.add(stud);

        Assert.assertFalse( "Student was added!", (srv.find(id).equals(stud)));
    }
}
