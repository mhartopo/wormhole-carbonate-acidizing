package main;

public class GridTable {
	private Grid[][] Table;
	private int Size;
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
	
	public void PrintTable() {
		for (int i = 0; i < Size; i++) {
			for (int j = 0; j < Size; j ++) {
				if (Table[i][j].getFillRatio() > 0.8) {
					System.out.print('*');
				} else {
					System.out.print('-');
				}
			}
			System.out.println("");
		}
	}
}
