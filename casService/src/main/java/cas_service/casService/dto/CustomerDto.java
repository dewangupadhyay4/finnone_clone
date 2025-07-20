package cas_service.casService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDto {
	
	private Long id;
	private String name;
	private int age;
	private String email;
	private String phone;
	private String panCard;

}
