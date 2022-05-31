package practice.spring.lguplusspringeducation.chap11.survey;

import java.util.Collections;
import java.util.List;

public class Question {

	private String title;
	private List<String> options;
	private Integer index;

	public Question(String title, List<String> options, Integer index) {
		this.title = title;
		this.options = options;
		this.index = index;
	}

	public Question(String title, Integer index) {
		this(title, Collections.<String>emptyList(), index);
	}

	public String getTitle() {
		return title;
	}

	public List<String> getOptions() {
		return options;
	}

	public boolean isChoice() {
		return options != null && !options.isEmpty();
	}

}
