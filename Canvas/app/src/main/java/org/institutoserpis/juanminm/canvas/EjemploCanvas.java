package org.institutoserpis.juanminm.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class EjemploCanvas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        public EjemploView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint pincel = new Paint();
            int i0 = 0;
            int i1 = 1;
            int aux;
            float xc = getWidth() / 2;
            float yc = getHeight() / 2;
            float x0, x1, y0, y1;
            float angle = 180;

            pincel.setColor(Color.BLACK);
            pincel.setStyle(Paint.Style.STROKE);
            pincel.setStrokeWidth(1);

            while (xc - i1 >= 0 && xc + i1 < canvas.getWidth() && yc - i1 >= 0 &&
                    yc + i1 < canvas.getHeight() ) {
                float left = xc - i1;
                float top = yc - i1;
                float right = xc + i1;
                float bot = yc + i1;

                canvas.drawArc(left, top, right, bot, angle, 90, false, pincel);

                aux = i1;
                i1 += i0;
                i0 = aux;

                angle = (angle + 90) % 360;
            }
        }
    }
}
