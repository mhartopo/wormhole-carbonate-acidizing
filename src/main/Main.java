package main;

public class Main {
	public static void main(String[] args) {
		InputFile in = new InputFile("velocity_data.csv", 101);
		GridTable GT = new GridTable(in);
    	GT.computeWormHole();
		DisplayWormHole main = new DisplayWormHole();
        main.display(GT.getTable(),GT.getSize());
    }
}