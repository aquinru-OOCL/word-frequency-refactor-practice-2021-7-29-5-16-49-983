import java.util.*;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparingInt;

public class WordFrequencyGame {

    public static final String BLANK_SPACES = "\\s+";

    public String getResult(String sentence){

        return getWordFrequency(sentence);
    }

    private String getWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(BLANK_SPACES));
        List<WordInfo> wordInfos = new ArrayList<>();

        new HashSet<>(words)
                .forEach(word -> {
                    int count = Collections.frequency(words, word);
                    wordInfos.add(new WordInfo(word, count));
                });

        List<WordInfo> wordInfoList;
        wordInfoList = wordInfos;
        sortCountDescending(wordInfoList);
        return joinWordInfos(wordInfoList);
    }

    private void sortCountDescending(List<WordInfo> wordInfoList) {
        wordInfoList.sort(reverseOrder(comparingInt(WordInfo::getWordCount)));
    }

    private String joinWordInfos(List<WordInfo> wordInfoList) {
        StringJoiner joinedWordInfo = new StringJoiner("\n");

        wordInfoList
                .forEach(wordInfo -> {
                    String word = wordInfo.getWord() + " " + wordInfo.getWordCount();
                    joinedWordInfo.add(word);
                });

        return joinedWordInfo.toString();
    }

}
