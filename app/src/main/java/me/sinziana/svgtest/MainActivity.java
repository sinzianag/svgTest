package me.sinziana.svgtest;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.IOException;

import me.sinziana.svgtest.svg.SVG;
import me.sinziana.svgtest.svg.SVGBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Load and parse a SVG
        SVG svg = null;
        try {
            svg = new SVGBuilder()
                //    .readFromResource(getResources(), R.raw.someSvgResource) // if svg in res/raw
                    .readFromAsset(getAssets(), "pumpkins.svg")           // if svg in assets
                    // .setWhiteMode(true) // draw fills in white, doesn't draw strokes
                    // .setColorSwap(0xFF008800, 0xFF33AAFF) // swap a single colour
                    // .setColorFilter(filter) // run through a colour filter
                    // .set[Stroke|Fill]ColorFilter(filter) // apply a colour filter to only the stroke or fill
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }

// Draw onto a canvas
        //canvas.drawPicture(svg.getPicture());

// Turn into a drawable
        Drawable drawable = svg.getDrawable();

        ImageView imageView = (ImageView) findViewById(R.id.square);
        imageView.setImageDrawable(drawable);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
