package telran.java52.post.dao;
import java.time.LocalDate;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.java52.forum.model.Post;
public interface PostRepository extends MongoRepository< Post,String>{

	//Stream <Post> findByAuthorIgnoreCase(String author);
	Stream<Post> findByAuthorIgnoreCase(String author);

	Stream <Post> findByTagsInIgnoreCase(String[] tags);

	Stream <Post> findByDateCreatedBetween(LocalDate dateFrom, LocalDate dateTo);
	

}
