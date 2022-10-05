package kunle.calculator;

import javafx.animation.PauseTransition;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;


public class CalculatorApp extends Application {

	private Button buttonZero, buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine,
	buttonClearAll, buttonPlusMinus, buttonPercent, buttonDivide, buttonMultiply, buttonMinus, buttonPlus, buttonEqual, buttonComa;
	private Text display;
	private Float data= 0f;
	private int operation= -1;
	
	
	
	private String buttonStyle() {
		
		return "-fx-background-radius: 5em; " +
                "-fx-min-width: 50px; " +
                "-fx-min-height: 50px; " +
                "-fx-max-width: 50px; " +
                "-fx-max-height: 50px;" +
                "-fx-background-color: rgb(80, 80, 80);" +
                "-fx-text-fill: white;";
	}
	
	private String buttonStyle2() {
		
		return "-fx-background-radius: 5em; " +
				"-fx-min-width: 50px; " +
				"-fx-min-height: 50px; " +
				"-fx-max-width: 50px; " +
				"-fx-max-height: 50px;" +
				"-fx-background-color: rgb(212, 212, 210);" +
				"-fx-text-fill: rgb(28, 28, 28);";
	}
	
	private String buttonStyle3() {
		
		return "-fx-background-radius: 5em; " +
				"-fx-min-width: 50px; " +
				"-fx-min-height: 50px; " +
				"-fx-max-width: 50px; " +
				"-fx-max-height: 50px;" +
				"-fx-background-color: rgb(255, 149, 0);" +
				"-fx-text-fill: white;";
	}
	
	private String buttonClickStyle1() {
		
		return	"-fx-background-radius: 5em; " +
	            "-fx-min-width: 50px; " +
	            "-fx-min-height: 50px; " +
	            "-fx-max-width: 50px; " +
	            "-fx-max-height: 50px;" +
	            "-fx-background-color: rgb(126,	126, 126);"+
	            "-fx-text-fill: white;"+
	            "-fx-text-alignment: left;";
    	
	}
	
	private String buttonClickStyle2() {
		
		return	"-fx-background-radius: 5em; " +
				"-fx-min-width: 50px; " +
				"-fx-min-height: 50px; " +
				"-fx-max-width: 50px; " +
				"-fx-max-height: 50px;" +
				"-fx-background-color: rgb(126,	126, 126);"+
				"-fx-text-fill: white;"+
				"-fx-text-alignment: left;";
		
	}
	
	private String buttonClickStyle3() {
		
		return  "-fx-background-radius: 5em; " +
				"-fx-min-width: 50px; " +
				"-fx-min-height: 50px; " +
				"-fx-max-width: 50px; " +
				"-fx-max-height: 50px;" +
				"-fx-background-color: white;" +
				"-fx-text-fill: rgb(255, 149, 0);";
	}
	
	private String buttonClickStyle4() {
		
		return "-fx-background-radius: 5em; " +
				"-fx-min-width: 50px; " +
				"-fx-min-height: 50px; " +
				"-fx-max-width: 50px; " +
				"-fx-max-height: 50px;" +
				"-fx-background-color: rgb(243, 243, 242);" +
				"-fx-text-fill: rgb(28, 28, 28);";
	}

