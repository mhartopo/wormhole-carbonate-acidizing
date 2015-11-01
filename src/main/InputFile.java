package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputFile {
	private String FileName;
	private double[][] Container;
	private int ContainerSize;
	private int DataSize;
	public InputFile(String FileName, int ContainerSize) {
		this.ContainerSize = ContainerSize;
		this.FileName = FileName;
		setData(new double[ContainerSize][ContainerSize]);
		DataSize = 0;
	}
	
	public void Read() {
		boolean endfile = false;
		BufferedReader br = null;
		String line = "";
		String splitBy = ",";
		int midArray = (ContainerSize - 1) / 2;
		int i = 0;
		int count =0;
		try {
			br = new BufferedReader(new FileReader(FileName));
			Container[midArray][midArray] = 0;
			for (i = 1; i < (ContainerSize + 1)/2 ; i++) {
				int dif = 2*i + 1;
				int startIdx = midArray - i;
				int j = 0;
				while ( j < dif && !endfile) {
				    if ((line = br.readLine()) != null) {
				    	// use comma as separator
				    	String[] temp = line.split(splitBy);
				    	Container[startIdx][startIdx+j] = Double.parseDouble(temp[0]);
				    	j++;
				    	count++;
				    } else {
				    	endfile = true;
				    }
				}
				j = 1;
				while (j < dif && !endfile) {
					if ((line = br.readLine()) != null) {
						// use comma as separator
						String[] temp = line.split(splitBy);
						Container[startIdx+j][startIdx+dif-1] = Double.parseDouble(temp[0]);
						
						j++;
						count++;
					} else {
				    	endfile = true;
				    }
				}
				
				j = 1;
				while (j < dif && !endfile) {
					if ((line = br.readLine()) != null) {
						// use comma as separator
						String[] temp = line.split(splitBy);
						Container[startIdx+dif-1][startIdx+dif -1 - j] = Double.parseDouble(temp[0]);
						j++;
						count++;
					} else {
				    	endfile = true;
				    }
				}
				
				j = 1;
				while (j < (dif - 1) && !endfile) {
					if ((line = br.readLine()) != null) {
						// use comma as separator
						String[] temp = line.split(splitBy);
						Container[startIdx+dif-1 -j][startIdx] = Double.parseDouble(temp[0]);
						j++;
						count++;
					} else {
				    	endfile = true;
				    }
				}
			}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (br != null) {
				try {
					DataSize = count;
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public double[][] getData() {
		return Container;
	}

	public void setData(double[][] container) {
		Container = container;
	}

	public int getSize() {
		return DataSize;
	}

	public void setSize(int size) {
		DataSize = size;
	}
	
	public int getTableSize() {
		return ContainerSize;
	}
	public void print() {
		for(int i = 0; i < ContainerSize; i++) {
			for(int j = 0; j < ContainerSize; j++) {
				System.out.print(Container[i][j]);
			}
			System.out.println();
		} 
	}
}
