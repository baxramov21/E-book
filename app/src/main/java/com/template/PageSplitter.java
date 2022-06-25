package com.template;


import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.StyleSpan;

import java.util.ArrayList;
import java.util.List;

public class PageSplitter {
    private final int page_width;
    private final int page_height;
    private final float spacingMultiplier;
    private final int spacingExtra;
    private final List<CharSequence> pagesList = new ArrayList<>();
    private SpannableStringBuilder currentLine = new SpannableStringBuilder();
    private SpannableStringBuilder currentPage = new SpannableStringBuilder();
    private int currentLine_height;
    private int pageContent_height;
    private int currentLine_width;
    private int textLine_height;

    public PageSplitter(int page_width, int page_height, float spacingMultiplier, int spacingExtra) {
        this.page_width = page_width;
        this.page_height = page_height;
        this.spacingMultiplier = spacingMultiplier;
        this.spacingExtra = spacingExtra;
    }

    public void append(String text, TextPaint paint) {
        textLine_height = (int) Math.ceil(paint.getFontMetrics(null) * spacingMultiplier + spacingExtra);
        String[] paragraphs = text.split("\n", -1);
        int i;
        for (i = 0; i < paragraphs.length - 1; i++) {
            appendText(paragraphs[i], paint);
            appendNewLine();
        }
        appendText(paragraphs[i], paint);
    }

    private void appendText(String text, TextPaint paint) {
        String[] words = text.split(" ", -1);
        int i;
        for (i = 0; i < words.length - 1; i++) {
            appendWord(words[i] + " ", paint);
        }
        appendWord(words[i], paint);
    }

    private void appendNewLine() {
        currentLine.append("\n");
        checkForEnd();
        appendLineToPage(textLine_height);
    }

    private void checkForEnd() {
        if (pageContent_height + currentLine_height > page_height) {
            pagesList.add(currentPage);
            currentPage = new SpannableStringBuilder();
            pageContent_height = 0;
        }
    }

    private void appendWord(String appendedText, TextPaint paint) {
        int textWidth = (int) Math.ceil(paint.measureText(appendedText));
        if (currentLine_width + textWidth >= page_width) {
            checkForEnd();
            appendLineToPage(textLine_height);
        }
        appendTextToLine(appendedText, paint, textWidth);
    }

    private void appendLineToPage(int textLineHeight) {
        currentPage.append(currentLine);
        pageContent_height += currentLine_height;

        currentLine = new SpannableStringBuilder();
        currentLine_height = textLineHeight;
        currentLine_width = 0;
    }

    private void appendTextToLine(String appendedText, TextPaint paint, int textWidth) {
        currentLine_height = Math.max(currentLine_height, textLine_height);
        currentLine.append(renderToSpannable(appendedText, paint));
        currentLine_width += textWidth;
    }

    public List<CharSequence> getPagesList() {
        List<CharSequence> copyPages = new ArrayList<>(pagesList);
        SpannableStringBuilder lastPage = new SpannableStringBuilder(currentPage);
        if (pageContent_height + currentLine_height > page_height) {
            copyPages.add(lastPage);
            lastPage = new SpannableStringBuilder();
        }
        lastPage.append(currentLine);
        copyPages.add(lastPage);
        return copyPages;
    }

    private SpannableString renderToSpannable(String text, TextPaint paint) {
        SpannableString spannable = new SpannableString(text);

        if (paint.isFakeBoldText()) {
            spannable.setSpan(new StyleSpan(Typeface.BOLD), 0, spannable.length(), 0);
        }
        return spannable;
    }
}
