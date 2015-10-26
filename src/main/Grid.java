package main;

public class Grid {
	private float velocity;
	private float fillRatio;
	private int iternum;
	
	public Grid(float velocity, float fillRatio) {
		this.velocity = velocity;
		this.fillRatio = fillRatio;
		iternum =-1;
	}
	//getter and setter
	public float getVelocity() {
		return velocity;
	}
	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}
	public boolean isFill() {
		return ( fillRatio >= 0.01 );
	}
	public float getFillRatio() {
		return fillRatio;
	}
	public void setFillRatio(float fillRatio) {
		this.fillRatio = fillRatio;
	}
	public int getIternum() {
		return iternum;
	}
	public void setIternum(int iternum) {
		this.iternum = iternum;
	}
	
}
