package ru.timofey.first;

class HangmanRenderer {
    private static final String[] HANGMAN_PICS = {
            """
             +---+
             |   |
                 |
                 |
                 |
                 |
            =========
            """,
            """
             +---+
             |   |
             O   |
                 |
                 |
                 |
            =========
            """,
            """
             +---+
             |   |
             O   |
             |   |
                 |
                 |
            =========
            """,
            """
             +---+
             |   |
             O   |
            /|   |
                 |
                 |
            =========
            """,
            """
             +---+
             |   |
             O   |
            /|\\  |
                 |
                 |
            =========
            """,
            """
             +---+
             |   |
             O   |
            /|\\  |
            /    |
                 |
            =========
            """,
            """
             +---+
             |   |
             O   |
            /|\\  |
            / \\  |
                 |
            =========
            """
    };

    public void render(int mistakes, String progress, int lives) {
        System.out.println(HANGMAN_PICS[mistakes]);
        System.out.println("Слово: " + progress);
        System.out.println("Осталось жизней: " + lives);
    }
}
