package solutions.kyu6.magic_music_box;

import java.util.*;
import java.util.stream.Stream;

public class MagicMusicBox {

    public static void main(String[] args) {

        String input = "FAIRYTALE, SOLAR, PLATFORM, DOBLE, HOUSE, MINIMAL, INNOVATION, CREDIBLE, FREEDOM, LIBRARY, " +
                "TREATMENT, FAIRYTALE, PREPARE, REACTOR, FANATIC, ABSOLUTE, SOLAR, BASIC, RESIST, VISIBLE, ENVIRONMENT, FOUNTAIN, MONTAIN, SITUATION, MOUNTAIN, VISIBLE, EROSION, RELATION, WIND, SISTER, DOBLE, WINDOW, FACTOR, DOLLY, NIGHT";

        String[] inputWords = input.split(",");
        System.out.println(Arrays.toString(magicMusicBox(inputWords)));
    }


    public static String[] magicMusicBox(String[] words) {

        final String[] notes = {"DO", "RE", "MI", "FA", "SOL", "LA", "SI"};
        List<String> foundWords = new ArrayList<>(words.length);

        int step = 0, noteIndex = 0, wordIndex = 0;

        while (step < words.length) {

            String currentWord = words[wordIndex++ % words.length];

            boolean matchFound = currentWord.contains(notes[noteIndex]);
            boolean alreadyUsed = foundWords.contains(currentWord);

            if (matchFound && !alreadyUsed) {
                foundWords.add(currentWord);
                noteIndex = ++noteIndex % notes.length;
                step = 0;
            }
            step++;
        }

        return foundWords.toArray(new String[0]);
    }
}