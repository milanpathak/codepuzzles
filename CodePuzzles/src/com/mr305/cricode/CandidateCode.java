/**
 * Here m X n grid is given. Non-zero number specifies time to cross that street.
 * We have to find shortest path to travel from (0,0) cell to (m,n) cell
 * 
 * @auther mpathak
 * */
 
 
package com.mr305.cricode;

public class CandidateCode {

	public static int numberOfPath(int[] input1,int[] input2)
    {
		int rows =input1[0];
		int collumn =input1[1];
		int numbers[][] = new int [rows][collumn];
		for(int i=0,k=0; i<rows; i++){
			for (int j=0;j<collumn;j++){
				numbers[i][j]=input2[k];
				k++;
			}
		}
		int noOfWays = myRecur(numbers[0][0],0,0,numbers,0,rows-1,collumn-1);
		return noOfWays;
    }
	static int myRecur(int no,int row,int col,int[][] numbers,int noOfWays,int rowF,int colF){
		if(!(row>rowF || col > colF)){	
			switch(no){
			
				case 1:{
					//col+=1;
					if(row==rowF && col+1==colF)
						noOfWays++;
					else if (!(col+1>colF ))
						noOfWays=myRecur(numbers[row][col+1],row,col+1,numbers,noOfWays,rowF,colF);
					break;
				}case 4:{
					//row+=1;
					if(row+1==rowF && col==colF)
						noOfWays++;
					else if (!(row+1>rowF ))
						noOfWays=myRecur(numbers[row+1][col],row+1,col,numbers,noOfWays,rowF,colF);
					
					//col+=1;
					if(row==rowF && col+1==colF)
						noOfWays++;
					else if (!(col+1>colF ))
						noOfWays=myRecur(numbers[row][col+1],row,col+1,numbers,noOfWays,rowF,colF);
					break;
				}case 6:{
					//row+=1;
					if(row+1==rowF && col==colF)
						noOfWays++;
					else if (!(row+1>rowF ))
						noOfWays=myRecur(numbers[row+1][col],row+1,col,numbers,noOfWays,rowF,colF);
					
					//col+=1;
					//row+=1;
					if(row+1==rowF && col+1==colF)
						noOfWays++;
					else if(!(row+1>rowF || col+1>colF))
						noOfWays=myRecur(numbers[row+1][col+1],row+1,col+1,numbers,noOfWays,rowF,colF);
					break;
				}case 2:{
					//row+=1;
					if(row+1==rowF && col==colF)
						noOfWays++;
					else if (!(row+1>rowF ))
						noOfWays=myRecur(numbers[row+1][col],row+1,col,numbers,noOfWays,rowF,colF);
					break;
				}case 5:{
					//col+=1;
					if(row==rowF && col+1==colF)
						noOfWays++;
					else if (!(col+1>colF ))
						noOfWays=myRecur(numbers[row][col+1],row,col+1,numbers,noOfWays,rowF,colF);
					
					//col+=1;
					//row+=1;
					if(row+1==rowF && col+1==colF)
						noOfWays++;
					else if(!(row+1>rowF || col+1>colF ))
						noOfWays=myRecur(numbers[row+1][col+1],row+1,col+1,numbers,noOfWays,rowF,colF);
					break;
				}case 3:{
					//col+=1;
					//row+=1;
					if(row+1==rowF && col+1==colF)
						noOfWays++;
					else if(!(row+1>rowF || col+1>colF ))
						noOfWays=myRecur(numbers[row+1][col+1],row+1,col+1,numbers,noOfWays,rowF,colF);
					break;
				}case 7:{
					//col+=1;
					if(row==rowF && col+1==colF)
						noOfWays++;
					else if (!(col+1>colF ))
						noOfWays=myRecur(numbers[row][col+1],row,col+1,numbers,noOfWays,rowF,colF);
					
					//col+=1;
					//row+=1;
					if(row+1==rowF && col+1==colF)
						noOfWays++;
					else if(!(row+1>rowF || col+1>colF ))
						noOfWays=myRecur(numbers[row+1][col+1],row+1,col+1,numbers,noOfWays,rowF,colF);
					
					//row+=1;
					if(row+1==rowF && col==colF)
						noOfWays++;
					else if(!(row+1>rowF )) 
						noOfWays=myRecur(numbers[row+1][col],row+1,col,numbers,noOfWays,rowF,colF);
					break;
				}case 0:{
					return noOfWays;
				}
			
			}
		} 
		return noOfWays;
	}
	public static void main(String[] args) {
		int [] i1  = {4,6};
		int [] i2 = {1,3,0,0,0,0,0,0,4,5,1,0,0,0,0,6,7,6,0,0,0,0,5,0};
		
		numberOfPath(i1, i2);
	}
}
