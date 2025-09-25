package ru.timofey.first;


public class Main {

    public static void main(String[] args) {
        WordProvider provider = new RandomWordProvider();
        HangmanRenderer renderer = new HangmanRenderer();
        HangmanGame game = new HangmanGame(provider, renderer);
        game.start();
    }
}