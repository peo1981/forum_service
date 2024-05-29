package telran.java52.forum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import telran.java52.forum.dto.CommentAddDto;
import telran.java52.forum.dto.PeriodDto;
import telran.java52.forum.dto.PostAddDto;
import telran.java52.forum.dto.PostDto;
import telran.java52.forum.dto.PostUpdateDto;
@Service
public interface ForumService {
	
		PostDto addPost (String author, PostAddDto postAddDto);
	
		PostDto findPostById(String postId);
	
		void addLike(String postId);
		
		PostDto updatePost (String postId, PostUpdateDto postUpdateDto);
		
		PostDto addComment (String postId, String author, CommentAddDto commentAddDto);
		
		PostDto deletePost(String postId);
		
		List<PostDto> findPostsByAuthor(String author);
		
		List<PostDto> findPostsByTag(String[]tags);
		
		List<PostDto> findPostsByPeriod(PeriodDto periodDto);
		
		
	

}
