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
        try {

//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);

            // 기존의 방식 : team를 insert 하고, team_id를 가져와서 member를 insert 해야함 -> 객체지향 스럽지 못하다는 단점 (DB에 맞게 작성한 것임)
//            Member member = new Member();
//            member.setName("member1");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            Member findMember = em.find(Member.class, member.getId());
//
//            Long findTeamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, findTeamId);

            // 양방향  연관관계 코드
//            Member member = new Member();
//            member.setName("member1");
//            member.setTeam(team);   // 단방향 연관관계 설정, 참조 저장 : 1 : N, FK
//            em.persist(member);
//
//
//            em.flush(); // 쿼리를 미리 날린다
//            em.clear(); // 영속성 컨텍스트를 초기화 : DB에서 쿼리를 실행시켜서 쿼리 실행되는지 확인하는 방법
//
//
//            // 조회 : 멤버 -> 팀, ManyToOne
//            Member findMember = em.find(Member.class, member.getId());
//
//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeam : " + findTeam.getName());
//
//            // 조회 : 팀 -> 멤버, OnetoMany
//            Member findMember2 = em.find(Member.class, member.getId());
//            List<Member> members = findMember2.getTeam().getMembers();
//
//            for (Member m : members) {
//                System.out.println("m = " + m.getName());
//            }


            // ** 양방향 연관관계와 연관관계의 주인 ** 중요
            // 저장
            // team
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            // member
            Member member = new Member();
            member.setName("member1");
            member.changeTeam(team);    // Member Class
            em.persist(member);

            // 연관 관계 주인인 Member의 team에도 저장해야하고, Team의 리스트 타입의 member에도 저장해야 한다. : 양방향
//            team.getMembers().add(member);  // 양방향 연관 관계 편의 메소드를 새로 생성해도 된다 -> 주인인 Member Class에서 SetTeam() ㄱㄱ

            Team findTeam = em.find(Team.class, team.getId());  // 1차 캐시
            List<Member> members = findTeam.getMembers();

            System.out.println("=============");

            for (Member m : members) {
                System.out.println("m = " + m.getId());
            }

            System.out.println("=============");


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
