package com.api.dto;

public class Intervals {
	

	
	public void JednaSekunda(JokeDto jokeDto) {
		jokeDto.setInterval(1000);
	}
	
	public void DesetSekundi(JokeDto jokeDto) {
		jokeDto.setInterval(10000);
	}
	
	public void Minut(JokeDto jokeDto) {
		jokeDto.setInterval(60000);
	}
	
	public void DesetMinuta(JokeDto jokeDto) {
		jokeDto.setInterval(600000);
	}
	
	public void SatVremena(JokeDto jokeDto) {
		jokeDto.setInterval(600000);
	}

}
