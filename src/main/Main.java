package main;

public class Main {
	public static void main (String[] args) {
		FuzzyInference Finf = new FuzzyInference("FuzzyFile.fcl");
		// fill, velocity, probability
        System.out.println(Finf.getFill(0, 0, 0.1));
        InputFile in = new InputFile("velocity_data.csv", 501);
        in.Read();
        
        System.out.println(in.getSize());
	}
}