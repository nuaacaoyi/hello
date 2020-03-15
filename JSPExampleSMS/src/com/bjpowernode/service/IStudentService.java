package com.bjpowernode.service;

import com.bjpowernode.beans.Student;

/**
 * @author CY_JFXX
 * @create 2020-03-15 17:46
 */
public interface IStudentService {
    //对用户进行验证
    Student checkUser(String num,String password);
}
