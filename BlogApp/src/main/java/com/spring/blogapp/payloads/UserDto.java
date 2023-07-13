package com.spring.blogapp.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private Integer id;
	
	@NotNull
	@NotEmpty
	@Size(min = 4, message="Username must be min of 4 charactors!!")
	private String name;
	
	@Email(message="Email address is not valid!!")
	private String email;
	
	@NotNull
	@NotEmpty
	@Size(min=6, max=12, message="Password must be min of 6 chars and max of 12 chars!!")
//	@Pattern(regexp=) 
	private String password;
	
	@NotNull
	@NotEmpty
	private String about;
	
}
