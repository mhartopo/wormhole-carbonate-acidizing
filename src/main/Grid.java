package main;

public class Grid {
	private double velocity;
	private double fillRatio;
	private int iternum;
	
	public Grid(double velocity, double fillRatio) {
		this.velocity = velocity;
		this.fillRatio = fillRatio;
		iternum =-1;
	}
	//getter and setter
	public double getVelocity() {
		return velocity;
	}
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
	public boolean isFill() {
		return ( fillRatio >= 0.01 );
	}
	public double getFillRatio() {
		return fillRatio;
	}
	public void setFillRatio(double fillRatio) {
		this.fillRatio = fillRatio;
	}
	public int getIternum() {
		return iternum;
	}
	public void setIternum(int iternum) {
		this.iternum = iternum;
	}
	
}
