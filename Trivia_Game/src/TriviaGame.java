import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TriviaGame extends JFrame implements ActionListener {
	
	JPanel pinkPanel;
	JPanel pink1Panel;
	JPanel pink2Panel;
	JPanel pink3Panel;
	JPanel pink4Panel;
	
	JPanel pinkPanel2;
	JPanel pink1Panel2;
	JPanel pink2Panel2;
	JPanel pink3Panel2;
	JPanel pink4Panel2;
	
	Color pink = new Color(255, 192, 203);
	Color pink1 = new Color(255, 181, 197);
	Color pink2 = new Color(238, 169, 184);
	Color pink3 = new Color(205, 145, 158);
	Color pink4 = new Color(139, 99, 108);
	
	JPanel decoration;
	JPanel decoration2;
	JPanel choices;
	JPanel topPanel;
	JPanel middlePanel;
	JPanel bottomPanel;
	JPanel quitORplay;
	
	JLabel playORquit;
	JLabel welcome;
	JLabel questionNum;
	JLabel question;
	JLabel wrongAnswer;
	JLabel total;
	JLabel totalHeading;
	
	JButton play;
	JButton quit;
	JButton cont;
	
	Font fontObject;
	Font fontObject2;
	
	int questionNumber = 0;
	int totalPoints = 0;
	
	private String[] questions = {
			"<html><p>1. What are the primary colors?<br>a) red, yellow, blue<br>b) red, green, blue<br>c) orange, green, purple</p></html>",
			"<html><p>2. What does the 'c' in the equation E = mc^2 represent?<br>a) a constant<br>b) the speed of light<br>c) none of the above</p></html>",
			"<html><p>3. In the game Othello, which color goes first?<br>a) white<br>b) black<br>c) It doesn't matter</p></html>",
			"<html><p>4. How many books make up the Chronicles of Narnia?<br>a) 5<br>b) 10<br>c) 7</p></html>",
			"<html><p>5. How many seasons does Stargate SG-1 have?<br>a) 9<br>b) 12<br>c) 10</p></html>"};
	private String[] answers = {"A", "B", "A", "C", "C"};
	private int[] pointValues = {1, 1, 2, 3, 3};
	
	public TriviaGame() {
		super("Trivia Game");
		
		setSize(1000, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
	
		getContentPane().setBackground(pink);
		decoration = new JPanel();
		decoration.setLayout(new GridLayout(5, 1));
		add(decoration, BorderLayout.EAST);
		decoration2 = new JPanel();
		decoration2.setLayout(new GridLayout(5, 1));
		add(decoration2, BorderLayout.WEST);
		
		pinkPanel = new JPanel();
		pink1Panel = new JPanel();
		pink2Panel = new JPanel();
		pink3Panel = new JPanel();
		pink4Panel = new JPanel();
		
		pinkPanel2 = new JPanel();
		pink1Panel2 = new JPanel();
		pink2Panel2 = new JPanel();
		pink3Panel2 = new JPanel();
		pink4Panel2 = new JPanel();
		
		pinkPanel.setBackground(pink);
		pink1Panel.setBackground(pink1);
		pink2Panel.setBackground(pink2);
		pink3Panel.setBackground(pink3);
		pink4Panel.setBackground(pink4);
		
		pinkPanel2.setBackground(pink);
		pink1Panel2.setBackground(pink1);
		pink2Panel2.setBackground(pink2);
		pink3Panel2.setBackground(pink3);
		pink4Panel2.setBackground(pink4);
		
		decoration.add(pinkPanel);
		decoration.add(pink1Panel);
		decoration.add(pink2Panel);
		decoration.add(pink3Panel);
		decoration.add(pink4Panel);
		
		decoration2.add(pinkPanel2);
		decoration2.add(pink1Panel2);
		decoration2.add(pink2Panel2);
		decoration2.add(pink3Panel2);
		decoration2.add(pink4Panel2);
		
		decoration.setVisible(true);
		decoration2.setVisible(true);

		quitORplay = new JPanel();
		quitORplay.setLayout(new GridLayout(1, 2));
		
		play = new JButton("Play Game?");
		play.setBackground(pink);
		play.addActionListener(this);
		
		quit = new JButton("Quit?");
		quit.setBackground(pink4);
		quit.addActionListener(this);
		
		quitORplay.add(play);
		quitORplay.add(quit);
		
		fontObject = new Font("Times New Roman", Font.PLAIN, 25);
		fontObject2 = new Font("Times New Roman", Font.PLAIN, 20);
		setFont(fontObject);
		welcome = new JLabel("Welcome to 5 Simple Questions!", SwingConstants.CENTER);
		welcome.setFont(fontObject);
		
		playORquit = new JLabel("Do you want to play?", SwingConstants.CENTER);
		playORquit.setFont(fontObject2);
		
		choices = new JPanel();
		choices.setLayout(new GridLayout(1, 3));
		JButton aButton = new JButton("A");
		JButton bButton = new JButton("B");
		JButton cButton = new JButton("C");
		aButton.setBackground(pink1);
		bButton.setBackground(pink2);
		cButton.setBackground(pink3);
		aButton.addActionListener(this);
		bButton.addActionListener(this);
		cButton.addActionListener(this);
		choices.add(aButton);
		choices.add(bButton);
		choices.add(cButton);
		questionNum = new JLabel();
		questionNum.setText("Question " + (questionNumber + 1));
		questionNum.setFont(fontObject);
		question = new JLabel();
		question.setText(questions[questionNumber]);
		question.setFont(fontObject);
		
		//create wrong window
		wrongAnswer = new JLabel();
		wrongAnswer.setText("Incorrect! The correct answer is: " + answers[questionNumber]);
		wrongAnswer.setFont(fontObject);
		cont = new JButton("Continue...");
		cont.addActionListener(this);
		cont.setBackground(pink2);
		//create total points window
		totalHeading = new JLabel("Total");
		totalHeading.setFont(fontObject);
		total = new JLabel();
		total.setText("Total Points: " + totalPoints);
		total.setFont(fontObject2);
		
		
		topPanel = new JPanel();
		topPanel.setBackground(pink);
		topPanel.setLayout(new GridLayout(3, 1)); //for welcome message and question number
		topPanel.add(welcome);
		topPanel.add(questionNum);
		topPanel.add(totalHeading);
		add(topPanel, BorderLayout.NORTH);
		
		welcome.setVisible(true);
		questionNum.setVisible(false);
		totalHeading.setVisible(false);
		
		middlePanel = new JPanel();
		middlePanel.setBackground(pink2);
		middlePanel.setLayout(new GridLayout(4, 1)); //for question, do you want to play, and total points message
		middlePanel.add(playORquit);
		middlePanel.add(question);
		middlePanel.add(wrongAnswer);
		middlePanel.add(total);
		add(middlePanel, BorderLayout.CENTER);
		
		question.setVisible(false);
		playORquit.setVisible(true);
		wrongAnswer.setVisible(false);
		total.setVisible(false);
		
		bottomPanel = new JPanel();
		bottomPanel.setBackground(pink4);
		bottomPanel.setLayout(new GridLayout(3, 1)); //for begin and play game button and multiple choice buttons
		bottomPanel.add(quitORplay);
		bottomPanel.add(choices);
		bottomPanel.add(cont);
		add(bottomPanel, BorderLayout.SOUTH);
		
		quitORplay.setVisible(true);
		choices.setVisible(false);
		cont.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Play Game?")) {
			welcome.setVisible(false);
			questionNum.setVisible(true);
			totalHeading.setVisible(false);
			
			question.setVisible(true);
			playORquit.setVisible(false);
			wrongAnswer.setVisible(false);
			total.setVisible(false);
			
			quitORplay.setVisible(false);
			choices.setVisible(true);
			cont.setVisible(false);
		}
		else if (e.getActionCommand().equals("Quit?")) {
			System.exit(0);
		}
		else if (e.getActionCommand().equals("A")) {
			if (answers[questionNumber] == "A") {
				totalPoints = totalPoints + pointValues[questionNumber];
				questionNumber++;
				if (questionNumber >= 5) {
					welcome.setVisible(false);
					questionNum.setVisible(false);
					questionNum.setText("Question " + (questionNumber + 1));
					totalHeading.setVisible(true);
				
					question.setVisible(false);
					playORquit.setVisible(false);
					wrongAnswer.setVisible(false);
					total.setVisible(true);
					total.setText("Total Points: " + totalPoints);
				
					quitORplay.setVisible(false);
					choices.setVisible(false);
					cont.setVisible(false);
				}
				else {
					welcome.setVisible(false);
					questionNum.setVisible(true);
					
					totalHeading.setVisible(false);
				
					question.setVisible(true);
					question.setText(questions[questionNumber]);
					playORquit.setVisible(false);
					wrongAnswer.setVisible(false);
					total.setVisible(false);
				
					quitORplay.setVisible(false);
					choices.setVisible(true);
					cont.setVisible(false);
				}
			}
			else {
				welcome.setVisible(false);
				questionNum.setVisible(false);
				totalHeading.setVisible(false);
				
				question.setVisible(false);
				playORquit.setVisible(false);
				wrongAnswer.setVisible(true);
				wrongAnswer.setText("Incorrect! The correct answer is: " + answers[questionNumber]);
				total.setVisible(false);
				
				quitORplay.setVisible(false);
				choices.setVisible(false);
				cont.setVisible(true);
			}
		}
		else if (e.getActionCommand().equals("B")) {
			if (answers[questionNumber] == "B") {
				totalPoints = totalPoints + pointValues[questionNumber];
				questionNumber++;
				if (questionNumber >= 5) {
					welcome.setVisible(false);
					questionNum.setVisible(false);
					questionNum.setText("Question " + (questionNumber + 1));
					totalHeading.setVisible(true);
				
					question.setVisible(false);
					playORquit.setVisible(false);
					wrongAnswer.setVisible(false);
					total.setVisible(true);
					total.setText("Total Points: " + totalPoints);
				
					quitORplay.setVisible(false);
					choices.setVisible(false);
					cont.setVisible(false);
				}
				else {
					welcome.setVisible(false);
					questionNum.setVisible(true);
					
					totalHeading.setVisible(false);
				
					question.setVisible(true);
					question.setText(questions[questionNumber]);
					playORquit.setVisible(false);
					wrongAnswer.setVisible(false);
					total.setVisible(false);
				
					quitORplay.setVisible(false);
					choices.setVisible(true);
					cont.setVisible(false);
				}
			}
			else {
				welcome.setVisible(false);
				questionNum.setVisible(false);
				totalHeading.setVisible(false);
				
				question.setVisible(false);
				playORquit.setVisible(false);
				wrongAnswer.setVisible(true);
				wrongAnswer.setText("Incorrect! The correct answer is: " + answers[questionNumber]);
				total.setVisible(false);
				
				quitORplay.setVisible(false);
				choices.setVisible(false);
				cont.setVisible(true);
			}
		}
		else if (e.getActionCommand().equals("C")) {
			if (answers[questionNumber] == "C") {
				totalPoints = totalPoints + pointValues[questionNumber];
				questionNumber++;
				if (questionNumber >= 5) {
					welcome.setVisible(false);
					questionNum.setVisible(false);
					questionNum.setText("Question " + (questionNumber + 1));
					totalHeading.setVisible(true);
				
					question.setVisible(false);
					playORquit.setVisible(false);
					wrongAnswer.setVisible(false);
					total.setVisible(true);
					total.setText("Total Points: " + totalPoints);
				
					quitORplay.setVisible(false);
					choices.setVisible(false);
					cont.setVisible(false);
				}
				else {
					welcome.setVisible(false);
					questionNum.setVisible(true);
					
					totalHeading.setVisible(false);
				
					question.setVisible(true);
					question.setText(questions[questionNumber]);
					playORquit.setVisible(false);
					wrongAnswer.setVisible(false);
					total.setVisible(false);
				
					quitORplay.setVisible(false);
					choices.setVisible(true);
					cont.setVisible(false);
				}
			}
			else {
				welcome.setVisible(false);
				questionNum.setVisible(false);
				totalHeading.setVisible(false);
				
				question.setVisible(false);
				playORquit.setVisible(false);
				wrongAnswer.setVisible(true);
				wrongAnswer.setText("Incorrect! The correct answer is: " + answers[questionNumber]);
				total.setVisible(false);
				total.setText("Total Points: " + totalPoints);
				
				quitORplay.setVisible(false);
				choices.setVisible(false);
				cont.setVisible(true);
			}
		}
		else if (e.getActionCommand().equals("Continue...")) {
			if (questionNumber >= 4) {
				welcome.setVisible(false);
				questionNum.setVisible(false);
				totalHeading.setVisible(true);
			
				question.setVisible(false);
				playORquit.setVisible(false);
				wrongAnswer.setVisible(false);
				total.setVisible(true);
				total.setText("Total Points: " + totalPoints);
			
				quitORplay.setVisible(false);
				choices.setVisible(false);
				cont.setVisible(false);
			}
			else {
				questionNumber++;
				welcome.setVisible(false);
				questionNum.setVisible(true);
				questionNum.setText("Question " + (questionNumber + 1));
				totalHeading.setVisible(false);
			
				question.setVisible(true);
				question.setText(questions[questionNumber]);
				playORquit.setVisible(false);
				wrongAnswer.setVisible(false);
				total.setVisible(false);
			
				quitORplay.setVisible(false);
				choices.setVisible(true);
				cont.setVisible(false);
			}
		}
		else {
			System.out.println("Unexpected error occured");
			System.exit(0);
		}
	}	
		
	public static void main(String[] args) {
		TriviaGame gui = new TriviaGame();
		gui.setVisible(true);
	}
}