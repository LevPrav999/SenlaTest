package ru.timofey.first;

import java.util.Random;

class RandomWordProvider implements WordProvider {
    private static final String[] WORDS = {
            "java", "mirea", "programming", "gradle", "developer", "google"
    };
    private final Random random = new Random();

    @Override
    public String getWord() {
        return WORDS[random.nextInt(WORDS.length)];
    }
}