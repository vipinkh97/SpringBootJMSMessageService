package io.vipin.dtc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class FavouriteCar {

	@Id
	@NotNull
	private String id;
	@NotNull
	private String carName;
	@NotNull
	private String carColor;
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public FavouriteCar(String carName, String carColor) {
		super();
		this.carName = carName;
		this.carColor = carColor;
	}
	public FavouriteCar() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FavouriteCar [carName=" + carName + ", carColor=" + carColor + "]";
	}

}
