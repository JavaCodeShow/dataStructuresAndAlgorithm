package datastructures.ListAndStackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 有一个词典，由若干个单词组成
 * 找出通过单个单词的字母替换可以变成若干个单词的单词。
 * @author 潇潇暮雨
 *
 */
public class Dictionary {

	/**
	 * 将List中的所有单词进行遍历比较得到所需要的Map。
	 * @param theWords
	 * @param String 单词
	 * @param List<String> 与key表示的单词的只有一个字母不同的单词的集合。
	 * @return
	 */
	//该算法效率低下 。 对89000单词的词典运行75秒
	@Deprecated
	public Map<String, List<String>> computeAdjacenWords(List<String> theWords) {
		Map<String, List<String>> adjWords = new TreeMap<String, List<String>>();
		//将theWords转换成数组words
		String[] words = new String[theWords.size()];
		theWords.toArray(words);
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				/**
				 * 判断两个单词是否只有一个单词不同
				 * 是的话就存到adjWord中
				 */
				if (oneCharOff(words[i], words[j])) {
					update(adjWords, words[i], words[j]);
					update(adjWords, words[j], words[i]);
				}
			}
		}
		return adjWords;
	}

	/**
	 * 对上面的算法进行改进 把词典的所有单词按长度进行分组。 长度作为Map的key，长度相同的单词作为Map的value 
	 * 优点 ： 避免了与长度不同的元素进行比较。 
	 * 结果 ： 对89000单词的词典运行16秒
	 */
	@Deprecated
	public Map<String, List<String>> computeAdjacenWords1(List<String> theWords) {
		Map<String, List<String>> adjWords = new TreeMap<String, List<String>>();
		Map<Integer, List<String>> wordsByLength = new TreeMap<Integer, List<String>>();
		for (String w : theWords) {
			List<String> listWord = wordsByLength.get(w.length());
			if (listWord == null) {
				listWord = new ArrayList<String>();
				wordsByLength.put(w.length(), listWord);
			}
			listWord.add(w);
		}
		for (List<String> groupWords : wordsByLength.values()) {
			String[] words = new String[groupWords.size()];
			groupWords.toArray(words);
			for (int i = 0; i < words.length; i++) {
				for (int j = i + 1; j < words.length; j++) {
					if (oneCharOff(words[i], words[j])) {
						update(adjWords, words[i], words[j]);
						update(adjWords, words[j], words[i]);
					}
				}
			}
		}
		return adjWords;

	}

	/**
	 * 对89000个单词的词典的值运行1秒
	 * 将theWords按长度进行分组，长度作为key，长度相同的单词作为value
	 * 对长度相同的list中的单词依次拿掉每一个单词，进行比较。存到Map中。
	 * @param theWords
	 * @return
	 */
	public Map<String, List<String>> computeAdjacenWords2(List<String> theWords) {
		Map<String, List<String>> adjWords = new TreeMap<String, List<String>>();
		Map<Integer, List<String>> wordsByLength = new TreeMap<Integer, List<String>>();
		String[] words = new String[theWords.size()];
		for (String w : words) {
			List<String> list = wordsByLength.get(w.length());
			if (list == null) {
				list = new ArrayList<String>();
				wordsByLength.put(w.length(), list);
			}
			list.add(w);
		}
		for (Map.Entry<Integer, List<String>> entry : wordsByLength.entrySet()) {
			List<String> groupWords = entry.getValue();
			int groupNum = entry.getKey();
			for (int i = 0; i < groupNum; i++) {
				Map<String, List<String>> repToWord = new TreeMap<String, List<String>>();
				for (String groupWord : groupWords) {
					String str = groupWord.substring(0, i) + groupWord.substring(i + 1);
					update(repToWord, str, groupWord);
				}
				for (List<String> wordClique : repToWord.values()) {
					if (wordClique.size() >= 2) {
						for (String word1 : wordClique) {
							for (String word2 : wordClique) {
								if (word1 != word2) {
									update(adjWords, word1, word2);
								}
							}
						}
					}
				}
			}
		}
		return adjWords;
	}

	/**
	 *  检验两个单词是否只有一个不同
	 *  是 ：返回true
	 *  否 ： 返回false
	 * @param word1
	 * @param word2
	 * @return
	 */

	public boolean oneCharOff(String word1, String word2) {
		if (word1.length() != word2.length()) {
			return false;
		}
		int diffs = 0;
		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i)) {
				if (++diffs > 1) {
					return false;
				}
			}
		}
		return diffs == 1;
	}

	/**
	 * 给出包含一些单词作为关键字 和 只在一个字母上不同的一列单词作为关键字的值。
	 * 输出哪些关键字的值得长度大于或等于minWords的只有一个单词不同的单词的单词。
	 */
	public void printHighChangeables(Map<String, List<String>> adjWords, int minWords) {
		for (Map.Entry<String, List<String>> entry : adjWords.entrySet()) {
			List<String> words = entry.getValue();
			if (words.size() >= minWords) {
				System.out.print("[" + entry.getKey());
				for (String word : words) {
					System.out.println(":" + word + "]");
				}
				System.out.println();
			}
		}
	}

	private void update(Map<String, List<String>> adjWords, String key, String value) {
		List<String> listWord = adjWords.get(key);
		if (listWord == null) {
			listWord = new ArrayList<String>();
			adjWords.put(key, listWord);
		}
		listWord.add(value);
	}
}
