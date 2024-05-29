package telran.java52.forum.dto;

import java.util.Set;

import lombok.Getter;

@Getter
public class PostUpdateDto {
	 
      String title;           //  "Jakarta EE",
      Set<String>tags;           // ["Jakarta EE", "J2EE"],
      String content;         //  "Java is the best for backend"

}
