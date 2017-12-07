package edu.sdmesa.headsortails;

import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class CoinActivity extends AppCompatActivity
{
    Button flip;
    ImageView coin;
    Random random;
    int coinSide;

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem menuItem)
    {
        int id = menuItem.getItemId();
        if (id == R.id.menu)
        {

            return true;
        }
        if (id==R.id.setting)
        {
            return true;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin);

        flip = (Button) findViewById(R.id.flip);

        coin = (ImageView) findViewById(R.id.coin);

        random = new Random();

        //BackGround Music
        MediaPlayer player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();
        //coin flipping animation
        flip.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                coinSide = random.nextInt(2);

                if(coinSide == 0)
                {
                    coin.setImageResource(R.drawable.heads);
                    Toast.makeText(CoinActivity.this, "Heads!", Toast.LENGTH_SHORT).show();
                }
                else if(coinSide == 1)
                {
                       coin.setImageResource(R.drawable.tails);
                    Toast.makeText(CoinActivity.this, "Tails!", Toast.LENGTH_SHORT).show();
                }

                RotateAnimation rotate = new RotateAnimation(0, 360,
                        RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);

                rotate.setDuration(1000);
                coin.startAnimation(rotate);
            }
        });
    }
}
