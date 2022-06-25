package com.template;

import android.os.Bundle;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SheetFragment extends Fragment {
    private final static String PAGE_CONTENT = "PAGE_TEXT";

    public static SheetFragment newInstance(CharSequence pageText) {
        SheetFragment sheetFragment = new SheetFragment();
        Bundle args = new Bundle();
        args.putCharSequence(PAGE_CONTENT, pageText);
        sheetFragment.setArguments(args);
        return sheetFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        CharSequence content = getArguments().getCharSequence(PAGE_CONTENT);
        TextView pageTextView = (TextView) inflater.inflate(R.layout.page, container, false);
        pageTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.text_size));
        pageTextView.setText(Html.fromHtml(String.format(getString(R.string.sample_string),content),Html.FROM_HTML_MODE_LEGACY));
        return pageTextView;
    }
}