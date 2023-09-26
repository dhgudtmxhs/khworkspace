package snippet;

public class Snippet {
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Tag tag = (Tag) o;
	    return boardNo == tag.boardNo && boardType == tag.boardType && Objects.equals(tagName, tag.tagName);
	}
	
	@Override
	public int hashCode() {
	    return Objects.hash(boardNo, boardType, tagName);
	}
}

