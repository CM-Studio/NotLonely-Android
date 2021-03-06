package com.efan.notlonely_android.view.SpinKit.style;

import android.animation.ValueAnimator;

import com.efan.notlonely_android.view.SpinKit.animation.SpriteAnimatorBuilder;
import com.efan.notlonely_android.view.SpinKit.sprite.CircleSprite;
import com.efan.notlonely_android.view.SpinKit.sprite.CircleSpriteGroup;
import com.efan.notlonely_android.view.SpinKit.sprite.Sprite;


/**
 * Created by ybq.
 */
public class FadingCircle extends CircleSpriteGroup {

    @Override
    public Sprite[] onCreateChild() {
        Dot[] dots = new Dot[12];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new Dot();
            dots[i].setAnimationDelay(100 * i + -1200);
        }
        return dots;
    }

    class Dot extends CircleSprite {

        public Dot() {
            setAlpha(0);
        }

        @Override
        public ValueAnimator getAnimation() {
            float fractions[] = new float[]{0f, 0.39f, 0.4f, 1f};
            return new SpriteAnimatorBuilder(this).
                    alpha(fractions, 0, 0, 255, 0).
                    duration(1200).
                    easeInOut(fractions).build();
        }
    }
}
