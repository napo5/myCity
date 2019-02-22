package app.service;

import java.util.List;
import java.util.Optional;

import app.model.Comment;
import app.model.Report;

public interface CommentService {
	Comment createComment(Comment comment);

	Optional<Comment> getComment(Long id);
	
	Comment editComment(Comment comment);

	void deleteComment(Comment comment);

	void deleteComment(Long id);

	List<Comment> getAllComments();
	
	List<Comment> findByReport(Report report);
}