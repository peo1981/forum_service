package telran.java52.forum.comtroller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.java52.forum.dto.CommentAddDto;
import telran.java52.forum.dto.PeriodDto;
import telran.java52.forum.dto.PostAddDto;
import telran.java52.forum.dto.PostDto;
import telran.java52.forum.dto.PostUpdateDto;
import telran.java52.forum.service.ForumService;

@RestController
public class ForumController {

	ForumService forumService;

	@PostMapping("/forum/post/{author}")
	public PostDto addPost(@PathVariable String author, @RequestBody PostAddDto postAddDto) {

		return forumService.addPost(author, postAddDto);
	}

	@GetMapping("/forum/post/{postId}")
	public PostDto findPostById(@PathVariable String postId) {

		return forumService.findPostById(postId);
	}

	@PutMapping("/forum/post/{postId}/like")
	public void addLike(@PathVariable String postId) {
		forumService.addLike(postId);
		return;
	}

	@GetMapping("/forum/posts/author/{author}")
	public List<PostDto> findPostsByAuthor(@PathVariable String author) {

		return forumService.findPostsByAuthor(author);
	}

	@PutMapping("/forum/post/{postId}/comment/{author}")
	public PostDto addComment(@PathVariable String postId, @PathVariable String author,
			@RequestBody CommentAddDto commentAddDto) {

		return forumService.addComment(postId, author, commentAddDto);
	}

	@DeleteMapping("/forum/post/{postId}")
	public PostDto deletePost(@PathVariable String postId) {
		
		return forumService.deletePost(postId);
	}

	@PostMapping("/forum/posts/tags")
	public List<PostDto> findPostsByTag( @RequestBody String[] tags) {
	
		return forumService.findPostsByTag(tags);
	}

	@PostMapping("/forum/posts/period")
	public List<PostDto> findPostsByPeriod(@RequestBody PeriodDto periodDto) {
		
		return forumService.findPostsByPeriod(periodDto);
	}

	@PutMapping("/forum/post/{postId}")
	public PostDto updatePost(@PathVariable String postId, @RequestBody PostUpdateDto postUpdateDto) {
		
		return forumService.updatePost(postId, postUpdateDto);
	}

}
