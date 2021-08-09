import java.util.*;

public class WordFrequencyGame {

    public static final String BLANK_SPACES = "\\s+";

    public String getResult(String sentence){

        return getWordFrequency(sentence);
    }

    private String getWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(BLANK_SPACES));
        List<WordInfo> wordInfos = new ArrayList<>();
        for (String word : new HashSet<>(words)) {
            int count = Collections.frequency(words, word);
            wordInfos.add(new WordInfo(word, count));
        }

        List<WordInfo> wordInfoList;
        wordInfoList = wordInfos;
        sortCountDescending(wordInfoList);
        return joinWordInfos(wordInfoList);
    }

    private void sortCountDescending(List<WordInfo> wordInfoList) {
        wordInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());
    }

    private String joinWordInfos(List<WordInfo> wordInfoList) {
        StringJoiner joinedWordInfo = new StringJoiner("\n");
        for (WordInfo wordInfo : wordInfoList) {
            String finalWord = wordInfo.getWord() + " " +wordInfo.getWordCount();
            joinedWordInfo.add(finalWord);
        }
        return joinedWordInfo.toString();
    }

}
