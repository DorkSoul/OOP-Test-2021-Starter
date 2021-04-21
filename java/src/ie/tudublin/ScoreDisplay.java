package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	ArrayList<Note> notes = new ArrayList<Note>();

	String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	//String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

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

	private boolean isEnd = false;
	private int whichTask = -1;
	private int noteHeight;

	private float border = 200;
	private float noteSpace = 50;
	float leftBorder = 60;
	private char letter;

	void displayScore()
	{
		
		textSize(14);
		textAlign(LEFT,CENTER);
		
		
		textAlign(CENTER, CENTER);
		strokeWeight(2);
		stroke(0);
		
		//draw 5 lines across the screen evenly spaced
		for(int i = 1 ; i <= 5 ; i ++)
		{
			float y = map(i, 1, 5, border, height - border);
			line(leftBorder, y, width, y);
		}

		textAlign(LEFT, CENTER);

		//iterate through array and draw notes
		for(int i = 0 ; i < notes.size() ; i ++)
		{
			
			fill(0);
			noStroke();

			letter = notes.get(i).getNote();

			//set the note height
			noteHeight = letter == 'D' ? 10: noteHeight;
			noteHeight = letter == 'E' ? 9: noteHeight;
			noteHeight = letter == 'F' ? 8: noteHeight;
			noteHeight = letter == 'G' ? 7: noteHeight;
			noteHeight = letter == 'A' ? 6: noteHeight;
			noteHeight = letter == 'B' ? 5: noteHeight;
			noteHeight = letter == 'c' ? 4: noteHeight;
			noteHeight = letter == 'd' ? 3: noteHeight;
			
			//draw the note
			float y1 = map(noteHeight, 1, 10, border, height - border + 10);
			float  x1 = leftBorder + noteSpace * i;
			circle(x1, y1, 20);

			strokeWeight(4);
			stroke(0);
			line(x1+10, y1, x1+10, y1 - 50);

			//draw tick if quaver
			if(notes.get(i).getDuration() == 1){
				line(x1+10, y1 - 50, x1+30, y1 - 40);
			}

			//draw note letters
			// textAlign(CENTER, CENTER);
			// text(str, x, y);
			
			

			

			
		
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
		colorMode(HSB);
	}

	public void draw()
	{
		background(255);
		displayScore();
	}

	void drawNotes()
	{
		
	}
}
