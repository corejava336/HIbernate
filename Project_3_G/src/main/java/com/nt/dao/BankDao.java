package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.bank;
import com.nt.entity.items;
import com.nt.util.util;

public class BankDao {

	public boolean login(String name, String password) {
		try (Session ses = util.getSession()) {
			util.beginTransaction(ses);
			String q = "FROM bank WHERE name = :name AND password = :password";
			Query<bank> query = ses.createQuery(q, bank.class);
			query.setParameter("name", name);
			query.setParameter("password", password);
			bank user = query.uniqueResult();
			boolean r = (user != null);
			if (r) {
				System.out.println("Record found");
			} else {
				System.out.println("Record not found");
			}
			util.commitTransaction(ses); // Commit only if successful
			return r;
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("Record not found");
			return false;
		}
	}

	public boolean signup(String name, String password, bank bankEntity) {
		try (Session ses = util.getSession()) {
			bankEntity.setName(name);
			bankEntity.setPassword(password);

			util.beginTransaction(ses);
			ses.save(bankEntity); // Save the entity
			util.commitTransaction(ses);
			System.out.println("Record created");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Record not created");
			return false;
		}
	}

	public items add(String name, String count, items i) {
	    try (Session ses = util.getSession()) {
	        util.beginTransaction(ses);

	        items item = search(name, ses);
	        if (item != null) {
	            // Item already exists, return it
	            util.commitTransaction(ses);
	            return item;
	        } else {
	            // Item doesn't exist, add a new item
	            i.setName(name);
	            i.setCount(count);

	            ses.save(i); // Save the entity
	            util.commitTransaction(ses);
	            System.out.println("Record created");
	            return i;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Record not created");
	        return i;
	    }
	}


	 public items search(String name) {
	        try (Session ses = util.getSession()) {
	            return search(name, ses);
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            System.out.println("Error during search");
	            return null;
	        }
	    }

	    public items search(String name, Session ses) {
	        try {
	            String q = "FROM items WHERE name = :name";
	            Query<items> query = ses.createQuery(q, items.class);
	            query.setParameter("name", name);
	            items user = query.uniqueResult();
	            boolean r = (user != null);
	            if (r) {
	                System.out.println("Record found");
	            } else {
	                System.out.println("Record not found");
	            }
	            return user;
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            System.out.println("Record not found");
	            return null;
	        }
	    }
	

	public items update(String name, String count, items i) {
		try (Session ses = util.getSession()) {
			util.beginTransaction(ses);

			// Try to load the item by its name
			items existingItem = search(name, ses);

			if (existingItem != null) {
				// If the item exists, update its count
				existingItem.setCount(count);
				ses.update(existingItem);
				System.out.println("Record updated");
				util.commitTransaction(ses);
				return existingItem;
			} else {
				// If the item doesn't exist, add a new item
				i.setName(name);
				i.setCount(count);
				ses.save(i);
				System.out.println("Record created");
				util.commitTransaction(ses);
				return i;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Record not updated/created");
			return i;
		}
	}
}
