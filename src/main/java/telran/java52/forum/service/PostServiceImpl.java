package telran.java52.forum.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java52.forum.dto.CommentAddDto;
import telran.java52.forum.dto.PeriodDto;
import telran.java52.forum.dto.PostAddDto;
import telran.java52.forum.dto.PostDto;
import telran.java52.forum.dto.PostUpdateDto;
import telran.java52.forum.dto.exception.PostNotFoundException;
import telran.java52.forum.model.Comment;
import telran.java52.forum.model.Post;
import telran.java52.post.dao.PostRepository;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements ForumService{

	final PostRepository postRepository;
	final ModelMapper modelMapper;
	
	@Override
	public PostDto addPost(String author, PostAddDto postAddDto) {
		Post post = modelMapper.map(postAddDto, Post.class);
		post.setAuthor(author);
		post =postRepository.save(post);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto findPostById(String id) {
		Post post = postRepository.findById(id).orElseThrow( PostNotFoundException :: new);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto deletePost(String id) {
		Post post = postRepository.findById(id).orElseThrow(PostNotFoundException :: new);
		postRepository.delete(post);
		return modelMapper.map(post, PostDto.class);
	}
	@Override
	public PostDto updatePost(String id, PostUpdateDto postUpdateDto) {
		Post post = postRepository.findById(id).orElseThrow(PostNotFoundException :: new);
		if(postUpdateDto.getTitle()!=null) {
			post.setTitle(postUpdateDto.getTitle());
		}
		if(postUpdateDto.getContent()!=null) {
			post.setContent(postUpdateDto.getContent());
		}if(postUpdateDto.getTags()!=null&&!postUpdateDto.getTags().isEmpty()) {
			post.getTags().addAll(postUpdateDto.getTags());
		}
		postRepository.save(post);
		
		return modelMapper.map(post, PostDto.class);
	}
	
	@Override
	public PostDto addComment(String id, String author, CommentAddDto commentAddDto) {
		Post post = postRepository.findById(id).orElseThrow(PostNotFoundException :: new);
		Comment comment= new Comment(author,commentAddDto.getMessage());
		post.addComments(comment);
		postRepository.save(post);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public void addLike(String postId) {
		Post post = postRepository.findById(postId).orElseThrow(PostNotFoundException :: new);
		post.addLike();
		postRepository.save(post);
		return;
		}

	@Override
	public List<PostDto> findPostsByAuthor(String author) {


		return postRepository.findByAuthorIgnoreCase(author).map(s->modelMapper.map(s,PostDto.class)).toList();
	}

	@Override
	public List<PostDto> findPostsByTag(String[] tags) {
		
	    return postRepository.findByTagsInIgnoreCase(tags).map(s->modelMapper.map(s,PostDto.class)).toList();
	}

	@Override
	public List<PostDto> findPostsByPeriod(PeriodDto periodDto) {
		
		return postRepository.findByDateCreatedBetween(periodDto.getDateFrom(),periodDto.getDateTo()).
				map(s->modelMapper.map(s,PostDto.class)).toList();
	}

	

}
