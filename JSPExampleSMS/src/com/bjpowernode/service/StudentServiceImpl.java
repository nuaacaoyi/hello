package com.bjpowernode.service;

import com.bjpowernode.Dao.IStudentDao;
import com.bjpowernode.Dao.IStudentDaoImpl;
import com.bjpowernode.beans.Student;

/**
 * @author CY_JFXX
 * @create 2020-03-15 17:45
 */
public class StudentServiceImpl implements IStudentService {
    private IStudentDao dao;

    public StudentServiceImpl(IStudentDao dao) {
        this.dao = dao;
    }

    public StudentServiceImpl() {
        dao=new IStudentDaoImpl();
    }

    @Override
    public Student checkUser(String num, String password) {
        return dao.selectStudentLogin(num,password);
    }
}
