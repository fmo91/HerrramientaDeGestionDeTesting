package com.herramienta.services;

import com.herramienta.model.CodeMetric;

public class CommentedLinesInspectionService extends CodeInspectionService {

	private boolean mIsInCommentMode = false;
	private int mNumberOfCommentedLines = 0;
	
	public boolean isInCommentMode() {
		return this.mIsInCommentMode;
	}
	
	@Override
	public void analyzeLine(String codeLine) {
		
		if (codeLine.contains("/*")) {
			this.mIsInCommentMode = true;
		}
		
		if (this.mIsInCommentMode) {
			this.mNumberOfCommentedLines++;
		} else if (codeLine.contains("//")) {
			this.mNumberOfCommentedLines++;
		}
		
		if (codeLine.contains("*/")) {
			this.mIsInCommentMode = false;
		}
		
	}

	@Override
	public CodeMetric getMetric() {
		// TODO Auto-generated method stub
		CodeMetric m = new CodeMetric();
		m.setName("Cantidad de líneas comentadas");
		m.setValue(String.valueOf(this.mNumberOfCommentedLines));
		return m;
	}

}
