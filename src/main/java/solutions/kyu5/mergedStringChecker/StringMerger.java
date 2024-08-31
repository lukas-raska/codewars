package solutions.kyu5.mergedStringChecker;

public class StringMerger {

    public static boolean isMerge(String string,
                                  String part1,
                                  String part2) {
        if (string.length() != part1.length() + part2.length()) {
            return false;
        }
        if (string.isEmpty()) {
            return part1.isEmpty() && part2.isEmpty();
        }
        if (part1.isEmpty()) {
            return string.equals(part2);
        }
        if (part2.isEmpty()) {
            return string.equals(part1);
        }

        int part1Index = 0;
        int part2Index = 0;

        //cyklem projedu všechny znaky zadaného stringu a testuji dle indexů, ze které části lze připojovat znak
        for (int i = 0; i < string.length(); i++) {

            boolean canBeUsedPart1 = isInBounds(part1Index, part1) && hasMatch(string.charAt(i), part1, part1Index);
            boolean canBeUsedPart2 = isInBounds(part2Index, part2) && hasMatch(string.charAt(i), part2, part2Index);

            // nelze připojit znak ani z jednoho dílu
            if (!canBeUsedPart1 && !canBeUsedPart2) {
                return false;

                //lze připojit znak pouze z part1
            } else if (canBeUsedPart1 && !canBeUsedPart2) {
                part1Index++;

                //lze připojit znak pouze z part2
            } else if (!canBeUsedPart1 && canBeUsedPart2) {
                part2Index++;

                //zbývá případ, kdy je možné použít znak z obou dílů.
            } else {
                //použiju pomocné indexy, abych si nerozhodil ty původní
                int helpIndex1 = part1Index;
                int helpIndex2 = part2Index;
                int helpIndex = i;
                //projedu cyklem a zjišťuji do jaké hloubky lze použít oba znaky
                while (isInBounds(helpIndex1, part1) && isInBounds(helpIndex2, part2) && part1.charAt(helpIndex1) == part2.charAt(helpIndex2)) {
                    helpIndex1++;
                    helpIndex2++;
                    helpIndex++;
                }
                //následně vyhodnotím první situaci, kdy se neshodují a na základě toho pohnu s původním partIndexem
                canBeUsedPart1 = isInBounds(helpIndex1, part1) && hasMatch(string.charAt(helpIndex), part1, helpIndex1);
                canBeUsedPart2 = isInBounds(helpIndex2, part2) && hasMatch(string.charAt(helpIndex), part2, helpIndex2);

                //může dojít k situaci, kdy se neshoduje ani jeden ze znaků na následném indexu. Potom je jedno,
                // kterou cestou se vydám, volím 1
                if (canBeUsedPart1 && !canBeUsedPart2 || !canBeUsedPart1 && !canBeUsedPart2) {
                    part1Index++;
                }
                if (!canBeUsedPart1 && canBeUsedPart2) {
                    part2Index++;
                }
            }
        }
        return true;
    }

    private static boolean isInBounds(int index,
                                      String string) {
        return index >= 0 && index < string.length();
    }

    private static boolean hasMatch(char tested,
                                    String part,
                                    int partIndex) {
        return tested == part.charAt(partIndex);
    }


}
