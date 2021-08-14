import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparingInt;

public class WordFrequencyGame {

    public static final String BLANK_SPACES = "\\s+";
    public static final String NEW_LINE = "\n";

    public String getResult(String sentence){
        List<WordInfo> wordInfoList = getWordFrequency(sentence);
        sortCountDescending(wordInfoList);
        return joinWordInfos(wordInfoList);
    }

    private List<WordInfo> getWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(BLANK_SPACES));
        List<WordInfo> wordInfos = new ArrayList<>();

        new HashSet<>(words)
                .forEach(word -> {
                    int count = Collections.frequency(words, word);
                    wordInfos.add(new WordInfo(word, count));
                });

        return wordInfos;
    }

    private void sortCountDescending(List<WordInfo> wordInfoList) {
        wordInfoList.sort(reverseOrder(comparingInt(WordInfo::getWordCount)));
    }

    private String joinWordInfos(List<WordInfo> wordInfoList) {
        StringJoiner joinedWordInfo = new StringJoiner(NEW_LINE);

        wordInfoList.stream()
                .map(wordInfo -> joinedWordInfo.add(wordInfo.getWord() + " " + wordInfo.getWordCount()))
                .collect(Collectors.toList());

        return joinedWordInfo.toString();
    }

}
