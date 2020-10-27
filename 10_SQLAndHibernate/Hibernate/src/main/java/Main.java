import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        Course course = session.get(Course.class, 5);
//        System.out.println("id: " + course.getId());
//        System.out.println("name: " + course.getName());
//        System.out.println("duration: " + course.getDuration());
//        System.out.println("type: " + course.getType());
//        System.out.println("description: " + course.getDiscription());
//        System.out.println("teacher: " + course.getTeacherId());
//        System.out.println("students: " + course.getStudentCount());
//        System.out.println("price: " + course.getPrice());
//        System.out.println("per hour: " + course.getPricePerHour());

        List<PurchaseList> list = session.createQuery("FROM PurchaseList", PurchaseList.class)
                .getResultList();

        List<Student> studentList = session.createQuery("FROM Student", Student.class)
                .getResultList();

        List<Course> courseList = session.createQuery("FROM Course", Course.class)
                .getResultList();

        for (PurchaseList pl : list) {
            for (Student st : studentList) {
                for (Course course : courseList) {
                    if (pl.getStudentName().equals(st.getName()) && pl.getCourseName().equals(course.getName())) {
                        session.save(new LinkedPurchaseList(st.getId(), st.getName(), course.getId(), course.getName(), pl.getPrice(), pl.getSubscriptionDate()));
                    }
                }
            }
        }

        transaction.commit();
        sessionFactory.close();
    }
}
