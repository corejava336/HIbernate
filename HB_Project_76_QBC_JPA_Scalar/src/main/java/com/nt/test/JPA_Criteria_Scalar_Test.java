/*
 * package com.nt.test;
 * 
 * import java.util.List;
 * 
 * import javax.persistence.criteria.CriteriaBuilder; import
 * javax.persistence.criteria.CriteriaQuery; import
 * javax.persistence.criteria.Root;
 * 
 * import org.hibernate.HibernateException; import org.hibernate.Session; import
 * org.hibernate.Transaction;
 * 
 * import com.nt.entity.Customer1; import com.nt.util.util;
 * 
 * //execting scalar query specific mutiple col values public class
 * JPA_Criteria_Scalar_Test {
 * 
 * public static void main(String[] args) { Session ses = null; ses =
 * util.getSesion(); Transaction tx = null;
 * 
 * // SQL --SELECT id and name from customer1 where Age between 20 and 100
 * CriteriaBuilder builder = null; try { if (!ses.getTransaction().isActive())
 * tx = util.beginTransaction(ses);
 * 
 * builder = ses.getCriteriaBuilder(); CriteriaQuery<Object[]> ctquery =
 * builder.createQuery(Object[].class);
 * 
 * Root<Customer1> root = ctquery.from(Customer1.class);
 * ctquery.multiselect(root.get("id"), root.get("name"),root.get("Age"));
 * 
 * // Adding the condition for Age between 20 and 100
 * ctquery.where(builder.between(root.get("Age"), 20, 100));
 * 
 * // Execute the query List<Object[]> list =
 * ses.createQuery(ctquery).getResultList();
 * 
 * // Process the result list as needed list.forEach(row -> { for (Object val :
 * row) { System.out.print(val + " "); } System.out.println();
 * 
 * }); } catch (HibernateException he) { he.printStackTrace(); } finally {
 * util.closeSession(ses); util.closeSessionFactory(); } } }
 * 
 * /* package com.nt.test;
 * 
 * import java.util.List;
 * 
 * import javax.persistence.criteria.CriteriaBuilder; import
 * javax.persistence.criteria.CriteriaQuery; import
 * javax.persistence.criteria.Root;
 * 
 * import org.hibernate.HibernateException; import org.hibernate.Session; import
 * org.hibernate.Transaction;
 * 
 * import com.nt.entity.Customer1; import com.nt.util.util;
 * 
 * public class JPA_Criteria_Scalar_Test {
 * 
 * public static void main(String[] args) { Session ses = null; ses =
 * util.getSesion(); Transaction tx = null;
 * 
 * // SQL --SELECT id and name from customer1 where Age between 20 and 100
 * CriteriaBuilder builder = null; try { if (!ses.getTransaction().isActive())
 * tx = util.beginTransaction(ses);
 * 
 * builder = ses.getCriteriaBuilder(); CriteriaQuery<Customer1> ctquery =
 * builder.createQuery(Customer1.class);
 * 
 * Root<Customer1> root = ctquery.from(Customer1.class); ctquery.select(root);
 * 
 * // Adding the condition for Age between 20 and 100
 * ctquery.where(builder.between(root.get("Age"), 20, 100));
 * 
 * // Execute the query List<Customer1> list =
 * ses.createQuery(ctquery).getResultList();
 * 
 * // Process the result list as needed list.forEach( System.out::println); }
 * catch (HibernateException he) { he.printStackTrace(); } finally {
 * util.closeSession(ses); util.closeSessionFactory(); } } }
 */