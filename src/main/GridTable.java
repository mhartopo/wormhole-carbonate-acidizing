package main;

public class GridTable {
	private double criticalVelocity = 0.00001;
	private Grid[][] Table;
	private int Size;
	public FuzzyInference Finf;
	private boolean finishWormHole;
	public GridTable(int Size) {
		this.setSize(Size);
		setTable(new Grid[Size][Size]);
		//Masih contoh
		for (int i = 0; i < Size; i++) {
			for (int j = 0; j < Size; j ++) {
				if ((i%2 == 0) && (j%3 == 2)) {
					Table[i][j] = new Grid(10, 1);
				} else {
					Table[i][j] = new Grid(10, 0);
				}
			}
		}
	}
	public GridTable ( Grid[][] Table, int Size ) {
		this.setTable(Table);
		this.setSize(Size); 
	}
	public GridTable(InputFile in) {
		Finf = new FuzzyInference("FuzzyFile.fcl");
		in.Read();
		Size = in.getTableSize();
		setTable(new Grid[Size][Size]);
		for(int i = 0; i < Size; i++) {
			for(int j = 0; j < Size; j++) {
				Table[i][j] = new Grid(in.getData()[i][j], 0);
			}
		}
		Table[(Size-1)/2][(Size-1)/2].setVelocity(0);
		Table[(Size-1)/2][(Size-1)/2].setFillRatio(1);
		Table[(Size-1)/2][(Size-1)/2].setIternum(0);
		setFinishWormHole(false);
	}
	public int getSize() {
		return Size;
	}
	public void setSize(int size) {
		Size = size;
	}
	public Grid[][] getTable() {
		return Table;
	}
	public void setTable(Grid[][] table) {
		Table = table;
	}
	public double getTotalVelocity(int a, int b) {
		double sum = 0;
		for(int i = a-1; i <= a + 1; i++) {
			for(int j = b-1; j <= b + 1; j++) {
				sum += (Table[i][j]).getVelocity(); 
			}
		}
		return sum - (Table[a][b]).getVelocity();
	}
	public void PrintTable() {
		for (int i = 0; i < Size; i++) {
			for (int j = 0; j < Size; j ++) {
				System.out.print(Table[i][j].getFillRatio());
				System.out.print("|");
			}
			System.out.println("");
		}
	}
	
	//inferensi di titik awal
	public void calc(int a, int b, int iter) {
		double totalvel = getTotalVelocity(a,b);
		for(int i = a-1; i <= a+1; i++) {
			for(int j = b-1; j <= b+1; j++) {
				if(i != a || j != b) {
					if((Table[i][j].getIternum() == -1 || iter == Table[i][j].getIternum())) {
						if (Table[i][j].getVelocity() > criticalVelocity) {
							double prob = Table[i][i].getVelocity()/totalvel; 
							double fill = Finf.getFill(Table[a][b].getFillRatio(), Table[i][j].getVelocity(), prob);
							if(fill > Table[i][j].getFillRatio()) {
								(Table[i][j]).setFillRatio(fill);
								Table[i][j].setIternum(iter);
							}
						} else {
							Table[i][j].setIternum(iter);
						}
					} 
				}
			}
		}
	}
	
	public void computeWormHole() {
		int midArray = (Size -1)/2;
		for (int i = 0; i < (Size-1)/2; i++) {
			int dif = 2*i + 1;
			int startIdx = midArray - i;
			//atas
			int j = 0;
			while(j < dif) {
				if((Table[startIdx][startIdx+j].getVelocity()) > criticalVelocity || j == 0) {
					calc(startIdx,startIdx+j,i+1);
				} 
				j++;
			}
			//kanan
			j = 1;
			while (j < dif) {
				if((Table[startIdx+j][startIdx+dif-1].getVelocity()) > criticalVelocity) {
					calc(startIdx+j,startIdx+dif-1,i+1);
				} 
				j++;
			}
			//bawah
			j = 1;
			while (j < dif) {
				if((Table[startIdx+dif-1][startIdx -1 + j].getVelocity()) > criticalVelocity) {
					calc(startIdx+dif-1,startIdx+j-1,i+1);
				} 
				j++;
			}
			//kiri
			j = 1;
			while (j < dif-1) {
				if((Table[startIdx+dif-1 -j][startIdx].getVelocity()) > criticalVelocity) {
					calc(startIdx+dif-1-j,startIdx,i+1);
				} 
				j++;
			}
		}
		setFinishWormHole(true);
	}
	public boolean isFinishWormHole() {
		return finishWormHole;
	}
	public void setFinishWormHole(boolean finishWormHole) {
		this.finishWormHole = finishWormHole;
	}
	
}
