package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            // persist

            //영속성 컨텍스트2 Dirty Checking Test
            Member member = em.find(Member.class, 1L);
            member.setName("ZZZZZ");


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}


/*
영속성 컨텍스트

JPA를 이해하는데 가장 중요한 용어
엔티티를 영구 저장하는 환경

엔티티 매니저 ? 영속성 컨텍스트?

영속성 컨텍스트는 논리적인 개념 / 눈에 보이지 않는다?

엔티티 매니저 -> 영속성 컨텍스트에 접근

엔티티의 생명주기
비영속 -> 영속성 컨텍스트와 전혀 관계가 없는 새로운 상태  -> 새로운 ?
영속 - 영속성 컨텍스트에 관리되는 상태
준영속 -> 영속성 컨텍스트에 저장되었다가 분리된 상태
삭제 -> 삭제된 상태

 */