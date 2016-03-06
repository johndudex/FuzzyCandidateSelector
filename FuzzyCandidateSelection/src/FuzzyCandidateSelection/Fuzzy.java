package FuzzyCandidateSelection;

import java.sql.SQLException;

public class Fuzzy {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
		
		double a[]={0.28 ,0.22 ,0.27, 0.23};
		double b[][]={{0.4,	0.6,	0.0,	0.0,	0.0	},
					  {0.2,	0.2,	0.2,	0.2,	0.2},
					  {0.2,	0.2,	0.2,	0.4,	0.0},
					  {0.4,	0.2,	0.2,	0.2,	0.0}};
	//	int count =0;
		
		double temp[]=fuzz(a,b,5,4);
	
		System.out.println("\n"+Sqltest.Compute("098765432109"));
	}

	public static double[] fuzz(double[] a, double[][] b,int NoM,int NoE) {
		// TODO Auto-generated method stub
		double temp[][]=new double[NoM][NoE],temp1[]=new double[5];
		for(int i=0;i<NoM;i++)
		{
			for(int j=0;j<NoE;j++)
			{
				if(a[j]<b[j][i])
					temp[i][j]=a[j];
				else
					temp[i][j]=b[j][i];
			}
		
			double max=temp[i][0];
			for(int j=0;j<4;j++)
			if(max<temp[i][j])
			max=temp[i][j];
			temp1[i]=max;
				
			
		}
		
		
		return temp1;
		
		
	}
	
}
