package org.econocom.geekstagram.comment;

import org.econocom.geekstagram.comment.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author marvin frachet
 * @class CommentController
 */
@RestController
public class CommentController {

	/**
	 * Repository of the comments
	 */
	@Autowired
	@Qualifier("fake")
	private ICommentService commentService;

	@RequestMapping(method = RequestMethod.POST, value = "/comments")
	public String add(@RequestBody CommentEntity comment) {
		commentService.add(comment);
		return "Ca marche - " + comment.getContent();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/comments/{id}")
	public String delete(@PathVariable("id") long id) {
		commentService.remove(id);
		return "Remove ca marche - " + id;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/comments/{id}")
	public CommentEntity update(@PathVariable("id") long id, @RequestBody CommentEntity comment) {
		return commentService.update(id, comment);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/comments/{id}")
	public CommentEntity getById(@PathVariable("id") long id) {
		return commentService.getById(id);
	}

	/**
	 * Get the full list of comments
	 *
	 * @return The iterable with the resultSet of mysql
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/comments")
	public Iterable<CommentEntity> getAll() {
		return commentService.getAll();
	}
}
