package main;
import net.sourceforge.jFuzzyLogic.FIS;

public class FuzzyInference {
	private String FileName;
	private FIS fis;
	public FuzzyInference(String FileName) {
		this.FileName = FileName;
        fis = FIS.load(this.FileName,true);
        // Error while loading?
        if( fis == null ) { 
            System.err.println("Can't load file: '" + FileName + "'");
            return;
        }
	}
	
	public double getFill(double pfill, double vel, double prob) {
		updateVar(pfill, vel, prob);
		// Evaluate
        fis.evaluate();
        return fis.getVariable("fill").defuzzify();
	}

	public void updateVar(double pfill, double vel, double prob) {
		fis.setVariable("prefill", pfill);
        fis.setVariable("velocity", vel);
        fis.setVariable("probability", prob);
	}
	
}
