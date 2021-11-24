package intango.test;

public class ColorVote {

	private Integer id;
	private String color;
	private int numberOfVotes;

	public ColorVote() {
		super();
	}

	public ColorVote(Integer id, String color, int numberOfVotes) {
		super();
		this.id = id;
		this.color = color;
		this.numberOfVotes = numberOfVotes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumberOfVotes() {
		return numberOfVotes;
	}

	public void setNumberOfVotes(int numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}

	@Override
	public String toString() {
		return "SquareColors [id=" + id + ", color=" + color + ", numberOfVotes=" + numberOfVotes + "]";
	}

}
