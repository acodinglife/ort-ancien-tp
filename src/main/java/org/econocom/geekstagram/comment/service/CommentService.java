package org.econocom.geekstagram.comment.service;

import java.util.ArrayList;
import java.util.List;

import org.econocom.geekstagram.comment.CommentEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fake")
public class CommentService implements ICommentService {

	public static List<CommentEntity> liste = new ArrayList<CommentEntity>();
	private static long id = 0;

	public void add(CommentEntity com) {
		id++;
		com.setId(id);
		liste.add(com);
	}

	public List<CommentEntity> getAll() {
		return liste;
	}

	public CommentEntity getById(long id) {

		for (CommentEntity ce : liste) {
			if (ce.getId() == id) {
				return ce;
			}
		}

		return null;
	}

	public CommentEntity update(long id, CommentEntity entity) {
		CommentEntity existing = this.getById(id);
		if (existing != null) {
			existing.setContent(entity.getContent());
			existing.setDate(entity.getDate());
		}

		return existing;
	}

	public void remove(long id) {
		CommentEntity existing = this.getById(id);

		if (existing != null) {
			liste.remove(existing);
		}

	}

}