	private Text getDisplayText(Text text) {
		
		text.setFill(Color.WHITE);
		text.setFont(Font.font("Neue Helvetica", FontWeight.NORMAL, 40));
		/*
		if(text.getText().length() >= 10) {
			//String redAns= display.getText();
			text.setFont(Font.font("Neue Helvetica", FontWeight.NORMAL, 20));
		} else
		*/
		return text;
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		

		Font font = Font.font("Neue Helvetica", FontWeight.BOLD, 20);

		
		//Create buttons using: text on circle
		//StackPane.setAlignment(getText(zero), Pos.CENTER_LEFT);
		
	    buttonZero = new Button("0          ");
	    buttonZero.setFont(font);
	    buttonZero.setStyle("-fx-background-radius: 5em; " +
	            "-fx-min-width: 110px; " +
	            "-fx-min-height: 50px; " +
	            "-fx-max-width: 110px; " +
	            "-fx-max-height: 50px;" +
	            "-fx-background-color: rgb(80, 80, 80);"+
	            "-fx-text-fill: white;"+
	            "-fx-text-alignment: left;");

	    //EventHandling
	    buttonZero.setOnMouseClicked(e->{
	    	buttonZero.setStyle("-fx-background-radius: 5em; " +
		            "-fx-min-width: 110px; " +
		            "-fx-min-height: 50px; " +
		            "-fx-max-width: 110px; " +
		            "-fx-max-height: 50px;" +
		            "-fx-background-color: rgb(126,	126, 126);"+
		            "-fx-text-fill: white;"+
		            "-fx-text-alignment: left;");
	    	
	    	PauseTransition pause = new PauseTransition(
	    	    Duration.seconds(0.3)
	    	);
	    	pause.setOnFinished(event -> {
	    		buttonZero.setStyle("-fx-background-radius: 5em; " +
	    	            "-fx-min-width: 110px; " +
	    	            "-fx-min-height: 50px; " +
	    	            "-fx-max-width: 110px; " +
	    	            "-fx-max-height: 50px;" +
	    	            "-fx-background-color: rgb(80, 80, 80);"+
	    	            "-fx-text-fill: white;"+
	    	            "-fx-text-alignment: left;");
	    	});
	    	pause.play();
	    	
	    	
	    	if(e.getSource() == buttonZero && !display.getText().equalsIgnoreCase("0")) {
	    		if(display.getText().equalsIgnoreCase("0"))
	    			display.setText("0");
	    		if(e.getSource() == buttonZero && display.getText().length() == 10)
	    			display.setText("");
	    		display.setText(display.getText() +"0");
	    		buttonClearAll.setText("C");
	    	}
	    	
	    	//Restore operators button color
			if(e.getSource() == buttonZero) {
				buttonDivide.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonZero) {
				buttonMultiply.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonZero) {
				buttonMinus.setStyle(buttonStyle3());
			}
			
			if(e.getSource() == buttonZero) {
				buttonPlus.setStyle(buttonStyle3());
			}
			
			
	    });

	    
		
	    buttonOne= new Button("1");
	    buttonOne.setFont(font);
	    buttonOne.setStyle(buttonStyle());

	    //EventHandling
	    buttonOne.setOnMouseClicked(e->{
	    	buttonOne.setStyle(buttonClickStyle1());
	    	
	    	PauseTransition pause = new PauseTransition(
	    	    Duration.seconds(0.3)
	    	);
	    	pause.setOnFinished(event -> {
	    		buttonOne.setStyle(buttonStyle());
	    	});
	    	pause.play();
	    	
	    	
	    	if(e.getSource() == buttonOne) {
	    		if(display.getText().equalsIgnoreCase("0"))
	    			display.setText("");
	    		if(e.getSource() == buttonOne && display.getText().length() == 10)
	    			display.setText("");
	    		display.setText(display.getText() +"1");
	    		buttonClearAll.setText("C");
	    		
	    		System.out.println(display.getText().length());
	    	}
	    	
	    	
	    	//Restore operators button color
			if(e.getSource() == buttonOne) {
				buttonDivide.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonOne) {
				buttonMultiply.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonOne) {
				buttonMinus.setStyle(buttonStyle3());
			}
			
			if(e.getSource() == buttonOne) {
				buttonPlus.setStyle(buttonStyle3());
			}
			
	    });

	    
	    buttonTwo= new Button("2");
	    buttonTwo.setFont(font);
	    buttonTwo.setStyle(buttonStyle());
	
	    
	  //EventHandling
	    buttonTwo.setOnMouseClicked(e->{
	    	buttonTwo.setStyle(buttonClickStyle1());
	    	
	    	PauseTransition pause = new PauseTransition(
	    	    Duration.seconds(0.3)
	    	);
	    	pause.setOnFinished(event -> {
	    		buttonTwo.setStyle(buttonStyle());
	    	});
	    	pause.play();
	    	
	    	if(e.getSource() == buttonTwo) {
	    		if(display.getText().equalsIgnoreCase("0"))
	    			display.setText("");
	    		if(e.getSource() == buttonTwo && display.getText().length() == 10)
	    			display.setText("");
				display.setText(display.getText() +"2");
				buttonClearAll.setText("C");
			}
	    	
	    	//Restore operators button color
			if(e.getSource() == buttonTwo) {
				buttonDivide.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonTwo) {
				buttonMultiply.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonTwo) {
				buttonMinus.setStyle(buttonStyle3());
			}
			
			if(e.getSource() == buttonTwo) {
				buttonPlus.setStyle(buttonStyle3());
			}
			
	    });
	  
		
		buttonThree= new Button("3");
		buttonThree.setFont(font);
		buttonThree.setStyle(buttonStyle());
		
		
		//EventHandling
		buttonThree.setOnMouseClicked(e->{
			buttonThree.setStyle(buttonClickStyle1());
	    	
	    	PauseTransition pause = new PauseTransition(
	    	    Duration.seconds(0.3)
	    	);
	    	pause.setOnFinished(event -> {
	    		buttonThree.setStyle(buttonStyle());
	    	});
	    	pause.play();
	    	
	    	if(e.getSource() == buttonThree) {
	    		if(display.getText().equalsIgnoreCase("0"))
	    			display.setText("");
	    		if(e.getSource() == buttonThree && display.getText().length() == 10)
	    			display.setText("");
	    		display.setText(display.getText() +"3");
	    		buttonClearAll.setText("C");
	    		
	    	}
	    	
	    	//Restore operators button color
			if(e.getSource() == buttonThree) {
				buttonDivide.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonThree) {
				buttonMultiply.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonThree) {
				buttonMinus.setStyle(buttonStyle3());
			}
			
			if(e.getSource() == buttonThree) {
				buttonPlus.setStyle(buttonStyle3());
			}
			
	    });
	    
		
		buttonFour= new Button("4");
		buttonFour.setFont(font);
		buttonFour.setStyle(buttonStyle());
		
		
		//EventHandling
		buttonFour.setOnMouseClicked(e->{
			buttonFour.setStyle(buttonClickStyle1());
	    	
	    	PauseTransition pause = new PauseTransition(
	    	    Duration.seconds(0.3)
	    	);
	    	pause.setOnFinished(event -> {
	    		buttonFour.setStyle(buttonStyle());
	    	});
	    	pause.play();
	    	
	    	if(e.getSource() == buttonFour) {
	    		if(display.getText().equalsIgnoreCase("0"))
	    			display.setText("");
	    		if(e.getSource() == buttonFour && display.getText().length() == 10)
	    			display.setText("");
	    		display.setText(display.getText() +"4");
	    		buttonClearAll.setText("C");
	    	}
	    	
	    	//Restore operators button color
			if(e.getSource() == buttonFour) {
				buttonDivide.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonFour) {
				buttonMultiply.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonFour) {
				buttonMinus.setStyle(buttonStyle3());
			}
			
			if(e.getSource() == buttonFour) {
				buttonPlus.setStyle(buttonStyle3());
			}
	    });
		
		
		buttonFive= new Button("5");
		buttonFive.setFont(font);
		buttonFive.setStyle(buttonStyle());
		
		
		//EventHandling
		buttonFive.setOnMouseClicked(e->{
			buttonFive.setStyle(buttonClickStyle1());
	    	
	    	PauseTransition pause = new PauseTransition(
	    	    Duration.seconds(0.3)
	    	);
	    	pause.setOnFinished(event -> {
	    		buttonFive.setStyle(buttonStyle());
	    	});
	    	pause.play();
	    	
	    	if(e.getSource() == buttonFive) {
	    		if(display.getText().equalsIgnoreCase("0"))
	    			display.setText("");
	    		if(e.getSource() == buttonFive && display.getText().length() == 10)
	    			display.setText("");
	    		display.setText(display.getText() +"5");
	    		buttonClearAll.setText("C");
	    	}
	    	
	    	//Restore operators button color
			if(e.getSource() == buttonFive) {
				buttonDivide.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonFive) {
				buttonMultiply.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonFive) {
				buttonMinus.setStyle(buttonStyle3());
			}
			
			if(e.getSource() == buttonFive) {
				buttonPlus.setStyle(buttonStyle3());
			}
			
	    });
		
		
		
		buttonSix= new Button("6");
		buttonSix.setFont(font);
		buttonSix.setStyle(buttonStyle());
		
		
		//EventHandling
		buttonSix.setOnMouseClicked(e->{
			buttonSix.setStyle(buttonClickStyle1());
	    	
	    	PauseTransition pause = new PauseTransition(
	    	    Duration.seconds(0.3)
	    	);
	    	pause.setOnFinished(event -> {
	    		buttonSix.setStyle(buttonStyle());
	    	});
	    	pause.play();
	    	
	    	if(e.getSource() == buttonSix) {
	    		if(display.getText().equalsIgnoreCase("0"))
	    			display.setText("");
	    		if(e.getSource() == buttonSix && display.getText().length() == 10)
	    			display.setText("");
	    		display.setText(display.getText() +"6");
	    		buttonClearAll.setText("C");
	    	}
	    	
	    	//Restore operators button color
			if(e.getSource() == buttonSix) {
				buttonDivide.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonSix) {
				buttonMultiply.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonSix) {
				buttonMinus.setStyle(buttonStyle3());
			}
			
			if(e.getSource() == buttonSix) {
				buttonPlus.setStyle(buttonStyle3());
			}
			
	    });
		
		
		buttonSeven= new Button("7");
		buttonSeven.setFont(font);
		buttonSeven.setStyle(buttonStyle());
		
		
		//EventHandling
		buttonSeven.setOnMouseClicked(e->{
			buttonSeven.setStyle(buttonClickStyle1());
	    	
	    	PauseTransition pause = new PauseTransition(
	    	    Duration.seconds(0.3)
	    	);
	    	pause.setOnFinished(event -> {
	    		buttonSeven.setStyle(buttonStyle());
	    	});
	    	pause.play();
	    	
	    	if(e.getSource() == buttonSeven) {
	    		if(display.getText().equalsIgnoreCase("0"))
	    			display.setText("");
	    		if(e.getSource() == buttonSeven && display.getText().length() == 10)
	    			display.setText("");
	    		display.setText(display.getText() +"7");
	    		buttonClearAll.setText("C");
	    	}
	    	
	    	//Restore operators button color
			if(e.getSource() == buttonSeven) {
				buttonDivide.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonSeven) {
				buttonMultiply.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonSeven) {
				buttonMinus.setStyle(buttonStyle3());
			}
			
			if(e.getSource() == buttonSeven) {
				buttonPlus.setStyle(buttonStyle3());
			}

	    });
		
		
		buttonEight= new Button("8");
		buttonEight.setFont(font);
		buttonEight.setStyle(buttonStyle());
		
		
		//EventHandling
		buttonEight.setOnMouseClicked(e->{
			buttonEight.setStyle(buttonClickStyle1());
	    	
	    	PauseTransition pause = new PauseTransition(
	    	    Duration.seconds(0.3)
	    	);
	    	pause.setOnFinished(event -> {
	    		buttonEight.setStyle(buttonStyle());
	    	});
	    	pause.play();
	    	
	    	if(e.getSource() == buttonEight) {
	    		if(display.getText().equalsIgnoreCase("0"))
	    			display.setText("");
	    		if(e.getSource() == buttonEight && display.getText().length() == 10)
	    			display.setText("");
	    		display.setText(display.getText() +"8");
	    		buttonClearAll.setText("C");
	    	}
	    	
	    	//Restore operators button color
			if(e.getSource() == buttonEight) {
				buttonDivide.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonEight) {
				buttonMultiply.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonEight) {
				buttonMinus.setStyle(buttonStyle3());
			}
			
			if(e.getSource() == buttonEight) {
				buttonPlus.setStyle(buttonStyle3());
			}
			
	    });
		
		
		buttonNine= new Button("9");
		buttonNine.setFont(font);
		buttonNine.setStyle(buttonStyle());
		
		
		//EventHandling
		buttonNine.setOnMouseClicked(e->{
			buttonNine.setStyle(buttonClickStyle1());
	    	
	    	PauseTransition pause = new PauseTransition(
	    	    Duration.seconds(0.3)
	    	);
	    	pause.setOnFinished(event -> {
	    		buttonNine.setStyle(buttonStyle());
	    	});
	    	pause.play();
	    	
	    	if(e.getSource() == buttonNine) {
	    		if(display.getText().equalsIgnoreCase("0"))
	    			display.setText("");
	    		if(e.getSource() == buttonNine && display.getText().length() == 10)
	    			display.setText("");
	    		display.setText(display.getText() +"9");
	    		buttonClearAll.setText("C");
	    	}
	    	
	    	//Restore operators button color
			if(e.getSource() == buttonNine) {
				buttonDivide.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonNine) {
				buttonMultiply.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonNine) {
				buttonMinus.setStyle(buttonStyle3());
			}
			
			if(e.getSource() == buttonNine) {
				buttonPlus.setStyle(buttonStyle3());
			}
			
			/*
			 * 	if(e.getSource() == buttonNine && display.getText().length() == 3)
	    			display.setText(display.getText()+ ".");
	    		if(e.getSource() == buttonNine && display.getText().length() == 7)
	    			display.setText(display.getText()+ ".");
			 */
	    });
		
		
		
		buttonClearAll= new Button("AC");
		buttonClearAll.setFont(Font.font("Neue Helvetica", FontWeight.BOLD, 16));
		buttonClearAll.setStyle(buttonStyle2());
		
		//EventHandling
		buttonClearAll.setOnMouseClicked(e->{
			buttonClearAll.setStyle(buttonClickStyle4());
			    	
			PauseTransition pause = new PauseTransition(
			    Duration.seconds(0.3)
			);
			pause.setOnFinished(event -> {
				buttonClearAll.setStyle(buttonStyle2());
			});
			pause.play();
			    	
			if(e.getSource() == buttonClearAll) {
			    		
			    display.setText("0");
			    buttonClearAll.setText("AC");
			}
			
			if(e.getSource() == buttonClearAll) {
				
				buttonDivide.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonClearAll) {
				buttonMultiply.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonClearAll) {
				buttonMinus.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonClearAll) {
				buttonPlus.setStyle(buttonStyle3());
			}
		});

		
		
		buttonPlusMinus= new Button("+/-");
		buttonPlusMinus.setFont(Font.font("Neue Helvetica", FontWeight.BOLD, 16));
		buttonPlusMinus.setStyle(buttonStyle2());
		
		//EventHandling
		buttonPlusMinus.setOnMouseClicked(e->{
			buttonPlusMinus.setStyle(buttonClickStyle4());
			    	
			PauseTransition pause = new PauseTransition(
			    Duration.seconds(0.3)
			);
			pause.setOnFinished(event -> {
				buttonPlusMinus.setStyle(buttonStyle2());
			});
			pause.play();
			
			//Restore operators button color
			if(e.getSource() == buttonPlusMinus) {
				
				buttonDivide.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonPlusMinus) {
				buttonMultiply.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonPlusMinus) {
				buttonMinus.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonPlusMinus) {
				buttonPlus.setStyle(buttonStyle3());
			}
			
			if(e.getSource() == buttonPlusMinus) {
	    		
				data= Float.parseFloat(display.getText());
				Float data2=data * -1;
				
				if(data2 % 1 != 0)
					display.setText(String.valueOf(data2));
				else
					display.setText(String.valueOf(data2.intValue()));
			}
		});

		
		buttonPercent= new Button("%");
		buttonPercent.setFont(font);
		buttonPercent.setStyle(buttonStyle2());
		
		//EventHandling
		buttonPercent.setOnMouseClicked(e->{
			buttonPercent.setStyle(buttonClickStyle4());
			    	
			PauseTransition pause = new PauseTransition(
			    Duration.seconds(0.3)
			);
			pause.setOnFinished(event -> {
				buttonPercent.setStyle(buttonStyle2());
			});
			pause.play();
			
			//Restore operators button color
			if(e.getSource() == buttonPercent) {
				
				buttonDivide.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonPercent) {
				buttonMultiply.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonPercent) {
				buttonMinus.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonPercent) {
				buttonPlus.setStyle(buttonStyle3());
			}
			    	
			if(e.getSource() == buttonPercent) {
			    		
				data= Float.parseFloat(display.getText());
				Float data2=data / 100;

				if(data % 100 != 0)
					display.setText(String.valueOf(data2));
				else
					display.setText(String.valueOf(data2.intValue()));
					
			}

		});
		

		buttonDivide= new Button("÷");
		buttonDivide.setFont(font);
		buttonDivide.setStyle(buttonStyle3());
		
		//EventHandling
		buttonDivide.setOnMouseClicked(e->{
			if(e.getSource() == buttonDivide) {
				buttonDivide.setStyle(buttonClickStyle3());
			}
			
			//Restore operators button color
			if(e.getSource() == buttonDivide) {
				buttonMultiply.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonDivide) {
				buttonMinus.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonDivide) {
				buttonPlus.setStyle(buttonStyle3());
			}
			
			if(e.getSource() == buttonDivide) {
			    		
				data= Float.parseFloat(display.getText());
				operation= 4;
				display.setText("");
			}
			
		});
		
		

		buttonMultiply= new Button("x");
		buttonMultiply.setFont(font);
		buttonMultiply.setStyle("-fx-font-size:18");
		buttonMultiply.setStyle(buttonStyle3());
		
		//EventHandling
		buttonMultiply.setOnMouseClicked(e->{
			if(e.getSource() == buttonMultiply) {
				buttonMultiply.setStyle(buttonClickStyle3());
			}
			
			//Restore operators button color
			if(e.getSource() == buttonMultiply) {
				buttonDivide.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonMultiply) {
				buttonMinus.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonMultiply) {
				buttonPlus.setStyle(buttonStyle3());
			}
			    	
			if(e.getSource() == buttonMultiply) {
			    		
				data= Float.parseFloat(display.getText());
				operation= 3;
				display.setText("");
			}
			
			
			
		});
		
		
		buttonMinus= new Button("-");
		buttonMinus.setFont(font);
		buttonMinus.setStyle(buttonStyle3());
		
		//EventHandling
		buttonMinus.setOnMouseClicked(e->{
			if(e.getSource() == buttonMinus) {
				buttonMinus.setStyle(buttonClickStyle3());
			}
			
			//Restore operators button color
			if(e.getSource() == buttonMinus) {
				buttonDivide.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonMinus) {
				buttonMultiply.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonMinus) {
				buttonPlus.setStyle(buttonStyle3());
			}
			 	
			if(e.getSource() == buttonMinus) {
			    		
				data= Float.parseFloat(display.getText());
				operation= 2;
				display.setText("");
			}
			
		});
		
		buttonPlus= new Button("+");
		buttonPlus.setFont(font);
		buttonPlus.setStyle(buttonStyle3());
		
		//EventHandling
		buttonPlus.setOnMouseClicked(e->{
			if(e.getSource() == buttonPlus) {
				buttonPlus.setStyle(buttonClickStyle3());
			}
			
			//Restore operators button color
			if(e.getSource() == buttonPlus) {
				buttonDivide.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonPlus) {
				buttonMultiply.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonPlus) {
				buttonMinus.setStyle(buttonStyle3());
			}
			
			    	
			if(e.getSource() == buttonPlus) {
			    		
				data= Float.parseFloat(display.getText());
				operation= 1;
				display.setText("");
			}
			
		});
		
		
		buttonEqual= new Button("=");
		buttonEqual.setFont(font);
		buttonEqual.setStyle(buttonStyle3());
		
		//EventHandling
		buttonEqual.setOnMouseClicked(e->{
			buttonEqual.setStyle(buttonClickStyle3());
			    	
			PauseTransition pause = new PauseTransition(
			    Duration.seconds(0.3)
			);
			pause.setOnFinished(event -> {
					buttonEqual.setStyle(buttonStyle3());
			});
			pause.play();
			
			//Restore operators button color
			if(e.getSource() == buttonEqual) {
				buttonDivide.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonEqual) {
				buttonMultiply.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonEqual) {
				buttonMinus.setStyle(buttonStyle3());
			}
			
			if(e.getSource() == buttonEqual) {
				buttonPlus.setStyle(buttonStyle3());
			}
			    	
			if(e.getSource() == buttonEqual) {

				Float secondOperand= Float.parseFloat(display.getText());
				
				switch(operation)
				{
				
				case 1: //Addition
					Float ans= data + secondOperand;
					if(ans % 1 != 0)
						display.setText(String.valueOf(ans));
					else
						display.setText(String.valueOf(ans.intValue()));
					break;
				case 2: //Subtraction
					ans= data - secondOperand;
					if(ans % 1 != 0)
						display.setText(String.valueOf(ans));
					else
						display.setText(String.valueOf(ans.intValue()));
					break;
				case 3: //Multiplication
					ans= data * secondOperand;
					if(ans % 1 != 0)
						display.setText(String.valueOf(ans));
					else
						display.setText(String.valueOf(ans.intValue()));
					break;
				case 4: //Division
					ans= data / secondOperand;
					
					if(ans % 2 != 0 && ans % 1 != 0)
						display.setText(String.valueOf(ans));
					else
						display.setText(String.valueOf(ans.intValue()));
					
					if(ans.isNaN() || ans.isInfinite())
						display.setText("Error");
					break;
				}
				
			}
		});
		
		
		buttonComa= new Button(",");
		buttonComa.setFont(font);
		buttonComa.setStyle(buttonStyle());

		//EventHandling
		buttonComa.setOnMouseClicked(e->{
			buttonComa.setStyle(buttonClickStyle1());
	    	
	    	PauseTransition pause = new PauseTransition(
	    	    Duration.seconds(0.3)
	    	);
	    	pause.setOnFinished(event -> {
	    		buttonComa.setStyle(buttonStyle());
	    	});
	    	pause.play();
	    	
	    	//Restore operators button color
			if(e.getSource() == buttonComa) {
				buttonDivide.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonComa) {
				buttonMultiply.setStyle(buttonStyle3());
			}
			if(e.getSource() == buttonComa) {
				buttonMinus.setStyle(buttonStyle3());
			}
			
			if(e.getSource() == buttonComa) {
				buttonPlus.setStyle(buttonStyle3());
			}
			
			if(e.getSource() == buttonComa) {
				String data3= display.getText()+ ".";
				display.setText(String.valueOf(data3));
			}
	    });
		
		
		display= new Text("0");
		display.setTextAlignment(TextAlignment.RIGHT);
		
		
		//HBox for display
		VBox displayBox= new VBox();
		displayBox.getChildren().add(getDisplayText(display));
		displayBox.setAlignment(Pos.BOTTOM_RIGHT);
		displayBox.setPadding(new Insets(0,-57,17,0));
		

		
		//HBox for digits- 0,.
		HBox lastDigits= new HBox();
		lastDigits.getChildren().addAll(buttonZero, buttonComa);
		lastDigits.setSpacing(10);
		

		//HBox for digits- 7,8,9
		HBox firstDigits= new HBox();
		firstDigits.getChildren().addAll(buttonSeven, buttonEight, buttonNine);
		firstDigits.setSpacing(10);
	
		
		//HBox for digits- 4,5,6
		HBox secendDigits= new HBox();
		secendDigits.getChildren().addAll(buttonFour, buttonFive, buttonSix);
		secendDigits.setSpacing(10);
		
		//HBox for digits- 1,2,3
		HBox thirdDigits= new HBox();
		thirdDigits.getChildren().addAll(buttonOne, buttonTwo, buttonThree);
		thirdDigits.setSpacing(10);
		
		//HBox for symbols- AC,+/-,%
		HBox firstSymbols= new HBox();
		firstSymbols.getChildren().addAll(buttonClearAll, buttonPlusMinus, buttonPercent);
		firstSymbols.setSpacing(10);
		
		//VBox for operators - ÷,x,-,+,=
		VBox operatorsSymbols= new VBox();
		operatorsSymbols.getChildren().addAll(buttonDivide, buttonMultiply, buttonMinus, buttonPlus, buttonEqual);
		operatorsSymbols.setAlignment(Pos.BOTTOM_RIGHT);
		operatorsSymbols.setPadding(new Insets(0,15,20,0));
		operatorsSymbols.setPrefHeight(180);
		operatorsSymbols.setSpacing(10);

		
		VBox vb1= new VBox();
		vb1.getChildren().addAll(displayBox, firstSymbols, firstDigits, secendDigits, thirdDigits, lastDigits);
		vb1.setAlignment(Pos.BOTTOM_LEFT);
		vb1.setPadding(new Insets(0,0,20,15));
		vb1.setPrefHeight(180);
		vb1.setSpacing(10);
		
		
		
		HBox mainHBox= new HBox();
		mainHBox.setBackground(new Background(new BackgroundFill(Color.rgb(28, 28, 28), null, null)));
		mainHBox.getChildren().addAll(vb1, operatorsSymbols);
		mainHBox.setSpacing(10);
		
		
		
		Scene calcScene= new Scene(mainHBox, 260,430);
		//calcScene.setFill(Color.rgb(28, 28, 28));
		stage.setTitle("Calculator");
		stage.setScene(calcScene);
		stage.show();
	}

}
