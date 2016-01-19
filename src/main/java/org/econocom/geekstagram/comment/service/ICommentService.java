package org.econocom.geekstagram.comment.service;

import java.util.List;

import org.econocom.geekstagram.comment.CommentEntity;

public interface ICommentService{

  public void add(CommentEntity com);
  public List<CommentEntity> getAll();
  public CommentEntity getById(long id);
  public CommentEntity update(long id, CommentEntity entity);
  public void remove(long id);

}
