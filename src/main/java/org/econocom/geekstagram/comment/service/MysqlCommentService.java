package org.econocom.geekstagram.comment.service;

import java.util.ArrayList;
import java.util.List;

import org.econocom.geekstagram.comment.CommentEntity;
import org.econocom.geekstagram.comment.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mysql")
public class MysqlCommentService implements ICommentService {

	@Autowired
	ICommentRepository repository;

	@Override
	public void add(CommentEntity com) {
		repository.save(com);
	}

	@Override
	public List<CommentEntity> getAll() {
		Iterable<CommentEntity> list = repository.findAll();
		List<CommentEntity> realList = new ArrayList<>();
		for (CommentEntity en : list) {
			realList.add(en);
		}
		return realList;
	}

	@Override
	public CommentEntity getById(long id) {
		return repository.findOne(id);
	}

	@Override
	public CommentEntity update(long id, CommentEntity entity) {
		CommentEntity current = this.getById(id);
		current.setContent(entity.getContent());
		current.setDate(entity.getDate());
		return repository.save(current);
	}

	@Override
	public void remove(long id) {
		repository.delete(id);
	}

}
