package main.java;

import main.java.screen.MainScreen;

public class StoryAssistant {
	private void startstory() {
		MainScreen mainscreen = new MainScreen();
		mainscreen.show();
	}

	public static void main(String[] args) {
		StoryAssistant assistant = new StoryAssistant();
		assistant.startstory();
	}

}
