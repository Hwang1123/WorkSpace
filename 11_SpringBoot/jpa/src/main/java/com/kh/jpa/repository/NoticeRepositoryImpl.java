package com.kh.jpa.repository;

import com.kh.jpa.entity.Member;
import com.kh.jpa.entity.Notice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NoticeRepositoryImpl implements NoticeRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Notice notice) {
        if (notice.getNoticeNo() == null) {
            em.persist(notice); // 새 엔티티 저장
        } else {
            em.merge(notice);   // 기존 엔티티 수정
        }
    }

    @Override
    public Optional<Notice> findOne(Long noticeNo) {
      return Optional.ofNullable(em.find(Notice.class, noticeNo));
    }

    @Override
    public void delete(Notice notice) {
        em.remove(em.contains(notice) ? notice : em.merge(notice));
    }

    @Override
    public List<Notice> findAll() {
        return em.createQuery("SELECT n FROM Notice n", Notice.class)
                .getResultList();
    }

    @Override
    public List<Notice> findByTitle(String title) {
        String query = "select n from Notice n where n.noticeTitle LIKE :noticetitle"; // %지원%
        return em.createQuery(query, Notice.class)
                .setParameter("noticetitle", "%" + title + "%")
                .getResultList();
    }
}
