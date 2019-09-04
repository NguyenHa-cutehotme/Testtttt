package com.t3h.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DetailArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_article);
        Article article = (Article) getIntent().getSerializableExtra("Article");
    }
}
