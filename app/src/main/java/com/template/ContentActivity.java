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
                paint.setTextSize(getResources().getDimension(R.dimen.text_size));
                splitter.append("Умение общаться с другими — не дар, а навык\n" +
                        "\n" +
                        "Это, к сожалению, навык, который редко преподается нам в формальных институтах, таких как школы и университеты.\n" +
                        "\n" +
                        "Несмотря на то, что технологии упростили общение и сделали его более удобным, им удалось изменить ещё и поведение, и мышление людей, и само общение в целом.\n" +
                        "\n" +
                        "Сегодня навыки по выстраиванию коммуникации как никогда актуальны не только на рынке труда, но и в повседневной жизни — как и всегда, впрочем.\n" +
                        "\n" +
                        "Вот, как можно этому научиться. Достаточно лишь поинтересоваться “глубже” приведенными ниже вещами:\n" +
                        "\n" +
                        "— Сострадание и сочувствие — это эмпатия, без которой невозможно выстраивать искренние и доверительные отношения с другими людьми.\n" +
                        "\n" +
                        "— Стремление к служению — это эффективный компонент “секрета общения с людьми”, суть которого заключается в том, что время от времени необходимо отодвигать своё эго на задний план, чтобы удружить другому.\n" +
                        "\n" +
                        "— Присутствие — это означает быть с человеком “в данный момент”. Любая связь с человеком зависит от обоюдной вовлеченности. Поддерживайте отношения и не забывайте других — не путайте с навязыванием. Просто интересуйтесь время от времени и напоминайте о себе.\n" +
                        "\n" +
                        "— Превосходите ожидания — подобно “стремлению к служению”, если вы уж и помогаете кому-то, то позаботьтесь о том, чтобы оправдать и превзойти заложенные на вас надежды. Это моментально набивает ваш вес и цену в глазах другого.\n" +
                        "\n" +
                        "Помните о том, что “чужой человек” — это тот, кто позволит вам раскрывать все свои возможности и открыть для себя новые. Это будущие связи, ресурсы, опыт, смех и хорошие времена.\n" +
                        "\n" +
                        "Никто не преуспевает в одиночестве, а развиваться не одному — сплошное удовольствие, ускоряющее процесс. Не бойтесь социализироваться и поинтересуйтесь литературой на эту тему. Успехов!\n" +
                        "Умение общаться с другими — не дар, а навык\n" +
                        "20-29 — лучшие годы?\n" +
                        "\n" +
                        "Это возраст, в котором человек получает диплом. Он получает то, в необходимости чего его уверили родители. А получает для того, чтобы найти стабильную работу и всегда быть трудоустроенным.\n" +
                        "\n" +
                        "Многие встают со студенческой скамьи и тут же оседают в профессии, которая им не нравится. Они выбирают первую «нормальную работу», где чувствуют себя не так уж и мерзко. Как могло бы быть. Двигаются по гниющей карьерной лестнице.\n" +
                        "\n" +
                        "Начинают жить не по средствам. Не сберегают, не приумножают деньги, а тратят. Берут кредиты, чтобы купить и содержать машину. Влезают в долги, чтобы отправиться в путешествие и живут неразумно отложенным удовольствием, занимаясь 51 неделю в году тем, что им не нравится. Ради чего? Чтобы 3 недели от этого «отдыхать».\n" +
                        "\n" +
                        "Многие женятся, потому что полагают, что «надо». Вступают в брак, поскольку в их жизни ничего не происходит более волнующего и считают, что каких-нибудь 25 — это лучшее время. Больше ведь шансов не будет.\n" +
                        "\n" +
                        "Многие обзаводятся детьми. Хотят купить квартиру, обеспечить семейную жизнь. А это значит, что им нельзя уходить с ненавистной работы, ведь перекрыть кредиты и расходы на жизнь не получится. Становятся финансово скованными…\n" +
                        "\n" +
                        "Причина, по которой говорят что ваши 20 — лучшие годы, таится в одном: в эти годы большинство обзаводятся безопасностью и жизненным укладом, который становится привычкой.\n" +
                        "\n" +
                        "А потом, когда переваливает за 30, жизнь у них заканчивается. «Целей» у них больше нет. Не работают над приобретением новых навыков. Не желают выходить из зоны комфорта. Перестают читать. Перестают учиться. По сути, они перестают жить, проникаясь ритмом неприятного, но такого привычного комфорта бытия. А все оправдания нежеланию меняться сводятся к «я уже слишком стар»\n" +
                        "\n" +
                        "Вышеизложенное является довольно широким обобщением, но суровая реальность жизни в том, что для большинства оно верно. Люди перестают жизнь. Они просто останавливаются, цепляясь за то, что удобно в краткосрочной перспективе и деструктивно в долгосрочной.\n" +
                        "\n" +
                        "Они постоянно оглядываются назад и говорят другим: «твои 20 — лучшие годы в жизни!», поскольку это время, в котором они по-настоящему пытались жить и было интересно.\n" +
                        "\n" +
                        "Но вы, как наши подписчики, просто обязаны знать одну истину. Любые годы вашей жизни способны стать лучшими. Как с этим жить дальше — решайте вы сами. Но большинством, пожалуйста, не становитесь.\n" +
                        "\n" +
                        "Идеальных условий не бывает\n" +
                        "\n" +
                        "Зачастую, когда к нам в голову приходит какая-то интересная идея, мы начинаем много думать. И додумываемся до того, что идея навсегда остаётся лишь идеей, которая попадает в долгий ящик по одной простой причине: нужен подходящий момент.\n" +
                        "\n" +
                        "С таким подходом к жизни, “далеко уехать” не получится. Если ждать наступления идеальных условий, вы так никогда и начнёте работать над тем, чтобы превратить эту идею в какой-то опыт или благо.\n" +
                        "\n" +
                        "А знаете почему? Потому что идеальных условий не бывает. Всегда будет что-нибудь, что будет, как вам покажется, мешать. Либо недостаточно времени, либо лень, либо большая конкуренция, либо ещё что-нибудь — вариантов для оправданий много.\n" +
                        "\n" +
                        "Ну правда, дожидаться идеально подходящего момента — это не самое рациональное решение. Необходимо начинать действовать и решать трудности по мере их возникновения, а не ждать, пока они исчезнут вовсе. Они всего лишь сменятся на другие, которые могут оказаться в десятки раз хуже.\n" +
                        "\n" +
                        "Жизнь устроена так, что обстоятельства меняются и то, что сегодня вам кажется ужасной помехой, завтра вполне себе может показаться настоящей пылинкой.\n" +
                        "\n" +
                        "К примеру, девушка хочет уехать жить в Париж. Она понимает, что для этого ей нужно обойти ряд инстанций, переседеть в очередях и переносит свою мечту на “как-нибудь в другой раз”, ведь сейчас и так забот хватает.\n" +
                        "\n" +
                        "Потом оказывается, что спустя год у неё появляется ребёнок, и, наверняка она будет сожалеть о том, что не уехала за границу раньше, ведь теперь это почти невозможно.\n" +
                        "\n" +
                        "Собственно, друзья, резюмируем: не ждите идеальных условий. Действуйте сейчас. В противном случае ваша задумка может остаться так никогда и нереализованной.", paint);

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