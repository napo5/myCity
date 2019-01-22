package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Comment;
import app.model.Report;
import app.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentRepository commentRepository;


	@Override
	public Optional<Comment> getComment(Long id) {
		return commentRepository.findById(id);
	}

	@Override
	public Comment editComment(Comment person) {
		return commentRepository.save(person);
	}

	@Override
	public void deleteComment(Comment person) {
		commentRepository.delete(person);
	}

	@Override
	public void deleteComment(Long id) {
		commentRepository.deleteById(id);
	}


	@Override
	public List<Comment> getAllComments() {
		return commentRepository.findAll();
	}

	@Override
	public Comment createComment(Comment comment) {
		return commentRepository.save(comment);
	}
	
	public List<Comment> findByReport(Report report){
		return commentRepository.findByReport(report);
	}
}
