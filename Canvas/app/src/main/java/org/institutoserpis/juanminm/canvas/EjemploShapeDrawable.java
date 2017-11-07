package org.institutoserpis.juanminm.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EjemploShapeDrawable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new VistaAMedida(this));
    }

    public class VistaAMedida extends View {
        private ShapeDrawable miDrawable;

        public VistaAMedida(Context context) {
            super(context);
            int x = 10;
            int y = 10;
            int ancho = 300;
            int alto = 50;

            miDrawable = new ShapeDrawable(new OvalShape());
            miDrawable.getPaint().setColor(0xff0000ff);
            miDrawable.setBounds(x, y, x + ancho, y + alto);
        }

        protected void onDraw(Canvas canvas) {
            miDrawable.draw(canvas);
        }
    }
}
