package ru.timofey.first;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HangmanGame {

    private final String word;
    private final char[] progress;
    private final Set<Character> guessedLetters = new HashSet<>();
    private final HangmanRenderer renderer;
    private final int maxMistakes;

    private int mistakes = 0;

    public HangmanGame(WordProvider wordProvider, HangmanRenderer renderer) {
        this.word = wordProvider.getWord();
        this.progress = new char[word.length()];
        Arrays.fill(progress, '_');
        this.renderer = renderer;
        this.maxMistakes = 6;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в игру!");

        while (!isWon() && !isLost()) {
            renderer.render(mistakes, String.valueOf(progress), maxMistakes - mistakes);
            System.out.print("Введите букву: ");
            String input = scanner.nextLine().toLowerCase();

            if (!isValidInput(input)) {
                System.out.println("Введите одну букву!");
                continue;
            }

            char guess = input.charAt(0);
            if (guessedLetters.contains(guess)) {
                System.out.println("Вы уже пробовали букву " + guess);
                continue;
            }
            guessedLetters.add(guess);

            if (word.indexOf(guess) >= 0) {
                revealLetter(guess);
                System.out.println("Правильно!");
            } else {
                mistakes++;
                System.out.println("Неправильно!");
            }
        }

        endGame();
    }

    private boolean isValidInput(String input) {
        return input.length() == 1 && Character.isLetter(input.charAt(0));
    }

    private void revealLetter(char guess) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                progress[i] = guess;
            }
        }
    }

    private boolean isWon() {
        return word.equals(new String(progress));
    }

    private boolean isLost() {
        return mistakes >= maxMistakes;
    }

    private void endGame() {
        if (isWon()) {
            System.out.println("Побда! Вы угадали слово: " + word);
        } else {
            renderer.render(mistakes, String.valueOf(progress), 0);
            System.out.println("Вы проиграли! Загаданное слово: " + word);
        }
    }
}
