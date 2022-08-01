package com.template;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextPaint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


public class ContentActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SharedPreferences preferences;
    PageSplitter splitter;
    private TextView textViewPageNumber;
    public static String title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_content);
        viewPager = findViewById(R.id.pages);
        textViewPageNumber = findViewById(R.id.textViewPageOrder);

        if (preferences == null) {
            preferences = PreferenceManager.getDefaultSharedPreferences(this);
        }

        viewPager.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                splitter = new PageSplitter(viewPager.getWidth(), viewPager.getHeight(), 1, -3); // spacing extra 0 kn man vuni ozgartirdim kn yaxshi boldi adi

                TextPaint paint = new TextPaint();
                title = "Добавь титл сюда";
                String content = "Добавь контент сюда";
                paint.setTextSize(getResources().getDimension(R.dimen.text_size));
                splitter.append(content, paint);
                viewPager.setAdapter(new ContentPagerAdapter(getSupportFragmentManager(), splitter.getPagesList()));
                viewPager.setCurrentItem(preferences.getInt("page", 0));
                textViewPageNumber.setText(String.valueOf(preferences.getInt("page", 0) + 1));
                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        preferences.edit().putInt("page", position).apply();
                        textViewPageNumber.setText(String.valueOf(position + 1));
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                    }
                });
                viewPager.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    public void onClickSwitchToPreviousPage(View view) {
        if (preferences.getInt("page", 0) >= 1) {
            viewPager.setCurrentItem(preferences.getInt("page", 0) - 1);
        }

    }

    public void onClickSwitchToNextPage(View view) {
        viewPager.setCurrentItem(preferences.getInt("page", 0) + 1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        int itemId = item.getItemId();
        if (itemId == R.id.about_us) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("About us");
            alertDialog.setIcon(R.drawable.ebook);
            alertDialog.setMessage("App version : 1");
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Close",
                    (dialogInterface, i) -> {
                       alertDialog.cancel();
                    });
            alertDialog.show();
        }
        return true;
    }
}