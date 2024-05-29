package telran.java52.forum.dto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@ResponseStatus(HttpStatus.NOT_FOUND)

@NoArgsConstructor
public class PostNotFoundException extends RuntimeException  {
	private static final long serialVersionUID = 1L;
}
