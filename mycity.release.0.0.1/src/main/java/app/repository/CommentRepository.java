package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.model.Comment;
import app.model.Report;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query(value="SELECT * FROM COMMENT c WHERE LOWER(c.report_id) = LOWER(?1)",nativeQuery = true)
    public List<Comment> findByReport(@Param("report") Report report);
}