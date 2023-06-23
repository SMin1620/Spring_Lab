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

            /////////////////// 양방향  연관관계 코드
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


            ////////////////// ** 양방향 연관관계와 연관관계의 주인 ** 중요
            // 저장
            // team
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            // member
//            Member member = new Member();
//            member.setName("member1");
//            member.changeTeam(team);    // Member Class
//            em.persist(member);
//
//            // 연관 관계 주인인 Member의 team에도 저장해야하고, Team의 리스트 타입의 member에도 저장해야 한다. : 양방향
////            team.getMembers().add(member);  // 양방향 연관 관계 편의 메소드를 새로 생성해도 된다 -> 주인인 Member Class에서 SetTeam() ㄱㄱ
//
//            Team findTeam = em.find(Team.class, team.getId());  // 1차 캐시
//            List<Member> members = findTeam.getMembers();
//
//            System.out.println("=============");
//
//            for (Member m : members) {
//                System.out.println("m = " + m.getId());
//            }
//
//            System.out.println("=============");


            //////////////////// 상속 관계의 매핑

//            Movie movie = new Movie();
//            movie.setDirector("AAA");
//            movie.setActor("BBB");
//            movie.setName("바람과 함께 사라지다");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            // select
//            System.out.println("select ==========");
//            Movie findMove = em.find(Movie.class, movie.getId());
//            System.out.println("findMove = " + findMove);


            /////////////////////// 프록시

//            Member member = new Member();
//            member.setName("hello");
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
////            Member findMember1 = em.find(Member.class, member.getId());
////            System.out.println("findMember.id = " + findMember1.getId());
////            System.out.println("findMember.name = " + findMember1.getName());
////            System.out.println("findMember.name = " + findMember1.getName());
////
//            // 프록시 특징 18:00 매우 중요 진짜로;;;
//            Member findMember2 = em.getReference(Member.class, member.getId()); // 프록시 객체 초기화 -> 영속성 컨텍스트에게 DB로 데이터 매핑 요청
//            System.out.println("findMember.id = " + findMember2.getId());
//            System.out.println("findMember.name = " + findMember2.getName());
//            System.out.println("findMember.name = " + findMember2.getName());
//
//            em.flush();
//            em.clear();
//
//
//            // 프록시 객체 비교 -> == 을 사용하지 않고, instance of 를 사용해야 한다.
//            System.out.println("find 와 getReference로 가져온 객체는 다르다. (엔티티 객체, 프록시 객체)");
//
//            Member member1 = new Member();
//            member1.setName("member1");
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setName("member2");
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            Member m1 = em.find(Member.class, member1.getId()); // DB에 접근해서 가져온 엔티티 객체
//            Member m2 = em.getReference(Member.class, member2.getId());  // 영속성 컨텍스트가 가져온 프록시 객체
//
//            System.out.println("m1 == m2 : " + (m1.getClass() == m2.getClass()));   // false -> 엔티티 객체와 프록시 객체의 주소값은 다르다.
//            System.out.println("m1 isntance of Member : " + (m1 instanceof Member));    // true
//            System.out.println("m2 isntance of Member : " + (m2 instanceof Member));    // true
//
//
//            // 이미 엔티티 객체가 있을 때, getReference
//            em.flush();
//            em.clear();
//
//            Member EntityM = em.find(Member.class, member1.getId()); // DB에 접근해서 가져온 엔티티 객체
//            System.out.println("EntityM : " + EntityM.getClass());
//
//            Member RefM = em.getReference(Member.class, member1.getId());  // 영속성 컨텍스트가 가져온 프록시 객체
//            System.out.println("RefM : " + RefM.getClass());
//            // 같은 객체가 출력된다. -> 이미 영속성 컨텍스트에 값이 있는데 같은 값을 가져오는 쿼리가 실행되면 영속성 컨텍스트 안의 값을 가져온다.
//            // 반대도 마찬가지!
//
//            // 만약 영속성 컨텍스트가 초기화 된다면..????????????
//            em.flush();
//            em.clear();
//
//            Member RefMDetach = em.getReference(Member.class, member1.getId());  // 영속성 컨텍스트가 가져온 프록시 객체
//
//            em.detach(RefMDetach);  // clear() 도 가능.
//
//            System.out.println("RefMDetach detach() : " + RefMDetach.getName()); // could not initialize proxy [hellojpa.Member#2] - no Session
//                                                                                // -> 영속성 컨텍스트가 해제 되었으므로, 값을 가져올 수 없다.

            //////////////// 지연 로딩 : Member.class에서 Team 을 LAZY 설정 해야함
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setName("member");
//            member.setTeam(team);
//            em.persist(member);
//
//
//            em.flush();
//            em.clear();
//
//            Member m = em.find(Member.class, member.getId());
//
//            // 지연 로딩 : 프록시 객체가 넘어온다. 이거 중요 but) 만약, 즉시 로딩이면??
//            System.out.println("m Team : " + m.getTeam().getClass());
//
//            // 프록시 객체로 가져온 Team 데이터를 지연 로딩으로 실제 Team 을 사용하는 시점에서 쿼리를 동작시킨다. -> 프록시 객체를 미리 초기화 해두고, 쿼리가 실행되면 프록시 객체에 값을 갱신.
//            System.out.println("============");
//            // -> 지연 로딩 : 연관 관계의 데이터를 가져올 때, 실제 쿼리가 실행되면 연관 관계의 데이터를 가져오는 DB 쿼리를 실행시킨다.
//            // -> 즉시 로딩 : 앞의 Member 쿼리를 실행시킬 때, 연관 관계의 데이터까지 몽땅 가져온다. -> 필요없는 쿼리까지 조인 시켜서 가져온다.
//            System.out.println("teamName : " + m.getTeam().getName());
//            System.out.println("============");
//
//
//            /////// JPQL N + 1 문제
//            System.out.println("===== JPQL ======");
//
//            Team teamA = new Team();
//            team.setName("teamA");
//            em.persist(teamA);
//
//            Team teamB = new Team();
//            teamB.setName("teamB");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member.setName("member");
//            member.setTeam(teamA);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setName("member2");
//            member2.setTeam(teamB);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            //// 즉시 로딩 : N + 1 문제가 발생한다.
//            List<Member> members = em.createQuery("select m from Member m", Member.class)
//                            .getResultList();


            /////////////// 영속성 전이 (CASCADE)
            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            // 기존의 방식 코드 -> persist 를 갯수에 맞게 해야한다.
//            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);

            // cascade 방식을 추가하였을 때, Parent 에 cascade = CascadeType.ALL 를 추가.
            em.persist(parent); // -> child 도 연쇄적으로 persist 된다.
                                // -> 주의할 점 : child 가 parent 만 관계를 가질 때만 cascade를 사용해야한다. 만약 child가 다른 엔티티와도 관계를 가진다면? 절대 하지마;;;;;


            ///////// 고아 객체 -> orphanRemoval = true 옵션을 추가.
            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildList().remove(0);    // childList 에서 0번재 인덱스에 해당하는 데이터가 remove 된 데이터는 삭제된다.
//            em.remove(findParent);  // child 데이터가 전부 삭제된다.



            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
