package solutions.kyu5.molecule_to_atoms;

import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParseMolecule {


    private static final Pattern SEPARATE_ELEMENT_PATTERN = Pattern.compile("[A-Z][a-z]?\\d*");
    private static final Pattern SPLIT_ELEMENT_AND_COUNT_PATTERN = Pattern.compile("([A-Za-z]+)|(\\d+)");


    public static Map<String, Integer> getAtoms(String formula) {

        if (!isValid(formula)){
            throw new IllegalArgumentException();
        }

        Map<String, Integer> atoms = new HashMap<>();

        formula = formula
                .replaceAll("[{\\[]", "(")
                .replaceAll("[}\\]]", ")");


        while (containsOpeningBrackets(formula)) {
            formula = removeTheMostInnerBrackets(formula);
        }

        SEPARATE_ELEMENT_PATTERN.matcher(formula)
                .results()
                .map(MatchResult::group)
                .map(ParseMolecule::getAmountOfElement)
                .forEach(e -> atoms.merge(e.getKey(), e.getValue(), Integer::sum));


        return atoms;
    }

    private static boolean isValid(String formula) {
        if (formula.matches("^[a-z].")) {
            return false;
        }
        return hasValidBrackets(formula);
    }

    private static boolean hasValidBrackets(String formula) {
        Deque<Character> bracketStack = new ArrayDeque<>();

        for (char c : formula.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                bracketStack.push(c);
            }
            if (c == ')' || c == ']' || c == '}') {
                if (bracketStack.isEmpty()){
                    return false;
                }
                char last = bracketStack.pop();
                if (!isMatchingPair(last,c)){
                    return false;
                }
            }
        }
        return bracketStack.isEmpty();
    }

    private static boolean isMatchingPair(char open,
                                          char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }

    private static String removeTheMostInnerBrackets(String formula) {

        int lastOpeningBracket = findLastOpeningBracketIndex(formula);
        int nearestClosingBracket = findNearestClosingBracketIndex(lastOpeningBracket, formula);

        String subFormula = formula.substring(lastOpeningBracket + 1, nearestClosingBracket);

        String bracketMultiplier = getBracketMultiplier(nearestClosingBracket + 1, formula);
        int multiplierValue = bracketMultiplier.isEmpty() ? 1 : Integer.parseInt(bracketMultiplier);


        subFormula = SEPARATE_ELEMENT_PATTERN.matcher(subFormula).results()
                .map(MatchResult::group)
                .map(element -> solveBracketMultiplication(element, multiplierValue))
                .collect(Collectors.joining());

        String beforeBrackets = formula.substring(0, lastOpeningBracket);
        String afterBrackets = formula.substring(nearestClosingBracket + 1 + bracketMultiplier.length());

        return beforeBrackets + subFormula + afterBrackets;
    }

    private static Map.Entry<String, Integer> getAmountOfElement(String element) {

        List<String> splitElement = SPLIT_ELEMENT_AND_COUNT_PATTERN.matcher(element).results()
                .map(MatchResult::group)
                .toList();

        String elementName = splitElement.getFirst();
        int count = splitElement.size() == 1 ? 1 : Integer.parseInt(splitElement.getLast());

        return new AbstractMap.SimpleEntry<>(elementName, count);


    }

    private static String solveBracketMultiplication(String element,
                                                     int multiplier) {
        Pattern elementPattern = Pattern.compile("([A-Za-z]+)|(\\d+)");

        var parts = elementPattern.matcher(element).results()
                .map(MatchResult::group)
                .toList();
        //System.out.println("List size: " + parts.size());
        String elementName = parts.get(0);
        int elementValue = parts.size() == 1 ? 1 : Integer.parseInt(parts.get(1));

        return elementName + elementValue * multiplier;
    }

    private static boolean containsOpeningBrackets(String string) {
        return string.chars()
                .mapToObj(c -> (char) c)
                .anyMatch(c -> c == '(' || c == '[' || c == '{');
    }

    private static int findLastOpeningBracketIndex(String string) {

        int lastRound = string.lastIndexOf("(");
        int lastCurly = string.lastIndexOf('{');
        int lastSquare = string.lastIndexOf('[');

        return IntStream
                .of(lastSquare, lastCurly, lastRound)
                .max()
                .orElseThrow();
    }

    private static int findNearestClosingBracketIndex(int fromIndex,
                                                      String string) {
        return fromIndex + string.substring(fromIndex).indexOf(')');
    }

    private static String getBracketMultiplier(int fromIndex,
                                               String string) {
        String result = "";
        for (char c : string.substring(fromIndex).toCharArray()) {
            if (Character.isDigit(c)) {
                result += c;
            } else {
                break;
            }
        }
        return result;
    }

}
