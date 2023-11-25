package com.nt.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Info;
import com.nt.entity.Proj_Id;
import com.nt.util.util;

public class TestObjectSave {

    private static boolean flag;

    public static void main(String[] args) {
        Session ses = null;
        Transaction tx = null;
        
        ses = util.getSesion();
        
        try {
            tx = util.beginTransaction(ses);
            
            Info info = new Info();
            
            Proj_Id id = new Proj_Id();
            id.setPid(101);
            id.setProjid(5001);
            
            info.setId(id);
            info.setPname("raja");
            info.setDeptno(567);
            info.setProjName("firefox");
            
            Serializable generatedId = ses.save(info);
            System.out.println("Generated ID: " + generatedId);
            
            flag = true;
        } catch (HibernateException he) {
            flag = false;
            he.printStackTrace();
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        } finally {
            if (flag) {
                util.commitTransaction(ses);
                System.out.println("Object saved");
            } else {
                util.rollbackTransaction(ses);
                System.out.println("Object not saved");
            }
            util.closeSession(ses);
            util.closeSessionFactory();
        }
    }
}
