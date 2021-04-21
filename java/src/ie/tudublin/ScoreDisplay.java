package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	ArrayList<Note> notes = new ArrayList<Note>();

	//String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	public void loadScore()
	{
		//iterate over the string
		for(int i = 0 ; i <= (score.length()-1); i++)
		{
			
			char c = score.charAt(i);
			int number = 1;
			char letter = c;
			char check = c;

			//check is string iteration has reached last letter
			if(i >= (score.length()-1))
			{
				check = c;
			}
			else{
				check = score.charAt(i+1);
			}
			
			//check if character is letter or number then create Note object and add to the array
			if(Character.isDigit(check)){
				number = check - '0';
				i++;
			}
			else{
				letter = c;
				number = 1;
			}
			Note note = new Note(letter, number);
			notes.add(note);
		}
	}
	
	//print array
	public void printScore()
	{
		for(Note n:notes)
		{
			println(n);
		}
	}

	public void settings()
	{
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);

		loadScore();
		printScore();
	}

	public void setup() 
	{
		
	}

	public void draw()
	{
		background(255);
		
	}

	void drawNotes()
	{
	}
}
