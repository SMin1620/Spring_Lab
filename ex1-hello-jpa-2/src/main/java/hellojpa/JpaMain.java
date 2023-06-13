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
//        try {
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
//
//
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//        emf.close();

        try {

            Member member1 = new Member();
            member1.setUsername("A");

            Member member2 = new Member();
            member2.setUsername("B");

            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println("=============");

            // call next value for MEMBER_SEQ 가 처음에 두 번 호출된다.
            // -> 이유 : allocationSize = 50로 설정해주었는데, 처음 DB SEQ를 호출하니 1이었다. 50개를 미리 메모리에 올려두고 DB SEQ는 다음 번호를 가리킨다. (51)

            // DB SEQ 1 | 51
            // DB SEQ 메모리 (이미 메모리에 50개까지 올라가있음)
            // DB SEQ 메모리

            em.persist(member1);
            em.persist(member2);
            em.persist(member3);

            System.out.println("=============");

            System.out.println("member.id : " + member1.getId());
            System.out.println("member.id : " + member2.getId());
            System.out.println("member.id : " + member3.getId());

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
