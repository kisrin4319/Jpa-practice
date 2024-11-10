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

          Member member = new Member();
          member.setName("hello");

          em.persist(member);

          em.flush();
          em.clear();

          Member findMember = em.getReference(Member.class, member.getId());
          System.out.println("findMember = " + findMember.getClass());
          System.out.println("findMember.id = " + findMember.getId());
          System.out.println("findMember.name = " + findMember.getName());



        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getName();
        System.out.println("Name: " + username);

        Team team = member.get
    }
}


