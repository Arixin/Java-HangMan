package HangMan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("****************************************");
        System.out.println("Witaj w grze wisielca!");
        System.out.println("****************************************");
        System.out.println("Twoim zadaniem jest odgadnąć słowo, które wymyśliłem.");
        System.out.println("Zasady gry są proste: zgadujesz literę, którą wymyśliłem.");
        System.out.println("Jeśli zgadniesz literę, to zostaje ona wyświetlona w odpowiedniej pozycji.");
        System.out.println("Jeśli nie zgadniesz litery, to zostaje Ci zabrane życie oraz Wisielec zaczyna się rysować.");
        System.out.println("Jeśli zgadniesz wszystkie litery, to wygrywasz!");
        System.out.println("Jeśli nie zganiesz to WISIELEC ginie. A Ty przegrywasz.");
        System.out.println("****************************************");
        System.out.println("Wybierz jedna opcję : 1 jeśli chcesz zgarać, 2 jeśli chcesz wyjść");
        File output = new File("C:/Users/blaaz/OneDrive/Desktop/studia/wieloplat.JAVA/HangMan/output.txt");



        int choice = getInt();
        switch (choice) {
            case 1:
                System.out.println("Podaj pierwsza lietere: ");
                Scanner textScanner = new Scanner(output);
                Scanner input = new Scanner(System.in);

                ArrayList<String> words = new ArrayList<>();
                while (textScanner.hasNextLine()) {
                    words.add(textScanner.nextLine());
                }

                String word = words.get((int) (Math.random() * words.size()));
                char[] wordToGuess = word.toCharArray();
                char[] guessedWord = new char[wordToGuess.length];
                for (int i = 0; i < wordToGuess.length; i++) {
                    guessedWord[i] = '?';
                }


                boolean gameOver = false;
                int lives = 6;
                while (!gameOver) {
                    String letter = input.nextLine();
                    //checks for valid input
                    while (letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
                        System.out.println("Niepoprawne dane wejściowe. Spróbuj jeszcze raz.");
                        letter = input.nextLine();

                    }

                    //checks if letter is in word
                    boolean letterInWord = false;
                    for (int i = 0; i < wordToGuess.length; i++) {
                        if (wordToGuess[i] == letter.charAt(0)) {
                            letterInWord = true;
                            guessedWord[i] = letter.charAt(0);

                        }
                    }

                    if (!letterInWord) {
                        lives--;

                        System.out.println("Niestety, ta litera nie występuje w słowie.");
                    }

                    boolean checkIfWon = true;
                    for (int i = 0; i < guessedWord.length; i++) {
                        if (guessedWord[i] == '?') {
                            System.out.print(" _");
                            checkIfWon = false;
                        } else {
                            System.out.print(" " + guessedWord[i]);
                        }
                    }

                    System.out.println("\n" + "Lives left: " + lives);
                    drawHangman(lives);
                    if (checkIfWon) {
                        System.out.println("Gratulacje! Wygrałeś!");
                        gameOver = true;
                    }

                    if (lives == 0) {
                        System.out.println("Niestety, przegrałeś!");
                        System.out.println("Słowo, które wymyśliłem to: " + word);
                        gameOver = true;
                    }
                }
            break;
                case 2:
                    break;
            }

    }

            public static void drawHangman(int l) {
                if (l == 6) {
                    System.out.println("|----------");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                } else if (l == 5) {
                    System.out.println("|----------");
                    System.out.println("|    O");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                } else if (l == 4) {
                    System.out.println("|----------");
                    System.out.println("|    O");
                    System.out.println("|    |");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                } else if (l == 3) {
                    System.out.println("|----------");
                    System.out.println("|    O");
                    System.out.println("|   -|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                } else if (l == 2) {
                    System.out.println("|----------");
                    System.out.println("|    O");
                    System.out.println("|   -|-");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                } else if (l == 1) {
                    System.out.println("|----------");
                    System.out.println("|    O");
                    System.out.println("|   -|-");
                    System.out.println("|   /");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                } else {
                    System.out.println("|----------");
                    System.out.println("|    O");
                    System.out.println("|   -|-");
                    System.out.println("|   //");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                }
            }

    public static int getInt() {
        return new Scanner(System.in).nextInt();
    }
        }






