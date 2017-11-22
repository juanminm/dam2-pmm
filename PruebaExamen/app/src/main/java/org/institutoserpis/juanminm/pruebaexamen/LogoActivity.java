package org.institutoserpis.juanminm.pruebaexamen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new LogoView(this));
    }

    public class LogoView extends View {
        public LogoView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint azulClaroPincel = new Paint();
            Paint azulOscuroPincel = new Paint();
            Paint contornoPincel = new Paint();
            Paint textoPincel = new Paint();
            Path gorroPath = new Path();
            Path cuerpoPath = new Path();
            int cx = getWidth() / 2;

            azulClaroPincel.setARGB(255, 150, 200, 240);
            azulClaroPincel.setStyle(Paint.Style.FILL);
            azulClaroPincel.setStrokeWidth(1);
            contornoPincel.setColor(Color.BLACK);
            contornoPincel.setStyle(Paint.Style.STROKE);
            contornoPincel.setStrokeWidth(2);
            azulOscuroPincel.setARGB(255, 100, 150, 180);
            azulOscuroPincel.setStyle(Paint.Style.FILL);
            azulOscuroPincel.setStrokeWidth(1);
            textoPincel.setColor(Color.BLACK);
            textoPincel.setStrokeWidth(2);
            textoPincel.setTextSize(30);

            gorroPath.moveTo(cx - 75, 200);
            gorroPath.lineTo(cx, 100);
            gorroPath.lineTo(cx + 75, 200);
            gorroPath.close();

            cuerpoPath.moveTo(cx - 50, 325);
            cuerpoPath.lineTo(cx + 50, 325);
            cuerpoPath.lineTo(cx + 75, 500);
            cuerpoPath.lineTo(cx - 75, 500);
            cuerpoPath.close();

            canvas.drawCircle(cx, 250, 75, azulClaroPincel);
            canvas.drawCircle(cx, 250, 75, contornoPincel);
            canvas.drawCircle(cx - 25, 225, 10, azulOscuroPincel);
            canvas.drawCircle(cx - 25, 225, 10, contornoPincel);
            canvas.drawCircle(cx + 25, 225, 10, azulOscuroPincel);
            canvas.drawCircle(cx + 25, 225, 10, contornoPincel);
            canvas.drawArc(cx - 50, 240, cx + 50, 300, 45, 90, false, contornoPincel);
            canvas.drawPath(gorroPath, azulClaroPincel);
            canvas.drawPath(gorroPath, contornoPincel);
            canvas.drawPath(cuerpoPath, azulClaroPincel);
            canvas.drawPath(cuerpoPath, contornoPincel);
            canvas.drawLine(cx - 55, 350, cx - 120, 425, contornoPincel);
            canvas.drawLine(cx + 55, 350, cx + 120, 425, contornoPincel);
            canvas.drawLine(cx - 10, 500, cx - 20, 600, contornoPincel);
            canvas.drawLine(cx + 10, 500, cx + 20, 600, contornoPincel);
            canvas.drawText("InterExpress", cx - 90, 650, textoPincel);
        }
    }
}
