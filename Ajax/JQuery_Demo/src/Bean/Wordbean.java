package Bean;

public class Wordbean {
	private String words;
	private int id;
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Wordbean [words=" + words + ", id=" + id + "]";
	}
	
}
