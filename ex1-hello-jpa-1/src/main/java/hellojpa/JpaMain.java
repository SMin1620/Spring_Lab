package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // code

        //////////////// insert /////////////////
//        try {
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//        emf.close();

        ////////////// update ////////////////
//        try {
//            Member findMember = em.find(Member.class, 1L);
//
//            findMember.setName("HelloJPA");
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//        emf.close();

        /////////  read + limit, offset ////////
//        try {
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                            .setFirstResult(1)
//                                    .setMaxResults(5)
//                                            .getResultList();
//
//            for (Member member : result) {
//                System.out.println(member.getName());
//            }
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//        emf.close();

        //////// JPA 영속성 ///////
        try {
            // 비영속 : 영속 컨텍스트에 member의 객체가 캐싱되지 않은 상태 즉, 객체에만 갑싱 저장된 상태
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            // 영속 : 앞서 데이터를 저장하 객체를 영속 컨텍스트에 캐싱한 상태5
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");
//
//            // select 쿼리가 실행되지 않음 : 영속 컨텍스트에 캐싱된 데이터를 읽기 떄문이다.
//            Member findMember = em.find(Member.class, 101L);    // 그리고 find 조회를 하면 조회된 데이터는 무조건 영속 컨텍스트에 캐싱한다.
//                                                                   // 그래서 다음 같은 101L을 조회해도 쿼리가 실행되지 않음.
//
//            System.out.println(findMember.getId());
//            System.out.println(findMember.getName());



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
