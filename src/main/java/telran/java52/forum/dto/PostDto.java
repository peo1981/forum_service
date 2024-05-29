package telran.java52.forum.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {

	   String id;                  // "61b86639905cb348d52a138d",
	   String title;               // "JavaEE",
	   String content;             //"Java is the best for backend",
	   String author;              // "JavaFan",
	   LocalDateTime dateCreated;  // "2021-12-14T11:39:05",
	   @Singular
	   Set<String> tags;             //[ "Java","backend","JEE","Spring"],
	   Integer likes;              // 0,
	   @Singular
	   List<CommentDto> comments;           // []
	
}
