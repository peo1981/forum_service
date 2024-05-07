package telran.java52.forum.dto;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class CommentDto {
	
	String user;                  // "Stranger",
    String message;               // "Awesome!!!",
    LocalDateTime dateCreated;    // "2021-12-15T14:11:55",
    Integer likes;                // 0
}
