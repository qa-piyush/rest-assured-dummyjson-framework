package pojo;

public class CreateProductRequest {

	private String title;
	private int price;

	public CreateProductRequest(String title, int price) {
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}
}
