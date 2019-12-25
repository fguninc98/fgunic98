package dto;

public class TokenResponseDto {
	
	private String token;

	public TokenResponseDto(String token) {
		super();
		this.token = token;
	}
	
	public TokenResponseDto() {
		
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
