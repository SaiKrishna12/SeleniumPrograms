package day24;

public class DoubleDimensionalArrays {

	public static void main(String[] args) {
		Object[][] str=new Object[2][3];
		str[0][0]="selenium";
		str[0][1]=10;
		str[0][2]=15.56;
		
		str[1][0]=true;
		str[1][1]="codedui";
		str[1][2]="sopaui";
		
		
		for(int i=0;i<str.length;i++)
		{
			for(int j=0;j<str[i].length;j++)
			{
				System.out.print(str[i][j]+"   ");
			}
			System.out.println();
		}

	}

}
