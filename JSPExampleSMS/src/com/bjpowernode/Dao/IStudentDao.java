package com.bjpowernode.Dao;

import com.bjpowernode.beans.Student;

/**
 * @author CY_JFXX
 * @create 2020-03-15 17:50
 */
public interface IStudentDao {
    Student selectStudentLogin(String num, String password);
}
