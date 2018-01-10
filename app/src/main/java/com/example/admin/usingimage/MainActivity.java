package com.example.admin.usingimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import top.yunp.androidgame2d.display.Display;
import top.yunp.androidgame2d.display.GameView;
import top.yunp.androidgame2d.display.Image;
import top.yunp.androidgame2d.events.GameViewEvent;
import top.yunp.androidgame2d.events.TouchEvent;
import top.yunp.androidgame2d.tools.BitmapLoader;
import top.yunp.lib.java.event.EventListener;

/**
 * ONE
 * <p>
 * 呈现图片         基于SurfaceView的2D游戏引擎库实现         配置时需要右键打开Open Module Setting去设置
 */
public class MainActivity extends AppCompatActivity {

    private GameView gameView;
    private Image image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView = new GameView(this);
        setContentView(gameView);

        image = new Image(BitmapLoader.loadBitmap(this, R.mipmap.ic_launcher));
        gameView.add(image);

        image.x = 100;
        image.y = 100;
        image.regX = image.getWidth() / 2;
        image.regY = image.getHeight() / 2;

        gameView.enterFrame.add(new EventListener<GameViewEvent, GameView>() {
            @Override
            public boolean onReceive(GameViewEvent event, GameView gameView) {
                image.rotation += 1;
                return false;
            }
        });

        image.touchDown.add(new EventListener<TouchEvent, Display>() {
            @Override
            public boolean onReceive(TouchEvent event, Display display) {
                System.out.println("Touch Down");
                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
