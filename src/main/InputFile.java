package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputFile {
	private String FileName;
	private double[] Container;
	private int ContainerSize;
	private int DataSize;
	public InputFile(String FileName, int ContainerSize) {
		this.ContainerSize = ContainerSize;
		this.FileName = FileName;
		setData(new double[ContainerSize]);
		DataSize = 0;
	}
	
	public void Read() {
		BufferedReader br = null;
		String line = "";
		String splitBy = ",";
		int i = 0;
		try {
	
			br = new BufferedReader(new FileReader(FileName));
			while ((line = br.readLine()) != null && i <= ContainerSize) {
			    // use comma as separator
				String[] temp = line.split(splitBy);
				Container[i] = Double.parseDouble(temp[0]);
				i++;
			}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (br != null) {
				try {
					DataSize = i;
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public double[] getData() {
		return Container;
	}

	public void setData(double[] container) {
		Container = container;
	}

	public int getSize() {
		return DataSize;
	}

	public void setSize(int size) {
		DataSize = size;
	}
}
