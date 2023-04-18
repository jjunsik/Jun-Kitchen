package main.java;

import main.java.screen.MainScreen;

public class StoryAssistant {
	private void startStory() {
		MainScreen mainScreen = new MainScreen();
		mainScreen.show();
	}

	public static void main(String[] args) {
		StoryAssistant assistant = new StoryAssistant();
		assistant.startStory();
	}

}
