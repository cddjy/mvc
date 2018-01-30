package domain;

public class Car {
	
	private  Long length ;
	private Long width;
	private String type;

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public Long getWidth() {
		return width;
	}

	public void setWidth(Long width) {
		this.width = width;
	}

	public Car() {
	}

	public Car(Long length, Long width) {
		this.length = length;
		this.width = width;
	}


	protected void drive() {
		System.out.println("Car drive....");
	}
}
