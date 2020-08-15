package com.springORM.One_UsingXml.DAO;

import com.springORM.One_UsingXml.Entity.SpringORMStudent;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class StudentDAO {
    private HibernateTemplate hibernateTemplate;

//    Save one
    @Transactional
    public int insert(SpringORMStudent springORMStudent){
        int i= (int) hibernateTemplate.save(springORMStudent);
        return i;
    }
//    Fetch One
    public SpringORMStudent getStudent(int studentId){

        return hibernateTemplate.get(SpringORMStudent.class,studentId);
    }

//    Fetch All
    public List<SpringORMStudent> getAllStudent(){
        return hibernateTemplate.loadAll(SpringORMStudent.class);
    }

//    delete
    @Transactional
    public void deleteStudent(int studentId){
        SpringORMStudent springORMStudent = hibernateTemplate.get(SpringORMStudent.class,studentId);
        hibernateTemplate.delete(springORMStudent);
    }

//    update
    @Transactional
    public void updateStudent(SpringORMStudent springORMStudent){
        hibernateTemplate.update(springORMStudent);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
