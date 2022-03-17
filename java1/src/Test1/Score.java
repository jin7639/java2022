package Test1;

public class Score {

	public static void main(String[] args) {
		
		int[] score = {3, 57, 39 , 80, 12 };
		
		for (int i = 0; i < score.length; i++) {
	        for (int j = 0; j < score.length-1; j++) {
	            //값을 바꾸는 코드
	            if (score[j]< score[j+1]) {
	                int temp = score[j];
	                score[j] = score[j+1];
	                score[j+1] = temp;
	            }
	        } 
		}
		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i]);
			}

		
		
	}
	
}
