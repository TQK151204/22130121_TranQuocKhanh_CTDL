package Lab_3;

public class OderItem implements Comparable<OderItem> {
	private Product p;
	private int quality;

	public OderItem(Product p, int quality) {
		super();
		this.p = p;
		this.quality = quality;
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public double getPrice() {
		return p.getPrice();
	}

	public String getName() {
		return p.getName();
	}

	public String getId() {
		return p.getId();
	}

	@Override
	public int compareTo(OderItem o) {

		return this.getP().compareTo(o.getP());
	}

	@Override
	public String toString() {
		return "" + this.getPrice() + this.getP().toString();
	}

	public int compareByType(OderItem o2) {
		return this.getP().compareByType(o2.getP());
	}

}
