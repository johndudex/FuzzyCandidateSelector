package FuzzyCandidateSelection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Sqltest {

	static double a[]={0.23,0.24,0.19,0.16,0.18};
	//int a[][]=new int[3][21];
	static int HS=4,GS=5,US=4,PS=4,IS=4,NoM=5;
	static int humanSkills[][] =new int[4][5];
	static int GeneralSkills[][]=new int [5][5];
	static int urbanskills [][]=new int [4][5];
	static int Personalskills [][]=new int [4][5];
	static int InterractionSkills[][]=new int [4][5];
	
	static double humanSkills1[][] =new double[4][5];
	static double GeneralSkills1[][]=new double[5][5];
	static double urbanskills1[][]=new double [4][5];
	static double Personalskills1 [][]=new double [4][5];
	static double InterractionSkills1[][]=new double [4][5];
	
	static double humanSkillArray[]=new double[HS];
	static double GeneralSkillArray[]=new double[GS];
	static double urbanSkillArray[]=new double[US];
	static double PersonalSkillArray[]=new double[PS];
	static double InterractionSkillArray[]=new double[IS];
	
	static double Criteria[]=new double[5],CriteriaFuzzMatrix[][]=new double[5][5];
	
	double temp[][]=new double[5][4],temp1[]=new double[5];
	
	static int arr[]= new int[5];
	static int m=5;
	static ResultSet ts;
	static int count=0,i,j;
	public static double Compute(String adhaar) throws SQLException
	{
		
		getSubMeanScores();
		getCriteriaScores();
		
		
		Connection con=DataManager.getConnection();
		String name="select * from rating where adhaar='"+adhaar+"'";
		ResultSet rs=DataManager.retrieveData(name, con);ts=rs;
		
		while(rs.next())
		{
			
			for(i=0;i<HS;i++)
				humanSkills[i][count]=rs.getInt(i+1);
			
			for(j=i;j<HS+GS;j++)
				GeneralSkills[j-i][count]=rs.getInt(j+1);
			
			for(i=j;i<HS+GS+US;i++)
				urbanskills[i-j][count]=rs.getInt(i+1);
			
			for(j=i;j<HS+GS+US+PS;j++)
				Personalskills[j-i][count]=rs.getInt(j+1);
			
			for(i=j;i<HS+GS+US+PS+IS;i++)
				InterractionSkills[i-j][count]=rs.getInt(i+1);
			count++;
			
		}
		fuzzification();
		//Forming the Collaborated Matrix 
		
		double[] temp=Fuzzy.fuzz(humanSkillArray,humanSkills1,NoM,HS);
		for(int i=0;i<5;i++)
			CriteriaFuzzMatrix[0][i]=temp[i];
		
		temp=Fuzzy.fuzz(GeneralSkillArray,GeneralSkills1,NoM,GS);
		for(int i=0;i<5;i++)
			CriteriaFuzzMatrix[1][i]=temp[i];
		
		temp=Fuzzy.fuzz(urbanSkillArray,urbanskills1,NoM,US);
		for(int i=0;i<5;i++)
			CriteriaFuzzMatrix[2][i]=temp[i];
		
		temp=Fuzzy.fuzz(PersonalSkillArray,Personalskills1,NoM,PS);
		for(int i=0;i<5;i++)
			CriteriaFuzzMatrix[3][i]=temp[i];
		
		temp=Fuzzy.fuzz(InterractionSkillArray,InterractionSkills1,NoM,IS);
		for(int i=0;i<5;i++)
			CriteriaFuzzMatrix[4][i]=temp[i];
	
		temp=Fuzzy.fuzz(Criteria, CriteriaFuzzMatrix, 5, 5);
		//for(int i=0;i<5;i++)
			//System.out.print(temp[i]+"  ");
		double FuzzyScore=0,sum=0;
		for(int i=0;i<5;i++)
		{	
			double x=i;
			FuzzyScore+=temp[i]*(((x+1)/5)*100);
			
			sum+=temp[i];
		}
		FuzzyScore=(double)Math.round((FuzzyScore/sum)*100)/100;
		//System.out.println(FuzzyScore);
		/*
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++)
				System.out.print(CriteriaFuzzMatrix[i][j]+ " ");
				System.out.println("");
		
		}
		*/
		return FuzzyScore;
	}
	
	
	
	
	
	
	
	private static void getCriteriaScores() throws SQLException {
		Connection con=DataManager.getConnection();
		String Query="select *from criteria";
		ResultSet rs=DataManager.retrieveData(Query, con);
		while(rs.next()){
			for(int i=0;i<5;i++){
				Criteria[i]=(double)Math.round(rs.getInt(i+1))/100;
				
			}
		}
		
	}
	private static void getSubMeanScores() throws SQLException {
	
		Connection con=DataManager.getConnection();
		String Query="Select *from sub_criteria";
		
		ResultSet rs=DataManager.retrieveData(Query, con);
		while(rs.next()){
			int i,j;
			for(i=1;i<=HS;i++)
				humanSkillArray[i-1]=(double)Math.round(rs.getInt(i))/100;
			for(j=i;j<=HS+GS;j++)
				GeneralSkillArray[j-i]=(double)Math.round(rs.getInt(j))/100;
			for(i=j;i<=HS+GS+US;i++)
				urbanSkillArray[i-j]=(double)Math.round(rs.getInt(i))/100;
			for(j=i;j<=HS+GS+US+PS;j++)
				PersonalSkillArray[j-i]=(double)Math.round(rs.getInt(j))/100;
			for(i=j;i<=HS+GS+US+PS+IS;i++)
				InterractionSkillArray[i-j]=(double)Math.round(rs.getInt(i))/100;
			
			
			
			
			
			
			
			
			
			
		}
		
		
	}
	private static void fuzzification() {
		// TODO Auto-generated method stub
		initialize();
		
		for(i=0;i<HS;i++)
			{
			initialize();
			for(j=0;j<m;j++)
			{
				//System.out.println(humanSkills[i][j]-1);
				arr[(humanSkills[i][j])-1]++;
			}
			for(j=0;j<m;j++){
				double temp=(double)arr[j]/m;
				humanSkills1[i][m-j-1]=(double)Math.round(temp*100)/100;
						
			}
			}
		for(i=0;i<GS;i++)
		{
		initialize();
		for(j=0;j<m;j++)
		{
			//System.out.println(humanSkills[i][j]-1);
			arr[(GeneralSkills[i][j])-1]++;
		}
		for(j=0;j<m;j++){
			double temp=(double)arr[j]/m;
			GeneralSkills1[i][m-j-1]=(double)Math.round(temp*100)/100;
					
		}
		}
		
		for(i=0;i<US;i++)
		{
		initialize();
		for(j=0;j<m;j++)
		{
			//System.out.println(humanSkills[i][j]-1);
			arr[(urbanskills[i][j])-1]++;
		}
		for(j=0;j<m;j++){
			double temp=(double)arr[j]/m;
			urbanskills1[i][m-j-1]=(double)Math.round(temp*100)/100;
					
		}
		}
		for(i=0;i<PS;i++)
		{
		initialize();
		for(j=0;j<m;j++)
		{
			//System.out.println(humanSkills[i][j]-1);
			arr[(Personalskills[i][j])-1]++;
		}
		for(j=0;j<m;j++){
			double temp=(double)arr[j]/m;
			Personalskills1[i][m-j-1]=(double)Math.round(temp*100)/100;
					
		}
		}
		for(i=0;i<IS;i++)
		{
		initialize();
		for(j=0;j<m;j++)
		{
			//System.out.println(humanSkills[i][j]-1);
			arr[(InterractionSkills[i][j])-1]++;
		}
		for(j=0;j<m;j++){
			double temp=(double)arr[j]/m;
			InterractionSkills1[i][m-j-1]=(double)Math.round(temp*100)/100;
					
		}
		}
	}
	private static void initialize() {
		// TODO Auto-generated method stub
		for(int i=0;i<m;i++)
			arr[i]=0;
	}
	
	
}
