import java.util.HashSet;
import java.util.Set;

public class Replacer {
	
	public static void main(String[] args) {
		Set<String> result = new HashSet<String>();
		Replacer replacer = new Replacer();
		String source = " arbeit in wien";
		replacer.replacePermutation(source, ' ', '+', 0, result);
		System.out.println(result);
	}
	
	public void replacePermutation(String source, Character searchFor, Character insertAfter, final int index, Set<String> targets) {
		int length = source.length();
		if(index == length || index > length) {
			targets.add(source);
		} else {
			int whiteSpaceIndex = searchNextOccurenceInString(source, index, searchFor);
			String leftBranch = source;
			StringBuilder rightBranch = new StringBuilder(source);
			if(whiteSpaceIndex == source.length() || whiteSpaceIndex > source.length()) {
				replacePermutation(leftBranch, searchFor, insertAfter, whiteSpaceIndex, targets);
				replacePermutation(rightBranch.toString(), searchFor, insertAfter, whiteSpaceIndex, targets);
			} else {
				whiteSpaceIndex++;
				rightBranch.insert(whiteSpaceIndex, insertAfter);
				replacePermutation(leftBranch, searchFor, insertAfter, whiteSpaceIndex, targets);
				replacePermutation(rightBranch.toString(), searchFor, insertAfter, whiteSpaceIndex, targets);
			}
		}
	}
	
	public int searchNextOccurenceInString(String source, int lastIndex, Character toSearch ) {
		int nextOccurence;
		String substring = source.substring(lastIndex);
		if(substring.contains(toSearch.toString())) {
			nextOccurence = substring.indexOf(toSearch) + lastIndex;
		} else {
			nextOccurence = source.length();
		}
		return nextOccurence;
	}
}
