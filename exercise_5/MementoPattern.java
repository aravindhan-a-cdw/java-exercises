package exercise_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MementoPattern {

	public static void main(String[] args) {
		
		TextWindow txtWindow = new TextWindow();
		History history = new History();
		
		txtWindow.setText("Hello World");
		history.save(txtWindow.getState());
		
		txtWindow.setText("How are you doing?");
		history.save(txtWindow.getState());
		
		txtWindow.setText("This is Memento Pattern to store states");
		history.save(txtWindow.getState());
		
		txtWindow.setText("This is temp text");
		
		history.listStates();
		
		txtWindow.undo(history.pop());
		txtWindow.undo(history.pop());
		System.out.println(txtWindow.getText());
		
		
		
	}

}

// Care taker
class History{
	private List<TextState> states;
	
	History() {
		states = new ArrayList<TextState>();		
	}
	
	public void save(TextState state) {
		states.add(state);
	}
	
	public TextState pop() {
		TextState state = states.remove(states.size() - 1);
		return state;
	}
	
	public void listStates() {
		states.stream().forEach((state) -> System.out.println(state));
	}
}

// Originator
class TextWindow{
	
	private String text;
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public TextState getState() {
		TextState newState = new TextState(text);
		return newState;
	}
	
	public void undo(TextState state) {
		text = state.getText();
		System.out.println("State set to -> " + text);
	}
	
	
}

// State

class TextState{
	private String text;
	
	public TextState(String text){
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	@Override
	public String toString() {
		return "State: " + text;
	}
}
