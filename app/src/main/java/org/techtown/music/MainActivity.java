package org.techtown.music;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {
    ImageButton play;
    MediaPlayer mediaPlayer;
    Boolean click=false;
    SeekBar seekBar;
    ImageButton back;
    ImageButton front;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=findViewById(R.id.button3);
        seekBar=findViewById(R.id.seekBar);
        back=findViewById(R.id.back);
        front=findViewById(R.id.front);
        mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.old_pop);//음악 가져오기
        seekBar.setMax(mediaPlayer.getDuration());//시크바의 최대길이를 음악길이로 설정
        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if(click.equals(false)){
                    play.setImageResource(R.drawable.ic_pause);
                    click=true;
                    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean UserInput) {
                     if(UserInput) mediaPlayer.seekTo(progress);//재생 위치 변경
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });
                    mediaPlayer.start();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (mediaPlayer.isPlaying()){
                                try{
                                    Thread.sleep(1000);
                                }catch (Exception e){
                                    System.out.println("조졌어요");
                                }
                                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                            }
                        }
                    }).start();
                }
                else if(click.equals(true)){
                    play.setImageResource(R.drawable.ic_play_arrow);
                    click=false;
                    mediaPlayer.pause();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()-5000);
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        });
        front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()+5000);
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}