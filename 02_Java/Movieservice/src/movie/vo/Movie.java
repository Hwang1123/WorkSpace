package movie.vo;


public class Movie {
	//private int MovNo;
	private String Title;
	private String Type;
	private String Director;
	private String RelYear;
	private int AgeLimit;
	
	public Movie() {
		super();
	}

	public Movie(String title, String type, String director, String relYear, int ageLimit) {
		super();
		this.Title = title;
		this.Type = type;
		this.Director = director;
		this.RelYear = relYear;
		this.AgeLimit = ageLimit;
	}



	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		this.Title = title;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		this.Type = type;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		this.Director = director;
	}

	public String getRelYear() {
		return RelYear;
	}

	public void setRelYear(String relYear) {
		this.RelYear = relYear;
	}
	

	public int getAgeLimit() {
		return AgeLimit;
	}

	public void setAgeLimit(int ageLimit) {
		this.AgeLimit = ageLimit;
	}

	@Override
	public String toString() {
		return "영화제목 : " + Title + ", 영화장르 : " + Type + ", 감독 : " + Director + ", 개봉년도 : " + RelYear 
				+ ", 연령제한 : " + AgeLimit;
	}
	
	
	
	

}
