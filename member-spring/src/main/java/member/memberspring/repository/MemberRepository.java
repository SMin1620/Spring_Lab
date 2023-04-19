package member.memberspring.repository;

import member.memberspring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); // 사용자가 저장되는 메서드
    Optional<Member> findById(Long id); // 저장된 사용자의 id를 찾는 메서드
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
