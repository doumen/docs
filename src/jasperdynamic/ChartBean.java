package jasperdynamic;

import java.awt.image.BufferedImage;

public class ChartBean {
	public ChartBean(BufferedImage image, String description) {
		setImage(image);
		setDescription(description);
	}

	private java.awt.image.BufferedImage image;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
}