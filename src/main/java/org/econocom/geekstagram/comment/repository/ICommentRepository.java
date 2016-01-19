package org.econocom.geekstagram.comment.repository;

import org.econocom.geekstagram.comment.CommentEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author marvin frachet 
 * Comment repository, extending CrudRepository from Spring
 */
public interface ICommentRepository extends CrudRepository<CommentEntity, Long> {

}
