package com.app.quote;




public class Quote {

	
	private String anime;
	private String character;
	private String quote;
	
	Quote(){
		
		
		
	}
	
	Quote(String a,String c, String q){

		anime=a;
		character=c;
		quote=q;
		
	}

	public String getAnime() {
		return anime;
	}

	public void setAnime(String anime) {
		this.anime = anime;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	
	
	
	
}
